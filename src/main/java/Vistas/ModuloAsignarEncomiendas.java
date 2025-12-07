/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controladores.ControladorDetalleConsolidado;
import DAO.DespachoDAO;
import DAO.DetalleConsolidadoDAO;
import DTO.Despacho;
import DTO.Encomienda;
import Util.Design_JTable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivas
 */
public class ModuloAsignarEncomiendas extends javax.swing.JFrame {
    
    int IdConsolidado = 0;
    int IdRuta = 0;
    double kilos;
    double volumen;
    double kgcom;
    double volCom;
    double DisponibleKg;
    double DisponibleVol;
    double capacidadKg = 0;
    double capacidadVolumen = 0;
    Design_JTable design_table = new Design_JTable();
    DecimalFormat formato = new DecimalFormat("#,###.##");
    
    public ModuloAsignarEncomiendas() {
        initComponents();
        
    }
    
    DespachoDAO descachoDao = new DespachoDAO();
    DetalleConsolidadoDAO detalle = new DetalleConsolidadoDAO();
    ControladorDetalleConsolidado controlador = new ControladorDetalleConsolidado();
    
    public void setDatos(int idConsolidado, int idruta, String ruta, String placa, double kg, double volumen,
            double kg_comprometido, double volumen_comprometido, int cantpaq,
            String conductor, Date fechaSalida) {
        
        IdConsolidado = idConsolidado;
        IdRuta = idruta;
        capacidadKg = kg;
        capacidadVolumen = volumen;
        kgcom = kg_comprometido;
        volCom = volumen_comprometido;
        
        DisponibleKg = capacidadKg - kgcom;
        DisponibleVol = capacidadVolumen - volCom;
        
        lblRuta.setText(ruta);
        lblPlaca.setText(placa);
        lblCapacidadKg.setText(String.valueOf(DisponibleKg) + " kg");
        lblCapacidadVolumen.setText(String.valueOf(DisponibleVol) + " cm3");
        lblPaq.setText(String.valueOf(cantpaq));
        lblConductor.setText(conductor);
        lblFecha.setText(fechaSalida.toString());
        mostrarEncomiendasEnTabla(TablaEncomiendas, IdRuta);
        design_table.ocultarColumnas(TablaEncomiendas, 1);
        design_table.ocultarColumnas(TablaEncomiendas, 2);
        design_table.ocultarColumnas(TablaEncomiendas, 4);
    }
//////////// Listar Encomiendas

    public void mostrarEncomiendasEnTabla(JTable Tabla, int idRuta) {
        DefaultTableModel modeloOriginal = descachoDao.listarEncomiendasPorRuta(idRuta);
        
        String[] titulos = new String[modeloOriginal.getColumnCount() + 1];
        titulos[0] = "Agregar";
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            titulos[i + 1] = modeloOriginal.getColumnName(i);
        }
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // Solo la columna de checkbox editable
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // checkbox
                }
                return super.getColumnClass(columnIndex);
            }
        };
        for (int i = 0; i < modeloOriginal.getRowCount(); i++) {
            Object[] fila = new Object[modeloOriginal.getColumnCount() + 1];
            fila[0] = false; // checkbox
            for (int j = 0; j < modeloOriginal.getColumnCount(); j++) {
                fila[j + 1] = modeloOriginal.getValueAt(i, j);
            }
            modelo.addRow(fila);
        }

        // Asignamos el modelo al JTable
        Tabla.setModel(modelo);

        /// Actualizar pesos y volumenes
        Tabla.getModel().addTableModelListener(e -> {
            if (e.getColumn() == 0) { // columna checkbox
                actualizarTotales();
            }
        });
    }

    //// CALCULAR PESO
    private void actualizarTotales() {
        double pesoTotal = 0.0;
        double volumenTotal = 0.0;
        for (int i = 0; i < TablaEncomiendas.getRowCount(); i++) {
            Object chk = TablaEncomiendas.getValueAt(i, 0);
            boolean marcado = Boolean.TRUE.equals(chk);
            
            if (marcado) {
                try {
                    double peso = Double.parseDouble(TablaEncomiendas.getValueAt(i, 7).toString());
                    double largo = Double.parseDouble(TablaEncomiendas.getValueAt(i, 8).toString());
                    double ancho = Double.parseDouble(TablaEncomiendas.getValueAt(i, 10).toString());
                    double alto = Double.parseDouble(TablaEncomiendas.getValueAt(i, 9).toString());
                    
                    pesoTotal += peso;
                    volumenTotal += largo * ancho * alto;
                } catch (Exception ex) {
                }
            }
        }
        
        lblPeso.setText(formato.format(pesoTotal) + " kg");
        lblVolumen.setText(formato.format(volumenTotal) + " cm3");
        kilos = pesoTotal;
        volumen = volumenTotal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblConductor = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEncomiendas = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        lblCapacidadVolumen = new javax.swing.JLabel();
        lblVolumen = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblCapacidadKg = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblPaq = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Asignar encomiendas");
        jLabel5.setToolTipText("DNI");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 260, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/caja-negra.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 40, 30));

        lblFecha.setBackground(new java.awt.Color(255, 255, 255));
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 150, 30));

        lblPlaca.setBackground(new java.awt.Color(255, 255, 255));
        lblPlaca.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 140, 30));

        lblConductor.setBackground(new java.awt.Color(255, 255, 255));
        lblConductor.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 210, 30));

        lblRuta.setBackground(new java.awt.Color(255, 255, 255));
        lblRuta.setForeground(new java.awt.Color(255, 255, 255));
        lblRuta.setToolTipText("DNI");
        jPanel1.add(lblRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 190, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Vehículo:");
        jLabel16.setToolTipText("DNI");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 110, 20));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Conductor:");
        jLabel17.setToolTipText("DNI");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 110, 20));

        TablaEncomiendas.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaEncomiendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEncomiendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEncomiendas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 790, 220));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha de Salida:");
        jLabel18.setToolTipText("DNI");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 110, 20));

        lblPeso.setBackground(new java.awt.Color(255, 255, 255));
        lblPeso.setForeground(new java.awt.Color(255, 255, 255));
        lblPeso.setToolTipText("DNI");
        jPanel1.add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 140, 30));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 90, -1));

        lblCapacidadVolumen.setBackground(new java.awt.Color(255, 255, 255));
        lblCapacidadVolumen.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacidadVolumen.setToolTipText("DNI");
        jPanel1.add(lblCapacidadVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 120, 30));

        lblVolumen.setBackground(new java.awt.Color(255, 255, 255));
        lblVolumen.setForeground(new java.awt.Color(255, 255, 255));
        lblVolumen.setToolTipText("DNI");
        jPanel1.add(lblVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 160, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Volumen Asignado:");
        jLabel21.setToolTipText("DNI");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 110, 20));

        lblCapacidadKg.setBackground(new java.awt.Color(255, 255, 255));
        lblCapacidadKg.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacidadKg.setToolTipText("DNI");
        jPanel1.add(lblCapacidadKg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 120, 30));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Peso Disponible:");
        jLabel23.setToolTipText("DNI");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 110, 20));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Volumen Disponible:");
        jLabel24.setToolTipText("DNI");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 120, 20));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Ruta:");
        jLabel22.setToolTipText("DNI");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 110, 20));

        lblPaq.setBackground(new java.awt.Color(255, 255, 255));
        lblPaq.setForeground(new java.awt.Color(255, 255, 255));
        lblPaq.setToolTipText("DNI");
        jPanel1.add(lblPaq, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 160, 20));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Peso Asignado:");
        jLabel26.setToolTipText("DNI");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 110, 20));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Cantidad de paquetes:");
        jLabel27.setToolTipText("DNI");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 130, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
////////////// BOTON AGREGAR ////////////////
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        boolean sobrepeso = kilos > DisponibleKg;
        boolean sobrevolumen = volumen > DisponibleVol;
        
        if (sobrepeso || sobrevolumen) {
            
            String mensaje = "Capacidad del vehículo superada:\n\n";
            
            if (sobrepeso) {
                double excesoPeso = kilos - DisponibleKg;
                mensaje += "- Exceso en PESO: " + formato.format(excesoPeso) + " kg\n";
            }
            
            if (sobrevolumen) {
                double excesoVol = volumen - DisponibleVol;
                mensaje += "- Exceso en VOLUMEN: " + formato.format(excesoVol) + " cm³\n";
            }
            
            JOptionPane.showMessageDialog(this, mensaje);
            return; // 🚫 Se detiene el proceso (NO registra)
        }
// 2) Si todo está correcto, registrar normalmente
        int idConsolidado = this.IdConsolidado;
        List<Integer> ids = controlador.getEncomiendasSeleccionadas(TablaEncomiendas);
        
        if (ids.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay encomiendas seleccionadas.");
            return;
        }

// 3) Insertar vía DAO
        DetalleConsolidadoDAO dao = new DetalleConsolidadoDAO();
        boolean correcto = dao.registrarDetallesMasivos(idConsolidado, ids);
        
        if (correcto) {
            JOptionPane.showMessageDialog(this, "Encomiendas asignadas correctamente.");
            mostrarEncomiendasEnTabla(TablaEncomiendas, IdRuta);
            lblPeso.setText("");
            lblVolumen.setText("");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al asignar las encomiendas.");
        }
        

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void TablaEncomiendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEncomiendasMouseClicked
//        int col = TablaEncomiendas.getSelectedColumn();
//        if (col == 0) { // columna del checkbox
//            actualizarTotales();
//        }
    }//GEN-LAST:event_TablaEncomiendasMouseClicked

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
            java.util.logging.Logger.getLogger(ModuloAsignarEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloAsignarEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloAsignarEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloAsignarEncomiendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloAsignarEncomiendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEncomiendas;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCapacidadKg;
    private javax.swing.JLabel lblCapacidadVolumen;
    private javax.swing.JLabel lblConductor;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPaq;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblVolumen;
    // End of variables declaration//GEN-END:variables
}
