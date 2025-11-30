package Vistas;

import Controladores.*;
import DTO.Distrito;
import DTO.Departamento;
import DTO.Agencia;
import DTO.Provincia;
import java.util.List;
import javax.swing.JOptionPane;

public class AgenciaForm extends javax.swing.JFrame {
    
    private ControladorAgenciaForm controlador;
    private ControladorModuloAgencia controladorModulo;
    private boolean isProgrammaticChange = false; // Flag para controlar la carga de datos de los comboboxes
    
    // Modo registrar
    public AgenciaForm() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); // Que no se cierre el programa al cerrar esta ventana
        this.setLocationRelativeTo(null); // Para centrar la ventana
        this.setTitle("Registrar nueva Agencia");
        this.setResizable(false); // Que el usuario no pueda cambiar el tamaño de la ventana
        
        controlador = new ControladorAgenciaForm(this);
        llenarCboDepartamento(controlador.obtenerDepartamentos());
    }
    
    // Modo editar
    public AgenciaForm(int idAgencia) {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Editar Agencia");
        this.setResizable(false);

        controlador = new ControladorAgenciaForm(this, idAgencia);
        Agencia agenciaACargar = controlador.obtenerAgenciaParaEdicion();

        if (agenciaACargar != null) {
            cargarDatos(agenciaACargar);
        }
        // Los comboboxes se cargan usando el controlador
    }
    
    public void setControladorModulo(ControladorModuloAgencia controladorPrincipal) {
        this.controladorModulo = controladorPrincipal;
    }

    private boolean validarCampos() {
        // 1. Campos Vacíos
        if (txtNombre.getText().trim().isEmpty() || 
            txtDireccion.getText().trim().isEmpty() ||
            txtTelefono.getText().trim().isEmpty() || 
            txtEmail.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de texto.", "Validación de Formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // 2. Validación de Teléfono (9 dígitos numéricos)
        String telefono = txtTelefono.getText().trim();
        if (!telefono.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener exactamente 9 dígitos numéricos.", "Validación de Formato", JOptionPane.WARNING_MESSAGE);
            txtTelefono.requestFocus();
            return false;
        }

        // 3. Validación de Email (Formato básico)
        String email = txtEmail.getText().trim();
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "El formato del correo electrónico es inválido.", "Validación de Formato", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }
        
        // 4. Validación de Selección de Ubicación
        if (getDepartamentoSeleccionado() == null) {
             JOptionPane.showMessageDialog(this, "Debe seleccionar un Departamento.", "Validación Incompleta", JOptionPane.WARNING_MESSAGE);
             return false;
        }
        if (getProvinciaSeleccionada() == null) {
             JOptionPane.showMessageDialog(this, "Debe seleccionar una Provincia.", "Validación Incompleta", JOptionPane.WARNING_MESSAGE);
             return false;
        }
        if (getDistritoSeleccionado() == null) {
             JOptionPane.showMessageDialog(this, "Debe seleccionar un Distrito.", "Validación Incompleta", JOptionPane.WARNING_MESSAGE);
             return false;
        }

        return true; 
    }
    
    // Getters para el controlador
    public String getNombre() { return txtNombre.getText(); }
    public String getDireccion() { return txtDireccion.getText(); }
    public String getTelefono() { return txtTelefono.getText(); }
    public String getEmail() { return txtEmail.getText(); }
    
    public Departamento getDepartamentoSeleccionado() { 
        
        Object selectedItem = cboDepartamento.getSelectedItem();
        // Validar si el objeto seleccionado es el String "Seleccionar"
        if (selectedItem instanceof String && ((String) selectedItem).equals("Seleccionar")) {
            return null; 
        }
        // Si no es el String, es seguro castear
        return (Departamento) selectedItem;
    }
    
    public Provincia getProvinciaSeleccionada() { 
        Object selectedItem = cboProvincia.getSelectedItem();
        // Validar si el objeto seleccionado es el String "Seleccionar"
        if (selectedItem instanceof String && ((String) selectedItem).equals("Seleccionar")) {
            return null; 
        }
        // Si no es el String, es seguro castear
        return (Provincia) selectedItem;
    }

    public Distrito getDistritoSeleccionado() { 
        Object selectedItem = cboDistrito.getSelectedItem();
        // Validar si el objeto seleccionado es el String "Seleccionar"
        if (selectedItem instanceof String && ((String) selectedItem).equals("Seleccionar")) {
            return null; 
        }
        // Si no es el String, es seguro castear
        return (Distrito) selectedItem;
    }

    // Métodos para el controlador:
    public void limpiarCampos() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        
        // Si la lista de departamentos no está vacía (siempre debería tener "Seleccionar")
        if (cboDepartamento.getItemCount() > 0) {
            cboDepartamento.setSelectedIndex(0);
        }
        // Llamamos a los métodos de llenado con listas vacías (null) para que se limpien y solo tengan "Seleccionar"
        llenarCboProvincia(null); 
        llenarCboDistrito(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cboDepartamento = new javax.swing.JComboBox<>();
        cboDistrito = new javax.swing.JComboBox<>();
        cboProvincia = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Módulo Agencia");
        jLabel5.setToolTipText("DNI");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 20));

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
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 270, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección:");
        jLabel6.setToolTipText("DNI");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Teléfono:");
        jLabel7.setToolTipText("DNI");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 20));

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
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 270, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Distrito:");
        jLabel9.setToolTipText("DNI");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email:");
        jLabel12.setToolTipText("DNI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 70, 20));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nombre:");
        jLabel13.setToolTipText("DNI");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modulo_Cliente.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Departamento:");
        jLabel10.setToolTipText("DNI");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, 20));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Provincia:");
        jLabel11.setToolTipText("DNI");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, 20));

        txtNombre.setBackground(new java.awt.Color(68, 68, 68));
        txtNombre.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtNombre.setMinimumSize(new java.awt.Dimension(1, 20));
        txtNombre.setPreferredSize(new java.awt.Dimension(100, 30));
        txtNombre.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 270, -1));

        txtEmail.setBackground(new java.awt.Color(68, 68, 68));
        txtEmail.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(118, 118, 118)));
        txtEmail.setMinimumSize(new java.awt.Dimension(1, 20));
        txtEmail.setPreferredSize(new java.awt.Dimension(100, 30));
        txtEmail.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 270, -1));

        cboDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDepartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(cboDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 270, -1));

        cboDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDistritoActionPerformed(evt);
            }
        });
        jPanel1.add(cboDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 270, -1));

        cboProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProvinciaActionPerformed(evt);
            }
        });
        jPanel1.add(cboProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 270, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 90, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cboDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDepartamentoActionPerformed
        if (isProgrammaticChange) {
        return; // Ignorar el evento si se generó por la carga de datos
    }
        // null como argumento para que utilice el fallback de obtenerProvinciasPorDepartamento
        llenarCboProvincia(controlador.obtenerProvinciasPorDepartamento(null));
    }//GEN-LAST:event_cboDepartamentoActionPerformed

    private void cboProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProvinciaActionPerformed
        if (isProgrammaticChange) {
            return; // Ignorar el evento si se generó por la carga de datos
        }
        llenarCboDistrito(controlador.obtenerDistritosPorProvincia(null));
    }//GEN-LAST:event_cboProvinciaActionPerformed

    private void cboDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDistritoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!validarCampos()) {
            return; // Detiene la ejecución si la validación de la Vista falla
        }
        controlador.guardar();
        limpiarCampos();
        
        ModuloAgencia moduloPrincipal = controladorModulo.getVista(); // Obtenemos la vista principal
        moduloPrincipal.cargarAgencias(controladorModulo.obtenerAgencias());
        
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Cierra solo esta ventana
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
    
    public void cargarDatos(Agencia a) {
        
        // Carga de campos de texto
        txtNombre.setText(a.getNombre());
        txtDireccion.setText(a.getDireccion());
        txtTelefono.setText(a.getTelefono());
        txtEmail.setText(a.getEmail());
        
        // 1. OBTENER EL DISTRITO COMPLETO
        Distrito distritoAgencia = controlador.buscarDistrito(a.getIdDistrito());

        if (distritoAgencia == null) {
            // Manejar el caso de error si no se encuentra el distrito
            System.err.println("Error: No se pudo encontrar el Distrito con ID: " + a.getIdDistrito());
            return; 
        }

        // 2. OBTENER PROVINCIA Y DEPARTAMENTO (Usando los IDs del distrito)
        Provincia provinciaAgencia = controlador.buscarProvincia(distritoAgencia.getIdProvincia());
        Departamento departamentoAgencia = controlador.buscarDepartamento(provinciaAgencia.getIdDepartamento());

        // --- LÓGICA DE CARGA Y SELECCIÓN DE COMBOS ---
        isProgrammaticChange = true; // INICIAMOS LA CARGA PROGRAMÁTICA

        // 3. LLENAR Y SELECCIONAR DEPARTAMENTO
        llenarCboDepartamento(controlador.obtenerDepartamentos());
        seleccionarItem(cboDepartamento, departamentoAgencia); 

        // 4. LLENAR Y SELECCIONAR PROVINCIA
        // Llenamos el combo de Provincia con las provincias del Departamento encontrado.
        llenarCboProvincia(controlador.obtenerProvinciasPorDepartamento(departamentoAgencia)); 
        seleccionarItem(cboProvincia, provinciaAgencia);

        // 5. LLENAR Y SELECCIONAR DISTRITO
        // Llenamos el combo de Distrito con los distritos de la Provincia encontrada.
        llenarCboDistrito(controlador.obtenerDistritosPorProvincia(provinciaAgencia)); 
        seleccionarItem(cboDistrito, distritoAgencia);
        
        isProgrammaticChange = false; // TERMINAMOS LA CARGA PROGRAMÁTICA
    }
    
    // Para que el controlador no necesite usar los getters de la vista, cuando aún no están seleccionados
    private void seleccionarItem(javax.swing.JComboBox<Object> cbo, Object objetoASeleccionar) {
    if (objetoASeleccionar == null) return;
    
    // Recorrer los ítems del JComboBox para encontrar el objeto DTO (usando .equals())
    for (int i = 1; i < cbo.getItemCount(); i++) { // Empezamos en 1 para saltar "Seleccionar"
        Object item = cbo.getItemAt(i);
        if (item.equals(objetoASeleccionar)) {
            cbo.setSelectedIndex(i);
            return;
        }
    }
}
    
    private void llenarCboDepartamento(List<Departamento> departamentos) {
        cboDepartamento.removeAllItems(); // Primero limpiar
        cboDepartamento.addItem("Seleccionar"); // Agregar el item por defecto
        if(departamentos != null) {
            for(Departamento d : departamentos) {
                cboDepartamento.addItem(d);
            }
        }
    }
    
    private void llenarCboProvincia(List<Provincia> provincias) {
        cboProvincia.removeAllItems(); // Primero limpiar
        cboProvincia.addItem("Seleccionar"); // Agregar el item por defecto
        if(provincias != null) {
            for(Provincia p : provincias) {
                cboProvincia.addItem(p);
            }
        }
    }
    
    private void llenarCboDistrito(List<Distrito> distritos) {
        cboDistrito.removeAllItems(); // Primero limpiar
        cboDistrito.addItem("Seleccionar"); // Agregar el item por defecto
        if(distritos != null) {
            for(Distrito d : distritos) {
                cboDistrito.addItem(d);
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(AgenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgenciaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Object> cboDepartamento;
    private javax.swing.JComboBox<Object> cboDistrito;
    private javax.swing.JComboBox<Object> cboProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
