package Controlador;

import Modelo.Modelo_ventas;
import Vista.Principal;
import Vista.Principal1;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador_Ventas {

    Ventas ven = new Ventas();
    Modelo_ventas mov = new Modelo_ventas();
    Principal1 prin = new Principal1();

    public Controlador_Ventas() {
        ven.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ven.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal(1);

            }

        });
    }

    public void llenarventas() {
        prin.setVisible(false);
        ven.setLocationRelativeTo(null);
        ven.setVisible(true);

        if (e.getSource().equals(prin.getjBventas())) {
            if (ven.getTxtproducto().getText().isEmpty() || ven.getjCtipodepago().getSelectedItem().equals("Seleccionar...") || ven.getTxtdescripcion().getText().isEmpty() || ven.getTxtDocumento().getText().isEmpty());
            JOptionPane.showMessageDialog(null, "Falta de informacion");

        }
    }

}
