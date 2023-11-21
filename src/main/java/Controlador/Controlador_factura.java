
package Controlador;


    

import Modelo.Modelo_factura;
import Vista.Factura;
import Vista.Principal;
import Vista.Principal1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class Controlador_factura {
Factura ft = new Factura();
Principal prin = new Principal();
Modelo_factura moft = new Modelo_factura();

    public Controlador_factura() {
 
     ft.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ft.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal(1);
                
            }

        });
    } 

 public void llenarFactura() {
        prin.setVisible(false);
        ft.setLocationRelativeTo(null);
        ft.setVisible(true);

    

         if (e.getSource().equals(prin.getjBFactura())) {
            if (ft.getTxtfactura().getText().isEmpty()|| ft.getJCseleccionar().getSelectedItem().equals("Seleccionar...")|| ft.getTxtUsuario().getText().isEmpty() || ft.getTxtdescuento().getText().isEmpty()); 
           JOptionPane.showMessageDialog(null, "Falta de informacion");

            }
        }
    }


public class Controlador_factura {
    
}

