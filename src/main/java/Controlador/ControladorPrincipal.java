package Controlador;

//import Modelo.ModeloUsuario;
import Modelo.ModeloUsuario;
import Vista.Nuevo_Cliente;
import Vista.Nuevo_usuario_vista;
import Vista.P;
import Vista.Principal;
import Vista.Ventas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;

public class ControladorPrincipal implements ActionListener, ChangeListener, DocumentListener{
    ModeloUsuario modUsu = new ModeloUsuario ();
    Ventas ven = new Ventas();
    P nuev = new P();
    Nuevo_Cliente nue = new Nuevo_Cliente();
    Principal prin = new Principal();
    Nuevo_usuario_vista us = new Nuevo_usuario_vista();

    public ControladorPrincipal() {
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
        gestionpanel();
    }

    public void gestionpanel() {
        if (prin.getJdprincipal().getSelectedIndex() == 0) {

        }
        prin.getJdprincipal().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }

        });
    }
     public void gestionUsuario(){
       int seleccion = prin.getJdprincipal().getSelectedIndex();
        System.out.println("La pestañaesta en la posició " + seleccion);
        if (seleccion == 1) {
            ModeloUsuario modUsu = new ModeloUsuario();
            modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), "","usuaeio");
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
            Controlador_Ventas con = new Controlador_Ventas();
            con.llenarventas();
          }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int seleccion = prin.getJdprincipal().getSelectedIndex();
        System.out.println("La pestañaesta en la posició " + seleccion);
        if (seleccion == 1) {
            ModeloUsuario modUsu = new ModeloUsuario();
            modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), "","usuario");
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
