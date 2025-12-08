/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import DTO.Agencia;
import java.util.List;
import Controladores.*;
import DAO.DespachoDAO;
import DAO.RutaDAO;
import DAO.TrabajadorDAO;
import DAO.VehiculoDAO;
import DTO.Despacho;
import DTO.Ruta;
import DTO.Trabajador;
import DTO.Vehiculo;
import java.awt.Label;
import java.util.Date;
import java.util.HashSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author vivas
 */
public class ModuloConsolidado extends javax.swing.JFrame {
    
    VehiculoDAO vehiculo = new VehiculoDAO();
    RutaDAO rutaDAO = new RutaDAO();
    TrabajadorDAO TrabajadorDAO = new TrabajadorDAO();
    private String modo;
    
    public ModuloConsolidado() {
        initComponents();
        cargarVehiculosCombo();
        cargarRutaCombo();
        cargarChoferesCombo();
        nombrelabel(modo);
        
    }
    
    public void nombrelabel(String nombre) {
        modo = nombre;
        lblModulo.setText(modo);
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
        
        cboVehiculo.setModel(modelo);
    }

    ///// Listar Rutas
    private void cargarRutaCombo() {
        DefaultComboBoxModel<Ruta> modelo = new DefaultComboBoxModel<>();
        Ruta opcion = new Ruta();
        opcion.setIdRuta(0);
        opcion.setDescripcion("Seleccionar");
        modelo.addElement(opcion);
        for (Ruta r : rutaDAO.listar()) {
            modelo.addElement(r);
        }
        cboRuta.setModel(modelo);
    }

    /// Listar choferes 
    private void cargarChoferesCombo() {
        DefaultComboBoxModel<Trabajador> modelo = new DefaultComboBoxModel<>();
        Trabajador opcion = new Trabajador();
        opcion.setIdTrabajador(0);
        opcion.setNombres("Seleccionar");
        opcion.setApellido_paterno("");
        opcion.setApellido_materno("");
        modelo.addElement(opcion);
        for (Trabajador r : TrabajadorDAO.listarConductor()) {
            modelo.addElement(r);
        }
        cboConductor.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cboVehiculo = new javax.swing.JComboBox<>();
        CboAnio1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboConductor = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cboRuta = new javax.swing.JComboBox<>();
        lblModulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        DataChooser = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Vehiculo:");
        jLabel12.setToolTipText("DNI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 70, 20));

        cboVehiculo.setBorder(null);
        cboVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cboVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 190, -1));

        CboAnio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Inactivo" }));
        CboAnio1.setBorder(null);
        CboAnio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(CboAnio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 190, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Chofer:");
        jLabel13.setToolTipText("DNI");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 70, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Estado:");
        jLabel14.setToolTipText("DNI");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 70, 20));

        cboConductor.setBorder(null);
        cboConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cboConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 190, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha de Salida:");
        jLabel15.setToolTipText("DNI");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 240, 20));

        cboRuta.setBorder(null);
        cboRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cboRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 190, -1));

        lblModulo.setBackground(new java.awt.Color(255, 255, 255));
        lblModulo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblModulo.setForeground(new java.awt.Color(255, 255, 255));
        lblModulo.setToolTipText("DNI");
        jPanel1.add(lblModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 22, 230, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/camion_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 40, 30));
        jPanel1.add(DataChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ruta");
        jLabel16.setToolTipText("DNI");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 20));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Capturar IDs de los combos
        Ruta r = (Ruta) cboRuta.getSelectedItem();
        Vehiculo v = (Vehiculo) cboVehiculo.getSelectedItem();
        Trabajador t = (Trabajador) cboConductor.getSelectedItem();
        // Capturar fecha
        Date fecha = DataChooser.getDate();
        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una fecha.");
            return;
        }
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        // Llenar el objeto Despacho
        Despacho d = new Despacho();
        d.setIdruta(r.getIdRuta());
        d.setId_vehiculo(v.getIdVehiculo());
        d.setId_trabajador_conductor(t.getIdTrabajador());
        d.setFecha_salida(fechaSQL);
        d.setEstado("En ruta");

        // Guardar
        DespachoDAO dao = new DespachoDAO();
        if (dao.registrarVehiculo(d)) {
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(ModuloConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloConsolidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloConsolidado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboAnio1;
    private com.toedter.calendar.JDateChooser DataChooser;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Trabajador> cboConductor;
    private javax.swing.JComboBox<Ruta> cboRuta;
    private javax.swing.JComboBox<Vehiculo> cboVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblModulo;
    // End of variables declaration//GEN-END:variables
}
