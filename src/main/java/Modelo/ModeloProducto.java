package Modelo;

import Controlador.Conexion;
import Vista.Principal;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class ModeloProducto {

    Principal prin = new Principal();

    private String nom, des, ruta;
    private byte imagen[];

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

//    public void buscarImagen() {
//        JFileChooser archivos = new JFileChooser();
//        String rutacarpeta = getClass().getClassLoader().getResource("imgProductos").getPath();
//        File carpeta = new File(rutacarpeta);
//        archivos.setCurrentDirectory(carpeta);
//        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
//
//        archivos.setFileFilter(filtro);
//        if (archivos.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            setRuta(archivos.getSelectedFile().getAbsolutePath());
//        }
//    }

    public byte[] ObtenerImagen(String ruta) {
        try {
            File archivo = new File(ruta);
            byte[] foto = new byte[(int) archivo.length()];
            InputStream img = new FileInputStream(archivo);
            img.read(foto);

            return foto;

        } catch (Exception e) {

            return null;
        }
    }

  public void mostrarTablaProducto(JTable tabla, String valor, String nompesta){
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();
        
         JTableHeader encabeza = tabla.getTableHeader();
        encabeza.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabeza);
        
        
        //Personalizar Celdas
        tabla.setDefaultRenderer(Object.class, new GestionCeldas());
        JButton editar = new JButton();
        JButton eliminar = new JButton();
//         JButton agregar = new JButton();

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png")));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png")));
//          eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png")));
    
      String[] titulo = {"idProducto","nombre","descripcion","cantidad","imagen","precio",""};
        int total = titulo.length;
        if (nompesta.equals("proveedor")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }
      
       DefaultTableModel tablaProducto = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {

                return false;

            }
        };
             String sqlproveedor = valor.isEmpty() ? "SELECT * FROM mostrarproducto" : "call producto_cons('" + valor + "')";

        try {
            String[] dato = new String[titulo.length];
            Statement st = co.createStatement(); //Crea una consulta
            ResultSet rs = st.executeQuery(sqlproveedor);
            while (rs.next()) {
                for (int i = 0; i < titulo.length - 2; i++) {
                    dato[i] = rs.getString(i + 1);
                }
                tablaProducto.addRow(new Object[]{dato[0], dato[1], dato[2], dato[3], dato[4],dato[5], editar, eliminar});
            }
            co.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabla.setModel(tablaProducto);
        //Darle Tamaño a cada Columna
        int cantColum = tabla.getColumnCount();
        int[] ancho = {100, 100, 100, 100,100,100,30,30};
        for (int i = 0; i < cantColum; i++) {
            TableColumn columna = tabla.getColumnModel().getColumn(i);
            columna.setPreferredWidth(ancho[i]);
        }
        conect.cerrarConexion();
    }
    public void limpiar(Component[] panel) {
        for (Object control : panel) {
            if (control instanceof JTextField) {
                ((JTextField) control).setText("");
            }
            if (control instanceof JScrollPane) {
                Component[] limpio = ((JScrollPane) control).getViewport().getComponents();
                for (Object controltext : limpio) {
                    if (controltext instanceof JTextArea) {
                        ((JTextArea) control).setText("");
                    }
                }
            }

        }
    }

    public void insertarProducto() {
        Conexion con = new Conexion();
        Connection cn = con.iniciarConexion();

        String insProducto = "call insertar_producto(?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(insProducto);
            ps.setString(1, getNom());
            ps.setString(2, getDes());
            ps.setBytes(3, getImagen());
            ps.setString(4, getRuta());
            ps.executeUpdate();
            JOptionPane.showConfirmDialog(null, "EXITO");

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void limpiarl(Component[] panel) {
        for (Object control : panel) {
            if (control instanceof JTextField) {
                ((JTextField) control).setText("");
            }
            if (control instanceof JScrollPane) {
                Component[] limpio = ((JScrollPane) control).getViewport().getComponents();
                for (Object controltext : limpio) {
                    if (controltext instanceof JTextArea) {
                        ((JTextArea) control).setText("");
                    }
                }
            }

        }
    }

    public void mostrarTablaProducto1(JTable tabla, String valor, String nompesta) throws SQLException, IOException {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabezado);

        tabla.setDefaultRenderer(Object.class, new GestionCeldas());
        JButton editar = new JButton();
        JButton eliminar = new JButton();
        JButton agregar = new JButton();

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png")));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png")));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png")));

        String[] titulo = {"idproducto", "nombre", "descripcion", "cantidad", "imagen", "precio"};
        int total = titulo.length;
        if (nompesta.equals("producto")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }
        DefaultTableModel tablaProducto = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int colunm) {
                return false;

            }
        };
        String sqlProducto = valor.isEmpty() ? "select * from mostrar_producto" : "call producto_cons('" + valor + "')";

        try {
            String datos[] = new String[total];
            Object dato[] = new Object[total];

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlProducto);
            while (rs.next()) {

                try {
                    byte[] imag = rs.getBytes(5);
                    BufferedImage bfimage = null;
                    InputStream inStr = new ByteArrayInputStream(imag);

                    bfimage = ImageIO.read(inStr);
                    ImageIcon imagen = new ImageIcon(bfimage.getScaledInstance(64, 64, 0));
                    dato[1] = new JLabel(imagen);
                } catch (Exception e) {
                    dato[1] = new JLabel("no image");
                }
                dato[0] = rs.getString(1);
                dato[2] = rs.getString(2);
                dato[3] = rs.getString(3);
                dato[4] = rs.getString(4);
                dato[5] = rs.getString(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
