package Controlador;

import Modelo.Modelocliente;
import Vista.Nuevo_Cliente;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador_Cliente implements ActionListener {

    Nuevo_Cliente nue = new Nuevo_Cliente();
    Principal prin = new Principal();
    Modelocliente mod = new Modelocliente();

    public Controlador_Cliente() {
        
        nue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nue.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal();
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
    }

}
