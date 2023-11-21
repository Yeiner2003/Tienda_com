package Controlador;

import Modelo.ModeloUsuario;
import Modelo.Modelocliente;
import Vista.Nuevo_Cliente;
import Vista.Principal;
import Vista.Principal1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador_Cliente implements ActionListener {

    Nuevo_Cliente nue = new Nuevo_Cliente();
    Principal1 prin = new Principal1();
    Modelocliente mod = new Modelocliente();

    public Controlador_Cliente() {

        nue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nue.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal(1);
            }

        });
    }

    public void llenarcamposCliente() {
        //   us.addWindowListener(l);
        prin.setVisible(false);
        nue.setLocationRelativeTo(null);
        nue.setVisible(true);

        nue.getjCSexo().addItem("seleccione");
        Map<String, Integer> dato = mod.llenarCombo();
        for (String sexo : dato.keySet()) {
            nue.getjCSexo().addItem(sexo);
        }

    }

    public void gestionCliente() {

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
//
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nue.getjBGuardarC())) {
            if (nue.getLblDocumento().getText().isEmpty()
                    || nue.getLblNombre().getText().isEmpty()
                    || nue.getLblTelefono().getText().isEmpty()
                    || nue.getTxtCorreo().getText().isEmpty()
                    || nue.getLblDocumento().getText().isEmpty()
                    || nue.getjCSexo().getSelectedItem().equals("seleccione...")
                    || nue.getjDateChooserFECHA().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Falta de informacion");
            }

        } else {
            String valorSexo = nue.getjCSexo().getSelectedItem().toString();
//            int sexo = mod.llenarCombo("sexo").get(valorSexo);

        }
        if (e.getSource().equals(nue.getjBCancelarC())) {
            nue.dispose();
        }

    }
}
