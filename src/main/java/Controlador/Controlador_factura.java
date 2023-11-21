package Controlador;

import Modelo.ModeloUsuario;
import Modelo.Modelo_factura;
import Vista.Factura;
import Vista.Nuevo_usuario_vista;
import Vista.Principal;

public class Controlador_factura {

    Factura ft = new Factura();
    Principal prin = new Principal();
    Modelo_factura moft = new Modelo_factura();

    public Controlador_factura() {

    }

    public void buscar(String buscar) {
        if (buscar.equals("usuario")) {
            Nuevo_usuario_vista busUsu = new Nuevo_usuario_vista();
            Modelo.ModeloUsuario modUsu = new ModeloUsuario();
            modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), "", buscar);
            System.out.println("factura Usuario");
            busUsu.setLocationRelativeTo(null);
            busUsu.setVisible(true);

            busUsu.setLocationRelativeTo(null);
            busUsu.setVisible(true);
        }
    }
}
