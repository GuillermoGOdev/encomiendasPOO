package Vistas;

import Controladores.ControladorVehiculo;
import DAO.VehiculoDAO;
import DTO.Vehiculo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModuloVehiculo extends javax.swing.JFrame {
    private Integer idVehiculoSeleccionado = null;

    public ModuloVehiculo() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Modulo Vehiculo");
        this.setResizable(false);
        cargarTablaVehiculos();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtVolumen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CboAnio = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CboEstado = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Módulo Vehiculo");
        jLabel5.setToolTipText("DNI");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 20));

        txtPeso.setBackground(new java.awt.Color(68, 68, 68));
        txtPeso.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPeso.setForeground(new java.awt.Color(255, 255, 255));
        txtPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPeso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtPeso.setMinimumSize(new java.awt.Dimension(1, 20));
        txtPeso.setPreferredSize(new java.awt.Dimension(100, 30));
        txtPeso.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 190, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Capacidad Peso:");
        jLabel6.setToolTipText("DNI");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Capacidad Volumen:");
        jLabel7.setToolTipText("DNI");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, 20));

        txtPlaca.setBackground(new java.awt.Color(68, 68, 68));
        txtPlaca.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(255, 255, 255));
        txtPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtPlaca.setMinimumSize(new java.awt.Dimension(1, 20));
        txtPlaca.setPreferredSize(new java.awt.Dimension(100, 30));
        txtPlaca.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaKeyTyped(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, -1));

        txtVolumen.setBackground(new java.awt.Color(68, 68, 68));
        txtVolumen.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtVolumen.setForeground(new java.awt.Color(255, 255, 255));
        txtVolumen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVolumen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtVolumen.setMinimumSize(new java.awt.Dimension(1, 20));
        txtVolumen.setPreferredSize(new java.awt.Dimension(100, 30));
        txtVolumen.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtVolumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVolumenActionPerformed(evt);
            }
        });
        txtVolumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVolumenKeyTyped(evt);
            }
        });
        jPanel1.add(txtVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado:");
        jLabel9.setToolTipText("DNI");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Año:");
        jLabel12.setToolTipText("DNI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 70, 20));

        CboAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2020", "2021", "2022", "2023", "2024", "2025" }));
        CboAnio.setBorder(null);
        CboAnio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(CboAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 190, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 90, 30));

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vehículo", "Placa", "Año", "Capacidad (kg)", "Capacidad (Volumen)", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaVehiculos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 630, 210));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Placa:");
        jLabel13.setToolTipText("DNI");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modulo_Cliente.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        CboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A", "I" }));
        CboEstado.setBorder(null);
        CboEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(CboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 190, -1));

        btnLimpiar.setText("Cancelar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, 30));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, 30));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void txtVolumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVolumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVolumenActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String placa = txtPlaca.getText().trim();
        String peso = txtPeso.getText().trim();
        String volumen = txtVolumen.getText().trim();
        String estado = CboEstado.getSelectedItem().toString();

        // Validaciones
        if (placa.isBlank() || peso.isBlank() || volumen.isBlank()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }
        
        if (CboAnio.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un año válido");
            return;
        }
        int anio = Integer.parseInt(CboAnio.getSelectedItem().toString());
        
        //Validando que la placa tenga al menos 5 caracteres
        if (placa.length() < 5) {
            JOptionPane.showMessageDialog(null, "La placa debe tener al menos 5 caracteres");
            return;
        }

        double capKg = 0;
        double capVol = 0;
        
        try {
            capKg = Double.parseDouble(peso);
            capVol = Double.parseDouble(volumen);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Peso y Volumen deben ser valores numéricos");
            return;
        }
        
        if (capKg <= 0 || capVol <= 0) {
            JOptionPane.showMessageDialog(null, "El peso y volumen deben ser mayores que 0");
            return;
        }
        
        //Validacion de estado
        if (CboEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un estado");
            return;
        }

        Vehiculo v;
        ControladorVehiculo ctrl = new ControladorVehiculo();

        if (idVehiculoSeleccionado == null) {
            // REGISTRAR NUEVO
            v = new Vehiculo(placa, anio, capKg, capVol, estado);
            if (ctrl.registrar(v)) {
                JOptionPane.showMessageDialog(null, "Vehículo registrado");
            }
        } else {
            // ACTUALIZAR EXISTENTE
            v = new Vehiculo(idVehiculoSeleccionado, placa, anio, capKg, capVol, estado);
            if (ctrl.actualizar(v)) {
                JOptionPane.showMessageDialog(null, "Vehículo actualizado");
            }
            idVehiculoSeleccionado = null; // reiniciamos
        }

        cargarTablaVehiculos();
        limpiarCampos();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        txtPlaca.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tablaVehiculos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un vehículo");
            return;
        }

        idVehiculoSeleccionado = Integer.parseInt(tablaVehiculos.getValueAt(fila, 0).toString());

        txtPlaca.setText(tablaVehiculos.getValueAt(fila, 1).toString());
        CboAnio.setSelectedItem(tablaVehiculos.getValueAt(fila, 2).toString());
        txtPeso.setText(tablaVehiculos.getValueAt(fila, 3).toString());
        txtVolumen.setText(tablaVehiculos.getValueAt(fila, 4).toString());
        CboEstado.setSelectedItem(tablaVehiculos.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_btnEditarActionPerformed

    public void limpiarCampos(){
        txtPlaca.setText("");
        txtPeso.setText("");
        txtVolumen.setText("");
        CboAnio.setSelectedIndex(0);
        CboEstado.setSelectedIndex(0);
        idVehiculoSeleccionado = null; //Por las dudas se reinicia
 
    }
    
    private void cargarTablaVehiculos() {
        ControladorVehiculo controlador = new ControladorVehiculo();
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculos.getModel();
        modelo.setRowCount(0);

        for (Vehiculo v : controlador.listar()) {
            modelo.addRow(new Object[]{
                v.getIdVehiculo(),
                v.getPlaca(),
                v.getAnio(),
                v.getCapacidad_kg(),
                v.getCapacidad_m3(),
                v.getEstado()
            });
        }
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaVehiculos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un vehículo para eliminar");
            return;
        }

        int id = Integer.parseInt(tablaVehiculos.getValueAt(fila, 0).toString());
        ControladorVehiculo ctrl = new ControladorVehiculo();
        if (ctrl.eliminar(id)) {
            JOptionPane.showMessageDialog(null, "Vehículo eliminado");
        }

        cargarTablaVehiculos();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isLetterOrDigit(c) && c != '-') {
            evt.consume();
        }

        // Convertimos todo automáticamente en mayúsculas
        txtPlaca.setText(txtPlaca.getText().toUpperCase());

    }//GEN-LAST:event_txtPlacaKeyTyped

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }

        // Evitar más de un punto
        if (c == '.' && txtPeso.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtVolumenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVolumenKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }

        // Evitar más de un punto
        if (c == '.' && txtPeso.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtVolumenKeyTyped

    
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboAnio;
    private javax.swing.JComboBox<String> CboEstado;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtVolumen;
    // End of variables declaration//GEN-END:variables
}
