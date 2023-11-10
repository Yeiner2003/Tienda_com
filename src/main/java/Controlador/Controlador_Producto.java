/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloProducto;
import Vista.Principal;
import Vista.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author SENA
 */
public class Controlador_Producto implements ActionListener {

    Principal prin = new Principal();
    Producto pro = new Producto();
    ModeloProducto modProd = new ModeloProducto();

    public void Iniciarproducto() {
        pro.setVisible(true);
        prin.setLocationRelativeTo(null);
        pro.setVisible(false);

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(prin.getLblnuevo13())) {
            modProd.buscarImagen();
            File file = new File(modProd.getRuta());
            String archivo = file.getName();
            prin.getTxtimg().setText(archivo);

        }
     
        if (e.getSource().equals(prin.getJBimg())) {
            modProd.setNom(prin.getTxtnom().getText());
            modProd.setDes(prin.getTXTdescrip().getText());
            modProd.setImagen(modProd.ObtenerImagen(modProd.getRuta()));
        }

    }
}
