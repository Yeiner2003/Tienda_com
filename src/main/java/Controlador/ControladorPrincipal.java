package Controlador;

//import Modelo.ModeloUsuario;
import Modelo.ModeloProducto;
import Modelo.ModeloUsuario;
import Modelo.Modelocliente;
import Vista.Nuevo_Cliente;
import Vista.Nuevo_usuario_vista;
import Vista.P;
import Vista.Principal;
import Vista.Producto;
import Vista.Ventas;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;

public class ControladorPrincipal implements ActionListener, ChangeListener, DocumentListener {

    ModeloUsuario modUsu = new ModeloUsuario();
    Ventas ven = new Ventas();
    P nuev = new P();
    Nuevo_Cliente nue = new Nuevo_Cliente();
    Principal prin = new Principal();
    Nuevo_usuario_vista us = new Nuevo_usuario_vista();
    Producto pro = new Producto();
    ModeloProducto modProd = new ModeloProducto();
    Modelocliente modCli = new Modelocliente();
//    Modelo_ventas ven = new modelo_ventas()

    public ControladorPrincipal() {
        prin.getLblnuevo13().addActionListener(this);
        prin.getJBimg().addActionListener(this);
        prin.getLblnuevo11().addActionListener(this);
        prin.getLblnuevo().addActionListener(this);
        prin.getLblNuevo().addActionListener(this);
        prin.getjBproveedorp().addActionListener(this);
        us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        prin.getJdprincipal().addChangeListener(this);
    }

    public void iniciarPrincipal(int valor) {
        prin.setLocationRelativeTo(null);
        prin.setTitle("Principal");
        prin.setVisible(true);
        prin.setTitle("panel principal| ventana");
        prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        prin.getJdprincipal().setSelectedIndex(valor);
        prin.setVisible(true);
        gestionCliente();
       
    }
    public void gestionCliente(){
        
    }

    

    public void gestionUsuario() {
        int seleccion = prin.getJdprincipal().getSelectedIndex();
        System.out.println("La pestañaesta en la posició " + seleccion);
        if (seleccion == 1) {
            ModeloUsuario modUsu = new ModeloUsuario();
            modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), "", "usuario");
        }
//        ModeloUsuario modUsu = new ModeloUsuario();
        prin.getTXTbuscar().addMouseListener(new MouseAdapter() {
            public void MouseClickd(MouseEvent e) {
                prin.getTXTbuscar().setText("");
                prin.getTXTbuscar().setForeground(Color.BLACK);
            }
        });

        prin.getJTUSUARIO().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getJTUSUARIO().rowAtPoint(e.getPoint());
                int columna = prin.getJTUSUARIO().columnAtPoint(e.getPoint());
                modUsu.setDoc(Integer.parseInt((String) prin.getJTUSUARIO().getValueAt(fila, 1).toString()));
                if (columna == 9) {
                    prin.setVisible(false);
//                    us.
                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(prin.getLblnuevo())) {
            Controlador_usuario con = new Controlador_usuario();
            con.llenarcampos();
        }
        if (e.getSource().equals(prin.getLblNuevo())) {
            Controlador_Cliente con = new Controlador_Cliente();
            con.llenarcamposCliente();

        }
        if (e.getSource().equals(prin.getjBproveedorp())) {
            Controlador_proveedor con = new Controlador_proveedor();
            con.llenarproveedor();

        }
        if (e.getSource().equals(prin.getLblnuevo11())) {

        }
        if (e.getSource().equals(prin.getLblnuevo13())) {
            modProd.buscarImagen();
            File file = new File(modProd.getRuta());
            String archivo = file.getName();
            prin.getTxtimg().setText(archivo);

        }
        if (e.getSource().equals(prin.getJBimg())) {
            modProd.setNom(prin.getTxtnom().getText());
            modProd.setDes(prin.getTXTdescrip().getText());
            modProd.setImagen(modProd.ObtenerImagen(modProd.getRuta()));
        }
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

  

    @Override
    public void stateChanged(ChangeEvent e) {
        int seleccion = prin.getJdprincipal().getSelectedIndex();
        System.out.println("La pestañaesta en la posició " + seleccion);
        if (seleccion == 1) {
            ModeloUsuario modUsu = new ModeloUsuario();
            modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), "", "usuario");
        }
        ModeloUsuario modUsu = new ModeloUsuario();
        prin.getTXTbuscar().addMouseListener(new MouseAdapter() {
            public void MouseClickd(MouseAdapter e) {
                prin.getTXTbuscar().setText("color BLACK");
            }
        });

        prin.getJTUSUARIO().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getJTUSUARIO().rowAtPoint(e.getPoint());
                int columna = prin.getJTUSUARIO().columnAtPoint(e.getPoint());
                modUsu.setDoc(Integer.parseInt((String) prin.getJTUSUARIO().getValueAt(fila, 1).toString()));

                if (columna == 9) {
                    prin.setVisible(false);
                    us.actualizarUsuario(modUsu.getDoc());
                }

            }
        });
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), prin.getTXTbuscar().getText(), "usuario");

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), prin.getTXTbuscar().getText(), "usuario");

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), prin.getTXTbuscar().getText(), "usuario");
    }

        }
