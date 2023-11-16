package Controlador;

//import Modelo.ModeloUsuario;
import Modelo.ModeloProducto;
import Modelo.ModeloUsuario;
import Modelo.Modelo_factura;
import Modelo.Modelo_ventas;
import Modelo.Modelocliente;
import Modelo.Modeloproveedor;
import Vista.Factura;
import Vista.Nuevo_Cliente;
import Vista.Nuevo_producto;
import Vista.Nuevo_usuario_vista;
import Vista.P;
import Vista.Principal;
import Vista.Producto;
import Vista.Ventas;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ControladorPrincipal implements ActionListener, ChangeListener, DocumentListener {
    
    Modeloproveedor mop = new Modeloproveedor();
    ModeloUsuario modUsu = new ModeloUsuario();
    Ventas ven = new Ventas();
    P nuev = new P();
    Nuevo_Cliente nue = new Nuevo_Cliente();
    Principal prin = new Principal();
    Nuevo_usuario_vista us = new Nuevo_usuario_vista();
    Producto pro = new Producto();
    ModeloProducto modProd = new ModeloProducto();
    Modelocliente modCli = new Modelocliente();
    Modelo_factura fac = new Modelo_factura();
    Modelo_ventas vent = new Modelo_ventas();
    Factura fact = new Factura();
    Nuevo_producto nvp = new Nuevo_producto();
    
    
    
    
    public ControladorPrincipal() {
        prin.getJdprincipal().addChangeListener(this);
        prin.getjBventas().addActionListener(this);
        prin.getjBFactura().addActionListener(this);
        prin.getjBproducto().addChangeListener(this);
        prin.getJBimg().addActionListener(this);
        prin.getLblnuevo().addActionListener(this);
        prin.getLblNuevo().addActionListener(this);
        prin.getjBproveedorp().addActionListener(this);
        fact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nvp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    

    public void iniciarPrincipal(int valor) {
        prin.setLocationRelativeTo(null);
        prin.setTitle("Principal");
        prin.setVisible(true);
        prin.setTitle("panel principal| ventana");
        prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        prin.getJdprincipal().setSelectedIndex(valor);
        prin.setVisible(true);
        gestionCliente();

    }

    public void gestionCliente() {
        modCli.mostrarTablacliente(prin.getjTCliente(), "", "cliente");

    }
     public void gestionFactura() {
        fac.mostrarTablaFactura(prin.getjTFactura(), "", "factura");

    }

    public void gestionVentas() {
       vent.mostrarTablaVentas(prin.getjTVentas(), "", "ventas");

    }
    
    public void gestionProducto() {
        modProd.mostrarTablaProducto(prin.getjTproducto(), "", "producto");

    }


    public void gestionProveedor() {
        mop.mostrarTablaProveedor(prin.getjTProveedor(), "", "proveedor");

    }

    public void gestionUsuario() {
        ModeloUsuario modUsu = new ModeloUsuario();
        modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), "", "usuario");

//        ModeloUsuario modUsu = new ModeloUsuario();
        prin.getTXTbuscar().addMouseListener(new MouseAdapter() {
            public void MouseClickd(MouseEvent e) {
                prin.getTXTbuscar().setText("");
                prin.getTXTbuscar().setForeground(Color.BLACK);
            }
        });

        prin.getJTUSUARIO().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getJTUSUARIO().rowAtPoint(e.getPoint());
                int columna = prin.getJTUSUARIO().columnAtPoint(e.getPoint());
                modUsu.setDoc(Integer.parseInt((String) prin.getJTUSUARIO().getValueAt(fila, 1).toString()));
                if (columna == 9) {
                    prin.setVisible(false);
//                    us.
                }

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
       if (e.getSource().equals(prin.getjBproducto())) {
            Controlador_Producto con = new Controlador_Producto();
            con.llenarProducto();
       }
        if (e.getSource().equals(prin.getjBFactura())) {
            Controlador_factura con = new Controlador_factura();
            con.llenarFactura();
       }
          if (e.getSource().equals(prin.getjBventas())) {
            Controlador_Ventas con = new Controlador_Ventas();
            con.llenarventas();
       }
       
       
        if (e.getSource().equals(prin.getJBimg())) {
//            modProd.setNom(prin.getTxtnom().getText());
//            modProd.setDes(prin.getTXTdescrip().getText());
//            modProd.setImagen(modProd.ObtenerImagen(modProd.getRuta()));
        }
    }

    public void limpiar(Component[] panel) {
        for (Object control : panel) {
            if (control instanceof JTextField) {
                ((JTextField) control).setText("");
            }
            if (control instanceof JScrollPane) {
                Component[] limpio = ((JScrollPane) control).getViewport().getComponents();
                for (Object controltext : limpio) {
                    if (controltext instanceof JTextArea) {
                        ((JTextArea) control).setText("");
                    }
                }
            }

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int seleccion = prin.getJdprincipal().getSelectedIndex();
        if (seleccion == 0) {
            gestionUsuario();
        }
        if (seleccion == 1) {
            gestionCliente();
        }
         if (seleccion == 2) {
            gestionProveedor();
        }
        if (seleccion == 3) {
            gestionVentas();
        }
         if (seleccion == 4) {
            gestionFactura();
        }
         if (seleccion == 5) {
            gestionProducto();
        }  
      


        prin.getJTUSUARIO().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = prin.getJTUSUARIO().rowAtPoint(e.getPoint());
                int columna = prin.getJTUSUARIO().columnAtPoint(e.getPoint());
                modUsu.setDoc(Integer.parseInt((String) prin.getJTUSUARIO().getValueAt(fila, 1).toString()));

                if (columna == 9) {
                    prin.setVisible(false);
                    us.actualizarUsuario(modUsu.getDoc());
                }

            }
        });
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), prin.getTXTbuscar().getText(), "usuario");

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), prin.getTXTbuscar().getText(), "usuario");

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        modUsu.mostrarTablaUsuario(prin.getJTUSUARIO(), prin.getTXTbuscar().getText(), "usuario");
    }

}
