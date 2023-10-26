package Controlador;

//import Modelo.ModeloUsuario;
import Modelo.ModeloUsuario;
import Vista.Nuevo_Cliente;
import Vista.Nuevo_usuario_vista;
import Vista.P;
import Vista.Principal;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;

public class ControladorPrincipal implements ActionListener, ChangeListener {

    Ventas ven = new Ventas();
    P nuev = new P();
    Nuevo_Cliente nue = new Nuevo_Cliente();
    Principal prin = new Principal();
    Nuevo_usuario_vista us = new Nuevo_usuario_vista();

    public ControladorPrincipal() {
        prin.getLblnuevo11().addChangeListener(this);
        prin.getLblnuevo().addActionListener(this);
        prin.getLblNuevo().addActionListener(this);
        prin.getjBproveedorp().addActionListener(this);
        us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        prin.getJdprincipal().addChangeListener(this);
    }

    public void iniciarPrincipal() {
        prin.setLocationRelativeTo(null);
        prin.setTitle("Principal");
        prin.setVisible(true);
        prin.setTitle("panel principal| ventana");
        prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
    
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int seleccion = prin.getJdprincipal().getSelectedIndex();
        System.out.println("La pestañaesta en la posició " + seleccion);
        if (seleccion == 1) {
            ModeloUsuario modUsu = new ModeloUsuario();
            modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), "");
        }
        ModeloUsuario modUsu = new ModeloUsuario();
        prin.getTXTbuscar().addMouseListener(new MouseAdapter() {
            public void MouseClickd(MouseAdapter e) {
                prin.getTXTbuscar().setText("color BLACK");
            }
        });
//        prin.getTXTbuscar().getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                modUsu.mostrarTablaUsuario(prin.getJpUsuario(), prin.getTXTbuscar().getText());
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                modUsu.mostrarTablaUsuario(prin.getJpUsuario(), prin.getTXTbuscar().getText());
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                modUsu.mostrarTablaUsuario(prin.getJpUsuario(), prin.getTXTbuscar().getText());
//            }

//        });
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

}
