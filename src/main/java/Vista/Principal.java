/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author SENA
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    public JButton getLblnuevo() {
        return lblnuevo;
    }

    public void setLblnuevo(JButton lblnuevo) {
        this.lblnuevo = lblnuevo;
    }

    public JButton getLblNuevo() {
        return lblNuevo;
    }

    public void setLblNuevo(JButton lblNuevo) {
        this.lblNuevo = lblNuevo;
    }

    public JButton getjBproveedorp() {
        return jBproveedorp;
    }

    public void setjBproveedorp(JButton jBproveedorp) {
        this.jBproveedorp = jBproveedorp;
    }

    public JTabbedPane getJdprincipal() {
        return jdprincipal;
    }

    public void setJdprincipal(JTabbedPane jdprincipal) {
        this.jdprincipal = jdprincipal;
    }

    public JTextField getTXTbuscar() {
        return TXTbuscar;
    }

    public void setTXTbuscar(JTextField TXTbuscar) {
        this.TXTbuscar = TXTbuscar;
    }

    public JPanel getJpUsuario() {
        return jpUsuario;
    }

    public void setJpUsuario(JPanel jpUsuario) {
        this.jpUsuario = jpUsuario;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdprincipal = new javax.swing.JTabbedPane();
        jpUsuario = new javax.swing.JPanel();
        lblnuevo = new javax.swing.JButton();
        TXTbuscar = new javax.swing.JTextField();
        Btlupa = new javax.swing.JButton();
        jpcliente = new javax.swing.JPanel();
        lblNuevo = new javax.swing.JButton();
        jPproveedor = new javax.swing.JPanel();
        jBproveedorp = new javax.swing.JButton();
        jPproducto = new javax.swing.JPanel();
        jPfactura = new javax.swing.JPanel();
        lbltienda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblnuevo.setIcon(new javax.swing.ImageIcon("C:\\Users\\SENA\\Documents\\NetBeansProjects\\tienda_com\\src\\main\\resources\\img\\intimidad.png")); // NOI18N
        lblnuevo.setText("Nuevo");

        Btlupa.setIcon(new javax.swing.ImageIcon("C:\\Users\\SENA\\Documents\\NetBeansProjects\\tienda_com\\src\\main\\resources\\img\\lupa.png")); // NOI18N

        javax.swing.GroupLayout jpUsuarioLayout = new javax.swing.GroupLayout(jpUsuario);
        jpUsuario.setLayout(jpUsuarioLayout);
        jpUsuarioLayout.setHorizontalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addComponent(lblnuevo)
                .addGap(121, 121, 121)
                .addComponent(TXTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Btlupa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 179, Short.MAX_VALUE))
        );
        jpUsuarioLayout.setVerticalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btlupa)
                    .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblnuevo)
                        .addComponent(TXTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jdprincipal.addTab("Usuario", jpUsuario);

        lblNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/intimidad.png"))); // NOI18N
        lblNuevo.setText("Nuevo cliente");

        javax.swing.GroupLayout jpclienteLayout = new javax.swing.GroupLayout(jpcliente);
        jpcliente.setLayout(jpclienteLayout);
        jpclienteLayout.setHorizontalGroup(
            jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpclienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNuevo)
                .addContainerGap(535, Short.MAX_VALUE))
        );
        jpclienteLayout.setVerticalGroup(
            jpclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpclienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblNuevo)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jdprincipal.addTab("Cliente", jpcliente);

        jBproveedorp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/intimidad.png"))); // NOI18N
        jBproveedorp.setText("Nuevo proveedor");

        javax.swing.GroupLayout jPproveedorLayout = new javax.swing.GroupLayout(jPproveedor);
        jPproveedor.setLayout(jPproveedorLayout);
        jPproveedorLayout.setHorizontalGroup(
            jPproveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPproveedorLayout.createSequentialGroup()
                .addComponent(jBproveedorp)
                .addGap(0, 522, Short.MAX_VALUE))
        );
        jPproveedorLayout.setVerticalGroup(
            jPproveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPproveedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBproveedorp)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jdprincipal.addTab("proveedor", jPproveedor);

        javax.swing.GroupLayout jPproductoLayout = new javax.swing.GroupLayout(jPproducto);
        jPproducto.setLayout(jPproductoLayout);
        jPproductoLayout.setHorizontalGroup(
            jPproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        jPproductoLayout.setVerticalGroup(
            jPproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        jdprincipal.addTab("Producto", jPproducto);

        javax.swing.GroupLayout jPfacturaLayout = new javax.swing.GroupLayout(jPfactura);
        jPfactura.setLayout(jPfacturaLayout);
        jPfacturaLayout.setHorizontalGroup(
            jPfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        jPfacturaLayout.setVerticalGroup(
            jPfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        jdprincipal.addTab("Factura", jPfactura);

        lbltienda.setForeground(new java.awt.Color(255, 0, 0));
        lbltienda.setText("TIENDA COM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbltienda, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jdprincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltienda, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btlupa;
    private javax.swing.JTextField TXTbuscar;
    private javax.swing.JButton jBproveedorp;
    private javax.swing.JPanel jPfactura;
    private javax.swing.JPanel jPproducto;
    private javax.swing.JPanel jPproveedor;
    private javax.swing.JTabbedPane jdprincipal;
    private javax.swing.JPanel jpUsuario;
    private javax.swing.JPanel jpcliente;
    private javax.swing.JButton lblNuevo;
    private javax.swing.JButton lblnuevo;
    private javax.swing.JLabel lbltienda;
    // End of variables declaration//GEN-END:variables

}
