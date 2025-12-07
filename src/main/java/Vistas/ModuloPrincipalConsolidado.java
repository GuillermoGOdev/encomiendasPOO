/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import DAO.DespachoDAO;
import DAO.VehiculoDAO;
import DTO.Vehiculo;
import Util.Design_JTable;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vivas
 */
public class ModuloPrincipalConsolidado extends javax.swing.JFrame {

    VehiculoDAO vehiculo = new VehiculoDAO();
    Design_JTable design_table = new Design_JTable();

    public ModuloPrincipalConsolidado() {
        initComponents();
        cargarVehiculosCombo();
//        llenarTablaDespacho();
        LlenarTabla();
    }

/////////// Cargar Placas ////////////
    private void cargarVehiculosCombo() {
        DefaultComboBoxModel<Vehiculo> modelo = new DefaultComboBoxModel<>();
        Vehiculo opcion = new Vehiculo();
        opcion.setIdVehiculo(0);
        opcion.setPlaca("Seleccionar");
        modelo.addElement(opcion);
        for (Vehiculo v : vehiculo.listarVehiculosCombo()) {
            modelo.addElement(v);
        }

        cboPlaca.setModel(modelo);
    }

//    private void llenarTablaDespacho() {
//
//        DespachoDAO dao = new DespachoDAO();
//
//        // Para cargar todo sin filtros:
//        tablaDespacho.setModel(dao.listarDespacho(null, null));
//    }
    private void LlenarTabla() {

        // Obtener la placa desde el combo
        Vehiculo veh = (Vehiculo) cboPlaca.getSelectedItem();
        String placa = null;

        if (veh != null && !veh.getPlaca().equals("Seleccionar")) {
            placa = veh.getPlaca();
        }

        // Obtener fecha desde el jDateChooser
        java.sql.Date fechaSQL = null;
        if (jdcFecha.getDate() != null) {
            fechaSQL = new java.sql.Date(jdcFecha.getDate().getTime());
        }

        // Llamar al DAO
        DespachoDAO dao = new DespachoDAO();
        tablaDespacho.setModel(dao.listarDespacho(placa, fechaSQL));
        design_table.ocultarColumnas(tablaDespacho, 0);
        design_table.ocultarColumnas(tablaDespacho, 1);
        design_table.ocultarColumnas(tablaDespacho, 11);
        design_table.ocultarColumnas(tablaDespacho, 4);
        design_table.ocultarColumnas(tablaDespacho, 5);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cboPlaca = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDespacho = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAgregarEncomiendas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Vehiculo:");
        jLabel12.setToolTipText("DNI");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 70, 20));

        cboPlaca.setBorder(null);
        cboPlaca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(cboPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 190, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha de Salida:");
        jLabel15.setToolTipText("DNI");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 240, 20));

        tablaDespacho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaDespacho);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 920, 310));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Módulo Despacho");
        jLabel5.setToolTipText("DNI");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/camion_1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 40, 30));
        jPanel2.add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 190, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 100, 30));

        jButton1.setText("Editar");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        btnAgregarEncomiendas.setText("Agregar Encomiendas");
        btnAgregarEncomiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEncomiendasActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarEncomiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jButton4.setText("Eliminar");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jButton2.setText("Actualizar Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 694, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        LlenarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ModuloConsolidado vista = new ModuloConsolidado();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAgregarEncomiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEncomiendasActionPerformed
        int fila = tablaDespacho.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
            return;
        }

        // Obtener datos de la fila
        int idConsolidado = Integer.parseInt(tablaDespacho.getValueAt(fila, 0).toString());
        int idRuta = Integer.parseInt(tablaDespacho.getValueAt(fila, 1).toString());
        String ruta = tablaDespacho.getValueAt(fila, 2).toString();
        String placa = tablaDespacho.getValueAt(fila, 3).toString();
        double capacidadKg = Double.parseDouble(tablaDespacho.getValueAt(fila, 4).toString());
        double capacidadVolumen = Double.parseDouble(tablaDespacho.getValueAt(fila, 5).toString());
        double kg_comprometido = Double.parseDouble(tablaDespacho.getValueAt(fila, 6).toString());
        double volumenComprometido = Double.parseDouble(tablaDespacho.getValueAt(fila, 7).toString());
        int cantpaq = Integer.parseInt(tablaDespacho.getValueAt(fila, 8).toString());
        String conductor = tablaDespacho.getValueAt(fila, 9).toString();
        Date fechaSalida = (Date) tablaDespacho.getValueAt(fila, 10); // si usas java.util.Date o java.sql.Date

        // Crear ventana y enviar datos
        ModuloAsignarEncomiendas ventana = new ModuloAsignarEncomiendas();
        ventana.setDatos(idConsolidado, idRuta, ruta, placa, capacidadKg, capacidadVolumen,
                kg_comprometido, volumenComprometido, cantpaq,
                conductor, fechaSalida);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnAgregarEncomiendasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LlenarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ModuloPrincipalConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloPrincipalConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloPrincipalConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloPrincipalConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloPrincipalConsolidado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEncomiendas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Vehiculo> cboPlaca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable tablaDespacho;
    // End of variables declaration//GEN-END:variables
}
