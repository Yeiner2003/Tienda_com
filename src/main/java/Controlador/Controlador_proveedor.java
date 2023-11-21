package Controlador;

import Modelo.Modeloproveedor;
//import Vista.Nuevo_Proveedor;
import Vista.Nuevo_usuario_vista;
import Vista.P;
import Vista.Principal;
import Vista.Principal1;
//import Vista.Proveedor_nuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.sql.SQLException;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador_proveedor implements ActionListener {

    P nuev = new P();
    Principal1 prin = new Principal1();
    Modeloproveedor prov = new Modeloproveedor();
    Nuevo_usuario_vista vista = new Nuevo_usuario_vista();

    public Controlador_proveedor() {
        nuev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuev.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal(1);
            }

        });
    }

    public void llenarproveedor() {
        prin.setVisible(false);
        nuev.setLocationRelativeTo(null);
        nuev.setVisible(true);
        nuev.getjCSexo().addItem("seleccione");
////        Map<String, Integer> dato = prov.llenarCombo("sexo");
//        for (String sexo : dato.keySet()) {
//            nuev.getjCSexo().addItem(sexo);
//        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(nuev.getjBGuardar())) {
            if (nuev.getLblDocumento().getText().isEmpty() || nuev.getLblNombre().getText().isEmpty() || nuev.getLblTelefono().getText().isEmpty() || nuev.getLblDireccion().getText().isEmpty() || nuev.getLblDireccion().getText().isEmpty() || nuev.getjCSexo().getSelectedItem().equals("seleccione...") || nuev.getjDFecha().getDate() == null || nuev.getLbltipoPersona().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta de informacion");

            }
            if (e.getSource().equals(nuev.getjBCancelar())) {
                nuev.dispose();
            }
        }
    }
}
