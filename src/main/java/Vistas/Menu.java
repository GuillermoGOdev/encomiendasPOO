/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    private JMenuItem mmiClientes;
    private JMenuItem mmiTrabajadores;
    private JMenuItem mmiVehiculo;
    private JMenuItem mmiAgencia;
    private String logo_clientes = "/Iconos/agregar-usuario.png";
    private String logo_trabajador = "/Iconos/trabajador.png";
    private String logo_vehiculo = "/Iconos/camion.png";
    Color mColorFondo = new Color(34, 34, 34);

    public Menu() {
        initComponents();
        ///// Maximizar
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema de Distribución de Encomiendas");
        this.setResizable(false);

        ////
        mmiClientes = new JMenuItem(" Clientes ", getIcono(logo_clientes));
        mmiTrabajadores = new JMenuItem(" Trabajador ", getIcono(logo_trabajador));
        mmiVehiculo = new JMenuItem(" Vehiculo ", getIcono(logo_vehiculo));
        mmiAgencia = new JMenuItem(" Agencia ", getIcono(logo_clientes));
        //// COLOR DE BARRA
        Estilo(mmiClientes);
        Estilo(mmiTrabajadores);
        Estilo(mmiVehiculo);
        Estilo(mmiAgencia);
        //// AGREGAR ITEMS
        mbMenu.add(mmiClientes);
        mbMenu.add(mmiTrabajadores);
        mbMenu.add(mmiVehiculo);
        mbMenu.add(mmiAgencia);

//      Llamar interfaces
        mmiClientes.addActionListener((ActionEvent e) -> {

            ModuloClientes clientes = new ModuloClientes();

            clientes.setVisible(true);
        });

        mmiTrabajadores.addActionListener((ActionEvent e) -> {
            ModuloTrabajador trabajador = new ModuloTrabajador();
            trabajador.setVisible(true);
        });

        mmiVehiculo.addActionListener((ActionEvent e) -> {
            ModuloVehiculo vehiculo = new ModuloVehiculo();
            vehiculo.setVisible(true);
        });
        
        mmiAgencia.addActionListener((ActionEvent e) -> {
            ModuloAgencia agencia = new ModuloAgencia();
            agencia.setVisible(true);
        });
//        

    }

    private Icon getIcono(String ruta) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(30, 30, 0));
    }

    public void Estilo(JMenuItem menuItem) {
        menuItem.setOpaque(true);
        menuItem.setBackground(mColorFondo);
        menuItem.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanelPrincipal = new javax.swing.JPanel();
        mbMenu = new javax.swing.JMenuBar();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        mbMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JMenuBar mbMenu;
    // End of variables declaration//GEN-END:variables
}
