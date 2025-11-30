
package Vistas;

import DTO.Cliente;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import Controladores.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ModuloClientes extends javax.swing.JFrame {
    private int idClienteActual = -1;
    private int IdPersonaActual = -1;
    private boolean modoEdicion = false;
    
    public ModuloClientes() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Modulo Clientes");
        this.setResizable(false);
        cargarTablaClientes();
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
        txtDni = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtdireccioon = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel5.setText("Módulo Cliente");
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

        txtDni.setBackground(new java.awt.Color(68, 68, 68));
        txtDni.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtDni.setForeground(new java.awt.Color(255, 255, 255));
        txtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtDni.setMinimumSize(new java.awt.Dimension(1, 20));
        txtDni.setPreferredSize(new java.awt.Dimension(100, 30));
        txtDni.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, -1));

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
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, -1));

        txtdireccioon.setBackground(new java.awt.Color(68, 68, 68));
        txtdireccioon.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtdireccioon.setForeground(new java.awt.Color(255, 255, 255));
        txtdireccioon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdireccioon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtdireccioon.setMinimumSize(new java.awt.Dimension(1, 20));
        txtdireccioon.setPreferredSize(new java.awt.Dimension(100, 30));
        txtdireccioon.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtdireccioon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccioonActionPerformed(evt);
            }
        });
        jPanel1.add(txtdireccioon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 410, -1));

        txttelefono.setBackground(new java.awt.Color(68, 68, 68));
        txttelefono.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(255, 255, 255));
        txttelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txttelefono.setMinimumSize(new java.awt.Dimension(1, 20));
        txttelefono.setPreferredSize(new java.awt.Dimension(100, 30));
        txttelefono.setSelectionColor(new java.awt.Color(204, 204, 204));
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 190, -1));

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
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 190, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Dirección:");
        jLabel12.setToolTipText("DNI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, 20));

        txtemail.setBackground(new java.awt.Color(68, 68, 68));
        txtemail.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(255, 255, 255));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtemail.setMinimumSize(new java.awt.Dimension(1, 20));
        txtemail.setPreferredSize(new java.awt.Dimension(100, 30));
        txtemail.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 190, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 90, 30));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Persona", "ID Cliente", "Nombres", "Apellido Paterno", "Apellido Materno", "DNI", "Teléfono", "Email", "Dirección", "Estado", "Fecha de Registro"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 860, 280));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Documento de Identidad:");
        jLabel13.setToolTipText("DNI");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modulo_Cliente.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        btnLimpiar.setText("Cancelar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 313, -1, 30));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 313, -1, 30));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 313, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtdireccioonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccioonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccioonActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // 1. Obtener los datos del formulario
        String nombres = txtNombres.getText();
        String apellidoP = txtApellidoPaterno.getText();
        String apellidoM = txtApellidoMaterno.getText();
        String dni = txtDni.getText();
        String telefono = txttelefono.getText();
        String email = txtemail.getText();
        String direccion = txtdireccioon.getText();

        // 2. Crear Cliente con todos los datos (hereda de Persona)
        Cliente c = new Cliente();
        c.setNombres(nombres);
        c.setApellido_paterno(apellidoP);
        c.setApellido_materno(apellidoM);
        c.setDni(dni);
        c.setTelefono(telefono);
        c.setEmail(email);
        c.setDireccion(direccion);

        c.setFecha_registro(LocalDate.now().toString());
        c.setEstado("A");  // Activo

        //3. Llamar al DAO para registrar
        ControladorCliente ctrl = new ControladorCliente();
        boolean ok;

        if (!validarCampos())
            return;
        
        // 4. Mensaje al usuario
        if (modoEdicion) {
            c.setIdcliente(idClienteActual);
            c.setIdpersona(IdPersonaActual);
            ok = ctrl.actualizarCliente(c);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar cliente");
            }

            //Salimos del modo edicion
            modoEdicion = false;
            cargarTablaClientes();
            limpiarCampos();

        } else {
            //Entramos a modo registro
            ok = ctrl.registrarCliente(c);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar cliente");
            }
        }
        cargarTablaClientes();
        limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar");
            return;
        }
        
        //Confirmamos antes de eliminar
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }
        //Obtenemos el ID del cliente
        int idCliente = Integer.parseInt(tablaClientes.getValueAt(fila, 1).toString());
        
        ControladorCliente ctrl = new ControladorCliente();
        boolean eliminado = ctrl.eliminarCliente(idCliente);
        
        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
            cargarTablaClientes();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el cliente");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        txtDni.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla");
            return;        
        }
        
        //Cuando se seleccione una fila se activa el modo eficion (true)
        modoEdicion = true;
        
        IdPersonaActual  = Integer.parseInt(tablaClientes.getValueAt(fila, 0).toString());
        idClienteActual = Integer.parseInt(tablaClientes.getValueAt(fila, 1).toString());
        ControladorCliente ctrl = new ControladorCliente();
        Cliente c = ctrl.obtenerID(idClienteActual);
        
        if (c != null) {
            llenarFormulario(c);
        }
            
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        
        //Solo numeros
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        
        //Maximo 8 digitos
        if (txtDni.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char c = evt.getKeyChar();
        
        //Solo numeros
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        
        //Maximo 9 digitos
        if (txttelefono.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    public void limpiarCampos(){
        txtNombres.setText("");
            txtApellidoPaterno.setText("");
            txtApellidoMaterno.setText("");
            txtDni.setText("");
            txttelefono.setText("");
            txtemail.setText("");
            txtdireccioon.setText("");
    }
    
    public void llenarFormulario(Cliente c) {
    txtNombres.setText(c.getNombres());
    txtApellidoPaterno.setText(c.getApellido_paterno());
    txtApellidoMaterno.setText(c.getApellido_materno());   
    txtDni.setText(c.getDni());
    txttelefono.setText(c.getTelefono());
    txtdireccioon.setText(c.getDireccion());
    txtemail.setText(c.getEmail());
    }
    
    public void cargarTablaClientes(){
        ControladorCliente ctrl = new ControladorCliente();
        List<Cliente> lista = ctrl.listarClientes();
        DefaultTableModel modelo = (DefaultTableModel) tablaClientes.getModel();
        modelo.setRowCount(0);
        
        for (Cliente c : lista) {
            modelo.addRow(new Object[]{
                    c.getIdpersona(),
                    c.getIdcliente(),
                    c.getNombres(),
                    c.getApellido_paterno(),
                    c.getApellido_materno(),
                    c.getDni(),
                    c.getTelefono(),
                    c.getEmail(),
                    c.getDireccion(),
                    c.getEstado(),
                    c.getFecha_registro()
            });
        }
    }
    
    public boolean validarCampos(){
        //Validar campos vacios
        if (txtDni.getText().isBlank()||txtNombres.getText().isBlank()||txtApellidoPaterno.getText().isBlank()
                ||txtApellidoMaterno.getText().isBlank()|| txttelefono.getText().isBlank()||
                txtemail.getText().isBlank()||txtdireccioon.getText().isBlank()) {
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
        String dni = txtDni.getText().trim();
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos númericos", "Error", JOptionPane.ERROR_MESSAGE);
            txtDni.requestFocus();
            return false;
        }
        
        //Validar Telefono
        String telefono = txttelefono.getText().trim();
        if (!telefono.matches("\\d{9}")) {
             JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos númericos", "Error", JOptionPane.ERROR_MESSAGE);
            txttelefono.requestFocus();
            return false;
        }
        
        //Validar correo
        String email = txtemail.getText().trim();
        if (!email.matches("^[A-Za-z0-9._%+-]+@gmail\\.com$")) {
            JOptionPane.showMessageDialog(this, "Ingrese un correo electrónico válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true; //SI TODO ES VÁLIDO
    }

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
            java.util.logging.Logger.getLogger(ModuloClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtdireccioon;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
