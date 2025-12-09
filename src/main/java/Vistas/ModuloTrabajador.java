
package Vistas;

import Controladores.ControladorTrabajador;
import DTO.Trabajador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ModuloTrabajador extends javax.swing.JFrame {
    private int idTrabajadorActual = -1;
    private int IdPersonaActual = -1;
    private boolean modoEdicion = false;

    
    public ModuloTrabajador() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Modulo Trabajador");
        this.setResizable(false);
        cargarTablaEmpleados();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        cboEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboCargo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Módulo Trabajador");
        jLabel5.setToolTipText("DNI");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 20));

        txtNombres.setBackground(new java.awt.Color(68, 68, 68));
        txtNombres.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(255, 255, 255));
        txtNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtNombres.setMinimumSize(new java.awt.Dimension(1, 20));
        txtNombres.setPreferredSize(new java.awt.Dimension(100, 30));
        txtNombres.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 190, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombres:");
        jLabel6.setToolTipText("DNI");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apellido Paterno:");
        jLabel7.setToolTipText("DNI");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo Electrónico:");
        jLabel8.setToolTipText("DNI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, 20));

        txtDNI.setBackground(new java.awt.Color(68, 68, 68));
        txtDNI.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtDNI.setForeground(new java.awt.Color(255, 255, 255));
        txtDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtDNI.setMinimumSize(new java.awt.Dimension(1, 20));
        txtDNI.setPreferredSize(new java.awt.Dimension(100, 30));
        txtDNI.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, -1));

        txtApellidoPaterno.setBackground(new java.awt.Color(68, 68, 68));
        txtApellidoPaterno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidoPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoPaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtApellidoPaterno.setMinimumSize(new java.awt.Dimension(1, 20));
        txtApellidoPaterno.setPreferredSize(new java.awt.Dimension(100, 30));
        txtApellidoPaterno.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });
        txtApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, -1));

        txtDireccion.setBackground(new java.awt.Color(68, 68, 68));
        txtDireccion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtDireccion.setMinimumSize(new java.awt.Dimension(1, 20));
        txtDireccion.setPreferredSize(new java.awt.Dimension(100, 30));
        txtDireccion.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 410, -1));

        txtTelefono.setBackground(new java.awt.Color(68, 68, 68));
        txtTelefono.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtTelefono.setMinimumSize(new java.awt.Dimension(1, 20));
        txtTelefono.setPreferredSize(new java.awt.Dimension(100, 30));
        txtTelefono.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 190, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado:");
        jLabel9.setToolTipText("DNI");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, 20));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Teléfono:");
        jLabel10.setToolTipText("DNI");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, 20));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Apellido Materno:");
        jLabel11.setToolTipText("DNI");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        txtApellidoMaterno.setBackground(new java.awt.Color(68, 68, 68));
        txtApellidoMaterno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoMaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtApellidoMaterno.setMinimumSize(new java.awt.Dimension(1, 20));
        txtApellidoMaterno.setPreferredSize(new java.awt.Dimension(100, 30));
        txtApellidoMaterno.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });
        txtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 190, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Dirección:");
        jLabel12.setToolTipText("DNI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        txtCorreo.setBackground(new java.awt.Color(68, 68, 68));
        txtCorreo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtCorreo.setMinimumSize(new java.awt.Dimension(1, 20));
        txtCorreo.setPreferredSize(new java.awt.Dimension(100, 30));
        txtCorreo.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 190, -1));

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Activo", "Inactivo" }));
        cboEstado.setBorder(null);
        cboEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 190, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 90, 30));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Persona", "ID Trabajador", "Nombre", "Apellido Paterno", "Apellido Materno", "DNI", "Teléfono", "Dirección", "Estado", "Cargo", "Sueldo"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 630, 200));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Documento de Identidad:");
        jLabel13.setToolTipText("DNI");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modulo_Cliente.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cargo:");
        jLabel14.setToolTipText("DNI");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 20));

        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Atención al cliente", "Almacenero", "Administrador" }));
        cboCargo.setBorder(null);
        cboCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 190, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sueldo:");
        jLabel15.setToolTipText("DNI");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, 20));

        txtSueldo.setBackground(new java.awt.Color(68, 68, 68));
        txtSueldo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtSueldo.setForeground(new java.awt.Color(255, 255, 255));
        txtSueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSueldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtSueldo.setMinimumSize(new java.awt.Dimension(1, 20));
        txtSueldo.setPreferredSize(new java.awt.Dimension(100, 30));
        txtSueldo.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });
        jPanel1.add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 200, -1));

        btnLimpiar.setText("Cancelar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, 30));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, 30));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        txtDNI.requestFocus();
        cboCargo.setSelectedIndex(0);
        cboEstado.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tablaEmpleados.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla");
            return;
        }

        //Cuando se seleccione una fila se activa el modo eficion (true)
        modoEdicion = true;

        IdPersonaActual  = Integer.parseInt(tablaEmpleados.getValueAt(fila, 0).toString());
        idTrabajadorActual = Integer.parseInt(tablaEmpleados.getValueAt(fila, 1).toString());
        ControladorTrabajador ctrl = new ControladorTrabajador();
        Trabajador t = ctrl.obtenerID(idTrabajadorActual);

        if (t != null) {
            llenarFormulario(t);
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    public void cargarTablaEmpleados(){
        ControladorTrabajador ctrl = new ControladorTrabajador();
        List<Trabajador> lista = ctrl.listarTrabajadores();
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
        modelo.setRowCount(0);
        
        for (Trabajador t : lista) {
            modelo.addRow(new Object[]{
                    t.getIdpersona(),
                    t.getIdTrabajador(),
                    t.getNombres(),
                    t.getApellido_paterno(),
                    t.getApellido_materno(),
                    t.getDni(),
                    t.getTelefono(),
                    t.getDireccion(),
                    t.getEstado(),
                    t.getIdCargo(),
                    t.getSueldo()
            });
        }
    }
    
    public void limpiarCampos() {
        txtNombres.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtSueldo.setText("");
        cboCargo.setSelectedIndex(0);
        cboEstado.setSelectedIndex(0);
    }

    public void llenarFormulario(Trabajador t) {
        txtNombres.setText(t.getNombres());
        txtApellidoPaterno.setText(t.getApellido_paterno());
        txtApellidoMaterno.setText(t.getApellido_materno());
        txtDNI.setText(t.getDni());
        txtTelefono.setText(t.getTelefono());
        txtDireccion.setText(t.getDireccion());
        txtCorreo.setText(t.getEmail());
        txtSueldo.setText(String.valueOf(t.getSueldo()));
        cboCargo.setSelectedIndex(t.getIdCargo());
        cboEstado.setSelectedItem(t.getEstado());
    }

    public boolean validarCampos() {
        //Validar campos vacios
        if (txtDNI.getText().isBlank() || txtNombres.getText().isBlank() || txtApellidoPaterno.getText().isBlank()
                || txtApellidoMaterno.getText().isBlank() || txtTelefono.getText().isBlank()
                || txtCorreo.getText().isBlank() || txtDireccion.getText().isBlank() || txtSueldo.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor, completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //Validamos el nombre
        if (txtNombres.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Ingrese los nombres", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombres.requestFocus();
            return false;
        }

        //Validar apellidos
        if (txtApellidoPaterno.getText().isBlank() || txtApellidoMaterno.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Ingrese sus apellidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar DNI
        String dni = txtDNI.getText().trim();
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos númericos", "Error", JOptionPane.ERROR_MESSAGE);
            txtDNI.requestFocus();
            return false;
        }
        
        //Validar Telefono
        String telefono = txtTelefono.getText().trim();
        if (!telefono.matches("\\d{9}")) {
             JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos númericos", "Error", JOptionPane.ERROR_MESSAGE);
            txtTelefono.requestFocus();
            return false;
        }
        
        //Validar correo
        String email = txtCorreo.getText().trim();
        if (!email.matches("^[A-Za-z0-9._%+-]+@gmail\\.com$")) {
            JOptionPane.showMessageDialog(this, "Ingrese un correo electrónico válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true; //SI TODO ES VÁLIDO
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaEmpleados.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un trabajador para eliminar");
            return;
        }

        //Confirmamos antes de eliminar
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este trabajador?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }
        //Obtenemos el ID del trabajador
        int idTrabajador = Integer.parseInt(tablaEmpleados.getValueAt(fila, 1).toString());

        ControladorTrabajador ctrl = new ControladorTrabajador();
        boolean eliminado = ctrl.eliminarTrabajador(idTrabajador);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Trabajador eliminado correctamente");
            cargarTablaEmpleados();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el trabajador");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // 1. Obtener los datos del formulario
        String nombres = txtNombres.getText();
        String apellidoP = txtApellidoPaterno.getText();
        String apellidoM = txtApellidoMaterno.getText();
        String dni = txtDNI.getText();
        String telefono = txtTelefono.getText();
        String email = txtCorreo.getText();
        String direccion = txtDireccion.getText();
        
        
        

        // 2. Crear Trabajador con todos los datos (hereda de Persona)
        Trabajador t = new Trabajador();
        t.setNombres(nombres);
        t.setApellido_paterno(apellidoP);
        t.setApellido_materno(apellidoM);
        t.setDni(dni);
        t.setTelefono(telefono);
        t.setEmail(email);
        t.setDireccion(direccion);
        try {
            double sueldo = Double.parseDouble(txtSueldo.getText().trim());
            t.setSueldo(sueldo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"El sueldo debe ser numerico", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        t.setEstado(cboEstado.getSelectedItem().toString());
        t.setIdCargo(cboCargo.getSelectedIndex());

        //3. Llamar al DAO para registrar
        ControladorTrabajador ctrl = new ControladorTrabajador();
        boolean ok;

        if (!validarCampos())
            return;
        
        // 4. Mensaje al usuario
        if (modoEdicion) {
            t.setIdTrabajador(idTrabajadorActual);
            t.setIdpersona(IdPersonaActual);
            ok = ctrl.actualizarTrabajador(t);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar cliente");
            }

            //Salimos del modo edicion
            modoEdicion = false;
            cargarTablaEmpleados();
            limpiarCampos();

        } else {
            //Entramos a modo registro
            ok = ctrl.registrarTrabajador(t);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Trabajador registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar trabajador");
            }
        }
        cargarTablaEmpleados();
        limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
         char c = evt.getKeyChar();
        
        //Solo numeros
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        
        //Maximo 8 digitos
        if (txtDNI.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        
        //Solo numeros
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        
        //Maximo 9 digitos
        if (txtTelefono.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        char c = evt.getKeyChar();
        
        //Solo numeros y punto
        if (!Character.isDigit(c) && c!= '.') {
            evt.consume();
        }
        
        //Solo un punto decimal
        if (c == '.' && txtSueldo.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSueldoKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        char c = evt.getKeyChar();
        
        //Solo se permiten letras y espacios
        if (!Character.isLetter(c) && c!= ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPaternoKeyTyped
        char c = evt.getKeyChar();
        
        //Solo se permiten letras y espacios
        if (!Character.isLetter(c) && c!= ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoPaternoKeyTyped

    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        char c = evt.getKeyChar();
        
        //Solo se permiten letras y espacios
        if (!Character.isLetter(c) && c!= ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoMaternoKeyTyped

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
            java.util.logging.Logger.getLogger(ModuloTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
