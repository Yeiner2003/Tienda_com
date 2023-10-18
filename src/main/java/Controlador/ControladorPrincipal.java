package Controlador;

import Modelo.ModeloUsuario;
import Modelo.Modelocliente;
import Modelo.Modeloproveedor;
import Vista.Nuevo_Cliente;
import Vista.Nuevo_Proveedor;
import Vista.Nuevo_usuario_vista;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class ControladorPrincipal implements ActionListener {

    Nuevo_Proveedor nuev = new Nuevo_Proveedor();
//    Modelocliente mod = new Modelocliente();
    Modeloproveedor prov = new Modeloproveedor();
    Nuevo_Cliente nue = new Nuevo_Cliente();
    ModeloUsuario usu = new ModeloUsuario();
    Principal prin = new Principal();
    Nuevo_usuario_vista us = new Nuevo_usuario_vista();

    public ControladorPrincipal() {
        prin.getLblnuevo().addActionListener(this);
        prin.getLblNuevo().addActionListener(this);
        prin.getjBproveedorp().addActionListener(this);
        us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void iniciarPrincipal() {
        prin.setLocationRelativeTo(null);
        prin.setTitle("Principal");
        prin.setVisible(true);
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

}
