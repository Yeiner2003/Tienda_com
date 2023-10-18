package Controlador;

import Modelo.Modeloproveedor;
import Vista.Nuevo_Proveedor;
import Vista.Nuevo_usuario_vista;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador_proveedor implements ActionListener {

    Nuevo_Proveedor nuev = new Nuevo_Proveedor();
    Principal prin = new Principal();
    Modeloproveedor prov = new Modeloproveedor();
    Nuevo_usuario_vista vista = new Nuevo_usuario_vista();

    public Controlador_proveedor() {
        vista.setDefaultCloseOperation(0);
        nuev.setDef
        nuev.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal();
            }

        });
    }
        public void llenarproveedor(){
        prin.setVisible(false);
        nuev.setLocationRelativeTo(null);
        nuev.setVisible(true);
        nuev.getjCSexop().addItem("seleccione");
        Map<String, Integer> dato = prov.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            nuev.getjCSexop().addItem(sexo);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(nuev.getJBGuardarp())) {
            if (nuev.getJcdocumentop().getText().isEmpty() || nuev.getLblNombrP().getText().isEmpty() || nuev.getLblNombrP().getText().isEmpty() || nuev.getLblCorreoP().getText().isEmpty() || nuev.getLblDireccionp().getText().isEmpty() || nuev.getjCSexop().getSelectedItem().equals("seleccione...") || nuev.getjDfechap().getDate() == null || nuev.getLblTipodepersona().getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Falta de informacion");

            }
        }
    }
}