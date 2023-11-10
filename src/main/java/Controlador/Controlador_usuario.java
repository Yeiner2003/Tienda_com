package Controlador;

import Modelo.ModeloUsuario;
import Vista.Nuevo_usuario_vista;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador_usuario implements ActionListener {

    Nuevo_usuario_vista us = new Nuevo_usuario_vista();
    Principal prin = new Principal();
    ModeloUsuario usu = new ModeloUsuario();

    public Controlador_usuario() {
        us.getLblguardar().addActionListener(this);
        us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        us.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princi = new ControladorPrincipal();
                princi.iniciarPrincipal(1);
            }

        });
    }

    public void llenarcampos() {
        //   us.addWindowListener(l);
        prin.setVisible(false);
        us.setLocationRelativeTo(null);
        us.setVisible(true);
        //llenar sexo combobox sexo 
        us.getjComboBox1().addItem("seleccione");
        Map<String, Integer> dato = usu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            us.getjComboBox1().addItem(sexo);
        }

        us.getjComboBox2().addItem("seleccione");
        Map<String, Integer> datos = usu.llenarCombo("rol");
        for (String rol : dato.keySet()) {
            us.getjComboBox2().addItem(rol);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(us.getLblguardar())) {
            if (us.getTxtdocumento().getText().isEmpty() || us.getTxtnombre().getText().isEmpty() || us.getTxttelefono().getText().isEmpty() || us.getTxtcorreo().getText().isEmpty() || us.getTxtdireccion().getText().isEmpty() || us.getjComboBox1().getSelectedItem().equals("seleccione...") || us.getjComboBox2().getSelectedItem().equals("seleccione...") || us.getjDateChooser1().getDate() == null || us.getTxtLogin().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Falta de informacion");

            } else {

                String valorSexo = us.getjComboBox1().getSelectedItem().toString();
                int sexo = usu.llenarCombo("sexo").get(valorSexo);

                String valorRol = us.getjComboBox2().getSelectedItem().toString();
                int Rol = usu.llenarCombo("Rol").get(valorRol);
                // convierte a formato de fecha que entiende sql
                java.util.Date fec = us.getjDateChooser1().getDate();
                long fe = fec.getTime();
                java.sql.Date fecha = new Date(fe);

                // contraseña
                char[] contra = us.getjPcontra().getPassword();
                String contraseña = String.valueOf(contra);

                usu.setDoc(Integer.parseInt(us.getTxtdocumento().getText()));
                usu.setNom(us.getTxtnombre().getText());
                usu.setFec(fecha);
                usu.setNom(us.getTxtnombre().getText());
                usu.setFec(fecha);
                usu.setDir(us.getTxtdireccion().getText());
                usu.setTec(us.getTxttelefono().getText());
                usu.setCor(us.getTxtcorreo().getText());
                usu.setLo(us.getTxtLogin().getText());
                usu.setCl(us.getLblclave().getText());
                usu.setSex(sexo);
                usu.setRol(Rol);
                if (us.getjButton1().getText().equals("guardar")) {
                    usu.mostrarTablaUsuario();
                    usu.Limpiar(us.getjButton1().getComponents());
                } else {
                    us.actualizarUsuario(Rol);
                    us.setVisible(false);
                    us.dispose();

                }
            }
        }
        if (e.getSource().equals(us.getjButton2())) {
            us.dispose();
        }
    }

    void actualizarUsuario(int doc) {
        usu.BuscarUsuario(doc);
        us.getTxtdocumento().setEnabled(false);
        us.getTxtLogin().setEnabled(false);
        us.getjComboBox1().setEnabled(false);
        us.getTxtdocumento().setText(String.valueOf(doc));
        us.getTxtcorreo().setText(usu.getCor());
        us.getTxtnombre().setText(usu.getNom());
        us.getTxtdireccion().setText(usu.getDir());
        us.getTxttelefono().setText(usu.getTec());
        us.getTxtLogin().setText(usu.getLo());
        us.getjPcontra().setText(usu.getCl());
        us.getjDateChooser1().setDate(usu.getFec());

        Map<String, Integer> dato = usu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            us.getjComboBox1().addItem(sexo);

            String valoSexo = usu.obtenerSeleccion(dato, usu.getSex());
            us.getjComboBox1().setSelectedItem(valoSexo);

            Map<String, Integer> datos = usu.llenarCombo("Rol");
            for (String Rol : dato.keySet()) {
                us.getjComboBox1().addItem(Rol);
            }
            String valorRol = usu.obtenerSeleccion(dato, usu.getRol());
            us.getjComboBox2().setSelectedItem(valorRol);

            Map<String, Integer> datoT = usu.llenarCombo("tipodoc");
            for (String Tipo : datoT.keySet()) {
                us.getjComboBox1().addItem(Tipo);
            }
            String valorTipo = usu.obtenerSeleccion(datoT, usu.getTip());
            us.getjComboBox1().setSelectedItem(valorTipo);
            prin.setVisible(false);
            us.setLocationRelativeTo(null);
            us.getjButton1().setText("actualiza");
            us.setVisible(true);
        }
//       void EliminarUsuario (int doc ){
//                 int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al usuario? \n" + doc, "Eliminar Usuario", JOptionPane.YES_OPTION);
//            if (resp == JOptionPane.YES_OPTION) {
//                usu.setDoc(doc);
//                usu.EliminarUsuario();
//                usu.mostrarTablaUsuario(prin.getJTUSUARIO(), "", "usuario");
//
//            }
//        }
    }
}
