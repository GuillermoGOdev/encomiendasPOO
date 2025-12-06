/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import DAO.DespachoDAO;
import DTO.Despacho;
import Util.Design_JTable;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivas
 */
public class ModuloAsignarEncomiendas extends javax.swing.JFrame {

    int IdConsolidado = 0;
    int IdRuta = 0;
    Design_JTable design_table = new Design_JTable();
    public ModuloAsignarEncomiendas() {
        initComponents();
        
        

    }

    DespachoDAO descachoDao = new DespachoDAO();

    public void setDatos(int idConsolidado, int idruta, String ruta, String placa, String conductor, Date fechaSalida) {
        IdConsolidado = idConsolidado;
        IdRuta = idruta;
        lblRuta.setText(ruta);
        lblPlaca.setText(placa);
        lblConductor.setText(conductor);
        lblFecha.setText(fechaSalida.toString());
        
        
        
        mostrarEncomiendasEnTabla(TablaEncomiendas, IdRuta);
        design_table.ocultarColumnas(TablaEncomiendas, 1);
        design_table.ocultarColumnas(TablaEncomiendas, 2);
        design_table.ocultarColumnas(TablaEncomiendas, 4);
    }

   public void mostrarEncomiendasEnTabla(JTable Tabla, int idRuta) {
    // Obtenemos el modelo desde DAO
    DefaultTableModel modeloOriginal = descachoDao.listarEncomiendasPorRuta(idRuta);

    // Creamos un nuevo modelo con la primera columna de checkbox
    String[] titulos = new String[modeloOriginal.getColumnCount() + 1];
    titulos[0] = "Agregar"; // checkbox
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
            if (columnIndex == 0) return Boolean.class; // checkbox
            return super.getColumnClass(columnIndex);
        }
    };

    // Llenamos el modelo agregando una columna inicial de false (checkbox desmarcado)
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
        jLabel19 = new javax.swing.JLabel();

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
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 150, 30));

        lblPlaca.setBackground(new java.awt.Color(255, 255, 255));
        lblPlaca.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 140, 30));

        lblConductor.setBackground(new java.awt.Color(255, 255, 255));
        lblConductor.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 210, 30));

        lblRuta.setBackground(new java.awt.Color(255, 255, 255));
        lblRuta.setForeground(new java.awt.Color(255, 255, 255));
        lblRuta.setToolTipText("DNI");
        jPanel1.add(lblRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 180, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Vehículo:");
        jLabel16.setToolTipText("DNI");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 110, 20));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Conductor:");
        jLabel17.setToolTipText("DNI");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, 20));

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
        jScrollPane1.setViewportView(TablaEncomiendas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 830, 260));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha de Salida:");
        jLabel18.setToolTipText("DNI");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 110, 20));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ruta:");
        jLabel19.setToolTipText("DNI");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 110, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConductor;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblRuta;
    // End of variables declaration//GEN-END:variables
}
