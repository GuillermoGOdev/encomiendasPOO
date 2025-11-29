
package Vistas;
import Controladores.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ModuloRegistro extends javax.swing.JFrame {

    
    public ModuloRegistro() {
        initComponents();
        txtNombre.setText("Nombre de Usuario");
        txtNombre.setForeground(new java.awt.Color(153,153,153));
        txtCorreo.setText("Correo Electrónico");
        txtCorreo.setForeground(new java.awt.Color(153,153,153));
        txtContraseñaRe.setText("Contraseña");
        txtContraseñaRe.setEchoChar((char)0);
        txtContraseñaRe.setForeground(new java.awt.Color(153,153,153));
        txtConfirContraseña.setText("Confirmar Contraseña");
        txtConfirContraseña.setEchoChar((char)0);
        txtConfirContraseña.setForeground(new java.awt.Color(153,153,153));
        jPanel1.requestFocusInWindow();
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContraseñaRe = new javax.swing.JPasswordField();
        txtConfirContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regístrate");

        jPanel1.setBackground(new java.awt.Color(62, 56, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGÍSTRATE");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistro.setBackground(new java.awt.Color(22, 108, 170));
        btnRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistro.setText("Registrarse");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        txtContraseñaRe.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseñaRe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContraseñaRe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaReFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaReFocusLost(evt);
            }
        });

        txtConfirContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtConfirContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtConfirContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirContraseñaFocusLost(evt);
            }
        });
        txtConfirContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnRegistro)
                            .addGap(31, 31, 31)
                            .addComponent(btnCancelar)
                            .addGap(15, 15, 15))
                        .addComponent(txtConfirContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addComponent(txtContraseñaRe)
                        .addComponent(txtCorreo)))
                .addGap(0, 61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtContraseñaRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(txtConfirContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistro))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if (txtNombre.getText().equals("Nombre de Usuario")) {
            txtNombre.setText("");
            txtNombre.setForeground(new java.awt.Color(0,0,0)); // Negro al escribir
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("Nombre de Usuario");
            txtNombre.setForeground(new java.awt.Color(153,153,153)); // Gris placeholder
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        if (txtCorreo.getText().equals("Correo Electrónico")) {
            txtCorreo.setText("");
            txtCorreo.setForeground(new java.awt.Color(0,0,0)); // Negro al escribir
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (txtCorreo.getText().isEmpty()) {
            txtCorreo.setText("Correo Electrónico");
            txtCorreo.setForeground(new java.awt.Color(153,153,153)); // Gris placeholder
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtContraseñaReFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaReFocusGained
        if (String.valueOf(txtContraseñaRe.getPassword()).equals("Contraseña")) {
            txtContraseñaRe.setText("");
            txtContraseñaRe.setEchoChar('*');
            txtContraseñaRe.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_txtContraseñaReFocusGained

    private void txtContraseñaReFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaReFocusLost
        if (String.valueOf(txtContraseñaRe.getPassword()).isEmpty()) {
            txtContraseñaRe.setText("Contraseña");
            txtContraseñaRe.setEchoChar((char)0);
            txtContraseñaRe.setForeground(new java.awt.Color(153,153,153));
        }
    }//GEN-LAST:event_txtContraseñaReFocusLost

    private void txtConfirContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirContraseñaFocusGained
        if (String.valueOf(txtConfirContraseña.getPassword()).equals("Confirmar Contraseña")) {
            txtConfirContraseña.setText("");
            txtConfirContraseña.setEchoChar('*');
            txtConfirContraseña.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_txtConfirContraseñaFocusGained

    private void txtConfirContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirContraseñaFocusLost
        if (String.valueOf(txtConfirContraseña.getPassword()).isEmpty()) {
            txtConfirContraseña.setText("Confirmar Contraseña");
            txtConfirContraseña.setEchoChar((char)0);
            txtConfirContraseña.setForeground(new java.awt.Color(153,153,153));
        }
    }//GEN-LAST:event_txtConfirContraseñaFocusLost

    private void txtConfirContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirContraseñaActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        ControladorUsuario controlador = new ControladorUsuario();

        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contra = String.valueOf(txtContraseñaRe.getPassword());
        String contra2 = String.valueOf(txtConfirContraseña.getPassword());

        if (!contra.equals(contra2)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        String resultado = controlador.registrarUsuario(nombre, correo, contra);

        if (resultado.equals("OK")) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
            this.dispose();
            new ModuloLogin().setVisible(true);  
        } else {
            JOptionPane.showMessageDialog(null, resultado);
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setText("");
        txtCorreo.setText("");
        txtContraseñaRe.setText("");
        txtConfirContraseña.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    
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
            java.util.logging.Logger.getLogger(ModuloRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtConfirContraseña;
    private javax.swing.JPasswordField txtContraseñaRe;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
