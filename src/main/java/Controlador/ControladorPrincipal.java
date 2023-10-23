package Controlador;


//import Modelo.ModeloUsuario;
import Modelo.ModeloUsuario;
import Vista.Nuevo_Cliente;
import Vista.Nuevo_usuario_vista;
import Vista.P;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ControladorPrincipal implements ActionListener, ChangeListener{

    P nuev = new P();
    Nuevo_Cliente nue = new Nuevo_Cliente();
    Principal prin = new Principal();
    Nuevo_usuario_vista us = new Nuevo_usuario_vista();

    public ControladorPrincipal() {
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
        prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gestionpanel();
    }

    public void gestionpanel (){
        if (prin.getJdprincipal().getSelectedIndex()==0){
        
        }
        prin.getJdprincipal().addChangeListener(new ChangeListener(){
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
        int seleccion= prin.getJdprincipal().getSelectedIndex();
        System.out.println("La pestañaesta en la posició "+seleccion);
       if (seleccion==1){
           ModeloUsuario modUsu = new ModeloUsuario();
           modUsu.mostrarTablaUsuario(prin.)
       }
        prin.getTXTbuscar().addMouseListener(new MouseAdapter (){
        public void MouseClickd (MouseAdapter e){
            prin.getTXTbuscar().setText("color BLACK");
        }
    });
    }
    
}
   
    


