package Modelo;

import Controlador.Conexion;
import Controlador.ControladorPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Modelocliente {

    Conexion cone = new Conexion();
    Connection cn = cone.iniciarConexion();

    private int doc, sex, rol;
    private String nom, dir, tec, cor, lo, cl;
    private Date fec;

    public Conexion getCone() {
        return cone;
    }

    public void setCone(Conexion cone) {
        this.cone = cone;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTec() {
        return tec;
    }

    public void setTec(String tec) {
        this.tec = tec;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public Map<String, Integer> llenarCombo() {
        String sql = "Select * from mostrar sexo";
        Map<String, Integer> llenar_combo = new HashMap<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                llenar_combo.put(rs.getString(2), rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return llenar_combo;
    }
public void mostrarTablacliente(JTable tabla, String valor, String nompesta){
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
    
      String[] titulo = {"Documento", "Sexo", "Nombre","Telefono","Correo", "Direccion", "Fecha de nacimiento"};
        int total = titulo.length;
        if (nompesta.equals("cliente")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }
      
       DefaultTableModel tablaCliente = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {

                return false;

            }
        };
             String sqlcliente = valor.isEmpty() ? "select * from mostrar_cliente" : "call cliente_cons('" + valor + "')";

        try {
            String[] dato = new String[titulo.length];
            Statement st = co.createStatement(); //Crea una consulta
            ResultSet rs = st.executeQuery(sqlcliente);
            while (rs.next()) {
                for (int i = 0; i < titulo.length - 2; i++) {
                    dato[i] = rs.getString(i + 1);
                }
                tablaCliente.addRow(new Object[]{dato[0],dato[1],dato[2],dato[3],dato[4],dato[5],dato[6],editar,eliminar});

            }
            co.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabla.setModel(tablaCliente);
        //Darle Tamaño a cada Columna
        int cantColum = tabla.getColumnCount();
        int[] ancho = {100, 180, 100, 150, 100, 160,100,30,30};
        for (int i = 0; i < cantColum; i++) {
            TableColumn columna = tabla.getColumnModel().getColumn(i);
            columna.setPreferredWidth(ancho[i]);
        }
        conect.cerrarConexion();
    }


    public void llenarnuevocliente() {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();//instanciamos la conexion
        String sql = "call ins_cliente (?,?,?,?,?,?,?,)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getDoc());
            ps.setString(2, getNom());
            ps.setString(3, getTec());
            ps.setString(4, getCor());
            ps.setString(5, getDir());
            ps.setInt(6, getSex());
            ps.executeUpdate();
            JOptionPane.showConfirmDialog(null, "registro finalisado");
            cn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);

        }
        cone.cerrarConexion();
    }

   
  
}



