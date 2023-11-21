package Controlador;

import Modelo.ModeloProducto;
import Vista.Nuevo_producto;
import Vista.Principal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador_Producto {

    Principal prin = new Principal();
    ModeloProducto Mp = new ModeloProducto();
    Nuevo_producto nuvp = new Nuevo_producto();

    public Controlador_Producto() {

        nuvp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuvp.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal(1);

            }

        });
    }

    public void llenarProducto() {
        prin.setVisible(false);
        nuvp.setLocationRelativeTo(null);
        nuvp.setVisible(true);

        if (e.getSource().equals(prin.getjBventas())) {
            if (nuvp.getTXTdescripcion().getText().isEmpty() || nuvp.getTXTnproducto().getText().isEmpty());
            JOptionPane.showMessageDialog(null, "Falta de informacion");

        }
    }
}
