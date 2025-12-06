
package Vistas;
import Controladores.*;
import DTO.Agencia;
import DTO.Cliente;
import DTO.MetodoPago;
import DTO.Ruta;
import DTO.TipoPaquete;
import DTO.Trabajador;
import java.awt.Color;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ModuloRegistrarEncomienda extends javax.swing.JFrame {
    private Map<DTO.TipoPaquete, Double> preciosPorTipoPaquete;
    private Ruta rutaSeleccionada;
    private double fleteInicial;
    private double fleteFinal = -1;
    private boolean datosEncomiendaCompletos = false;
    private int idRemitente;
    private int idDestinatario;
    
    public ModuloRegistrarEncomienda() {
        initComponents();
        cargarAgencias();
        cargarTipoPaquete();
        desactivarCamposDimensiones();
        cargarTrabajadores();
        cargarMetodosPago();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoPago = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreRemitente = new javax.swing.JTextField();
        txtDNIRemitente = new javax.swing.JTextField();
        txtTelefonoRemitente = new javax.swing.JTextField();
        txtBuscarRemitente = new javax.swing.JTextField();
        btnBuscarRemitente = new javax.swing.JButton();
        btnRegistrarRemitente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcionEncomienda = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        txtLargo = new javax.swing.JTextField();
        txtAlto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFlete = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboTipoEncomienda = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreDestinatario = new javax.swing.JTextField();
        txtDNIDestinatario = new javax.swing.JTextField();
        txtTelefonoDestinatario = new javax.swing.JTextField();
        btnRegistrarDestinatario = new javax.swing.JButton();
        btnBuscarDestinatario = new javax.swing.JButton();
        txtBuscarDestinatario = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboAgenciaOrigen = new javax.swing.JComboBox<>();
        cboAgenciaDestino = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        rbnEfectivo = new javax.swing.JRadioButton();
        rbnTarjeta = new javax.swing.JRadioButton();
        rbnYape = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        txtTotalAPagar = new javax.swing.JTextField();
        cboTrabajador = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Encomienda");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(68, 68, 68));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR ENCOMIENDA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teléfono");

        btnBuscarRemitente.setText("Buscar");
        btnBuscarRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRemitenteActionPerformed(evt);
            }
        });

        btnRegistrarRemitente.setText("Registrar nuevo");
        btnRegistrarRemitente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarRemitenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreRemitente)
                            .addComponent(txtDNIRemitente)
                            .addComponent(txtTelefonoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuscarRemitente)
                        .addGap(20, 20, 20)
                        .addComponent(btnBuscarRemitente)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarRemitente)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarRemitente)
                    .addComponent(btnRegistrarRemitente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDNIRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefonoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Encomienda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        taDescripcionEncomienda.setColumns(20);
        taDescripcionEncomienda.setRows(5);
        jScrollPane1.setViewportView(taDescripcionEncomienda);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripción:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Peso (kg):");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ancho (cm):");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Largo (cm):");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Alto (cm):");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Flete (S/): ");

        txtFlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFleteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tipo:");

        cboTipoEncomienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoEncomiendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cboTipoEncomienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPeso)
                                .addComponent(txtAncho, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAlto))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboTipoEncomienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Destinatario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DNI:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Teléfono");

        txtNombreDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreDestinatarioActionPerformed(evt);
            }
        });

        btnRegistrarDestinatario.setText("Registrar nuevo");
        btnRegistrarDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDestinatarioActionPerformed(evt);
            }
        });

        btnBuscarDestinatario.setText("Buscar");
        btnBuscarDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDestinatarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtBuscarDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarDestinatario)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarDestinatario))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txtDNIDestinatario)
                            .addComponent(txtTelefonoDestinatario))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDestinatario)
                    .addComponent(btnRegistrarDestinatario))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNombreDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtDNIDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTelefonoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rutas y Agencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Agencia origen");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Agencia destino:");

        cboAgenciaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaOrigenActionPerformed(evt);
            }
        });

        cboAgenciaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaDestinoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Métodos de pago:");

        btnGrupoPago.add(rbnEfectivo);
        rbnEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        rbnEfectivo.setText("1");
        rbnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnEfectivoActionPerformed(evt);
            }
        });

        btnGrupoPago.add(rbnTarjeta);
        rbnTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        rbnTarjeta.setText("2");

        btnGrupoPago.add(rbnYape);
        rbnYape.setForeground(new java.awt.Color(255, 255, 255));
        rbnYape.setText("3");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Total a Pagar (S/): ");

        cboTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrabajadorActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Trabajador:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalAPagar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(cboAgenciaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboAgenciaDestino, 0, 99, Short.MAX_VALUE)
                            .addComponent(cboTrabajador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(rbnEfectivo)
                        .addGap(34, 34, 34)
                        .addComponent(rbnTarjeta)
                        .addGap(47, 47, 47)
                        .addComponent(rbnYape)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cboAgenciaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cboAgenciaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(rbnEfectivo)
                    .addComponent(rbnTarjeta)
                    .addComponent(rbnYape))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cboTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("Limpiar");

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnRegistrar)
                        .addGap(59, 59, 59)
                        .addComponent(btnLimpiar)
                        .addGap(54, 54, 54)
                        .addComponent(btnCancelar)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnCancelar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      
        String descripcion = taDescripcionEncomienda.getText();
        double peso = Double.parseDouble(txtPeso.getText());
        double largo = Double.parseDouble(txtLargo.getText());
        double alto = Double.parseDouble(txtAlto.getText());
        double ancho = Double.parseDouble(txtAncho.getText());
        int idRuta = rutaSeleccionada.getIdRuta();
        String fecha_envio = LocalDate.now().toString();
        String estado = "Sin Asignar";
        int idTrabajador = ((Trabajador) cboTrabajador.getSelectedItem()).getIdTrabajador();
        int idMetodoPago = 1;
        if (rbnEfectivo.isSelected()) {
            idMetodoPago = 1;
        } else if (rbnTarjeta.isSelected()) {
            idMetodoPago = 2;
        } else if (rbnYape.isSelected()) {
            idMetodoPago = 3;
        }
        // VALIDACIONES
        ControladorEncomienda controlador = new ControladorEncomienda();
        controlador.registrarEncomienda(
            idRemitente,
            idDestinatario,
            idRuta,
            descripcion,
            peso,
            largo,
            alto,
            ancho,
            fleteFinal,
            fecha_envio,
            estado,
            idTrabajador,
            idMetodoPago
        );
       
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cboTipoEncomiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoEncomiendaActionPerformed
        TipoPaquete tipo = (TipoPaquete) cboTipoEncomienda.getSelectedItem();
        if (tipo ==null) {
             return;
        }
        
        if (tipo.getNombre().equals("Seleccionar...")) {
            desactivarCamposDimensiones();
            txtPeso.setText("");
            txtLargo.setText("");
            txtAncho.setText("");
            txtAlto.setText("");
            return;
        }
        
        txtPeso.setText(""+ tipo.getMaxPeso());
        txtLargo.setText(""+ tipo.getMaxLargo());
        txtAncho.setText(""+ tipo.getMaxAncho());
        txtAlto.setText(""+ tipo.getMaxAlto());
        
        txtPeso.setEnabled(false);
        txtLargo.setEnabled(false);
        txtAncho.setEnabled(false);
        txtAlto.setEnabled(false);
        
        JOptionPane.showMessageDialog(this, "Límites del tipo seleccionado:\n" +
        "- Peso máximo: " + tipo.getMaxPeso() + " kg\n" +
        "- Largo: " + tipo.getMaxLargo() + " cm\n" +
        "- Ancho: " + tipo.getMaxAncho() + " cm\n" +
        "- Alto: " + tipo.getMaxAlto() + " cm\n ");
        
        calcularFlete();
        txtFlete.setEnabled(false);
        datosEncomiendaCompletos = true;
    }//GEN-LAST:event_cboTipoEncomiendaActionPerformed

    private void cboAgenciaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgenciaDestinoActionPerformed
        // Obtener la agencia de origen y la de destino de los comboboxes
        Agencia agenciaOrigen = (Agencia) cboAgenciaOrigen.getSelectedItem();
        Agencia agenciaDestino = (Agencia) cboAgenciaDestino.getSelectedItem();

        if(!datosEncomiendaCompletos) {
            return;
        }
        
        // Asegurarse de que ambas agencias sean válidas y diferentes
        if (agenciaOrigen == null || agenciaDestino == null || agenciaOrigen.equals(agenciaDestino)) {
            txtTotalAPagar.setText("0.00");
            return;
        }
        
        // Asignar ruta
        ControladorEncomienda controladorEncomienda = new ControladorEncomienda();
        rutaSeleccionada = controladorEncomienda.obtenerRuta(agenciaOrigen.getIdAgencia(), agenciaDestino.getIdAgencia());

        if (rutaSeleccionada != null) {
            double costoBase = rutaSeleccionada.getCostoBase();
            // Mostrar el costo base de la ruta
            JOptionPane.showMessageDialog(this, 
                "Ruta asignada: " + rutaSeleccionada.getDescripcion() + 
                "\nCosto Base: S/" + String.format("%.2f", costoBase));
            
            if(fleteInicial > costoBase) {
                fleteFinal = fleteInicial * 1.18;
                txtTotalAPagar.setText(String.format("%.2f", fleteFinal));
            } else {
                fleteFinal = costoBase *1.18;
                txtTotalAPagar.setText(String.format("%.2f", fleteFinal));
            }
        } else {
            txtTotalAPagar.setText("0.00");
            JOptionPane.showMessageDialog(this, "No existe una ruta directa válida entre estas agencias.", "Ruta no encontrada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cboAgenciaDestinoActionPerformed

    private void cboAgenciaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgenciaOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAgenciaOrigenActionPerformed

    private void txtFleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFleteActionPerformed

    private void btnBuscarRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRemitenteActionPerformed
        String DNI = txtBuscarRemitente.getText().trim();
        ControladorCliente controladorCliente = new ControladorCliente();
        Cliente cliente = controladorCliente.buscarPorDni(DNI);
        
        if(cliente != null) {
            txtNombreRemitente.setText(cliente.getNombres() +" "+ cliente.getApellido_paterno());
            txtDNIRemitente.setText(cliente.getDni());
            txtTelefonoRemitente.setText(cliente.getTelefono());
            idRemitente = cliente.getIdcliente();
        }
    }//GEN-LAST:event_btnBuscarRemitenteActionPerformed

    private void txtNombreDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreDestinatarioActionPerformed

    private void btnBuscarDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDestinatarioActionPerformed
        String DNI = txtBuscarDestinatario.getText().trim();
        ControladorCliente controladorCliente = new ControladorCliente();
        Cliente cliente = controladorCliente.buscarPorDni(DNI);
        
        if(cliente != null) {
            txtNombreDestinatario.setText(cliente.getNombres() +" "+ cliente.getApellido_paterno());
            txtDNIDestinatario.setText(cliente.getDni());
            txtTelefonoDestinatario.setText(cliente.getTelefono());
            idDestinatario = cliente.getIdcliente();
        }
    }//GEN-LAST:event_btnBuscarDestinatarioActionPerformed

    private void btnRegistrarRemitenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarRemitenteActionPerformed
        ModuloClientes modulo = new ModuloClientes();
        modulo.setVisible(true);
    }//GEN-LAST:event_btnRegistrarRemitenteActionPerformed

    private void btnRegistrarDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDestinatarioActionPerformed
        ModuloClientes modulo = new ModuloClientes();
        modulo.setVisible(true);
    }//GEN-LAST:event_btnRegistrarDestinatarioActionPerformed

    private void cboTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrabajadorActionPerformed

    private void rbnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnEfectivoActionPerformed
   
    public void limpiarCampos(){
        
    }
    
    private void cargarAgencias(){
        ControladorAgenciaForm ctrl = new ControladorAgenciaForm();
        List<Agencia> lista = ctrl.listar();
        
        cboAgenciaOrigen.removeAllItems();
        cboAgenciaDestino.removeAllItems();
        
        for (Agencia a : lista) {
            cboAgenciaOrigen.addItem(a);
            cboAgenciaDestino.addItem(a);
        }
    }
    
    private void cargarTrabajadores(){
        cboTrabajador.removeAllItems();
        
        ControladorTrabajador ctrl = new ControladorTrabajador();
        //Obtenemos la lista desde el controlador
        List<Trabajador> lista = ctrl.listarTrabajadores();
        
        Trabajador seleccion = new Trabajador();
        seleccion.setIdTrabajador(0);
        seleccion.setNombres("Seleccione...");
        seleccion.setApellido_paterno("");
        seleccion.setApellido_materno("");
        
        cboTrabajador.addItem(seleccion);
        
        for (Trabajador t : lista) {
            cboTrabajador.addItem(t);
        }
    }
    
    private void cargarTipoPaquete(){
        cboTipoEncomienda.removeAllItems();
        
        // 1. Inicializar el HashMap
        preciosPorTipoPaquete = new java.util.HashMap<>();

        // Definir los tipos de paquete y sus precios
        TipoPaquete seleccionar = new TipoPaquete("Seleccionar...", 0, 0, 0, 0);
        TipoPaquete sobre = new TipoPaquete("Sobre", 0.250, 15, 10, 10);
        TipoPaquete cajaXXS = new TipoPaquete("Caja paquete XXS", 0.250, 15, 10, 10);
        TipoPaquete cajaXS = new TipoPaquete("Caja paquete XS", 0.500, 15, 20, 12);
        TipoPaquete cajaS = new TipoPaquete("Caja paquete S", 2, 20, 30, 12);
        TipoPaquete cajaM = new TipoPaquete("Caja paquete M", 5, 24, 30, 20);
        TipoPaquete cajaL = new TipoPaquete("Caja paquete L", 10, 42, 30, 23);

        // 2. Agregar al ComboBox y al HashMap con su precio base (ejemplos de precios)

        // Opción "Seleccionar..."
        cboTipoEncomienda.addItem(seleccionar);
        preciosPorTipoPaquete.put(seleccionar, 0.0); 

        // Paquetes
        cboTipoEncomienda.addItem(sobre);
        preciosPorTipoPaquete.put(sobre, 5.0);

        cboTipoEncomienda.addItem(cajaXXS);
        preciosPorTipoPaquete.put(cajaXXS, 8.0);

        cboTipoEncomienda.addItem(cajaXS);
        preciosPorTipoPaquete.put(cajaXS, 10.0);

        cboTipoEncomienda.addItem(cajaS);
        preciosPorTipoPaquete.put(cajaS, 12.0);

        cboTipoEncomienda.addItem(cajaM);
        preciosPorTipoPaquete.put(cajaM, 14.0); 

        cboTipoEncomienda.addItem(cajaL);
        preciosPorTipoPaquete.put(cajaL, 18.0);
    }
    
    private void cargarMetodosPago(){
        ControladorMetodoPago ctrl = new ControladorMetodoPago();
        List<MetodoPago> lista = ctrl.obtenerMetodosPago();
        rbnEfectivo.setText(lista.get(0).getNombre());
        rbnTarjeta.setText(lista.get(1).getNombre());
        rbnYape.setText(lista.get(2).getNombre());
    }
   
    public String getTipoPaquete(){
        return cboTipoEncomienda.getSelectedItem().toString();
    }
    
    public double getPeso(){
        return Double.parseDouble(txtPeso.getText());
    }
    
    private void desactivarCamposDimensiones(){
        txtPeso.setEnabled(false);
        txtLargo.setEnabled(false);
        txtAncho.setEnabled(false);
        txtAlto.setEnabled(false);
    }
    
    private void calcularFlete() {
        // 1. Obtener el TipoPaquete seleccionado del ComboBox
        TipoPaquete tipoSeleccionado = (TipoPaquete) cboTipoEncomienda.getSelectedItem();

        if (tipoSeleccionado != null && preciosPorTipoPaquete.containsKey(tipoSeleccionado)) {
            // 2. Obtener el precio base usando el objeto TipoPaquete como clave
            fleteInicial = preciosPorTipoPaquete.get(tipoSeleccionado);
            txtFlete.setText(String.format("%.2f", fleteInicial));
        } else {
            txtFlete.setText("0.00");
        }
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
            java.util.logging.Logger.getLogger(ModuloRegistrarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloRegistrarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloRegistrarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloRegistrarEncomienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloRegistrarEncomienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDestinatario;
    private javax.swing.JButton btnBuscarRemitente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGrupoPago;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarDestinatario;
    private javax.swing.JButton btnRegistrarRemitente;
    private javax.swing.JComboBox<Agencia> cboAgenciaDestino;
    private javax.swing.JComboBox<Agencia> cboAgenciaOrigen;
    private javax.swing.JComboBox<TipoPaquete> cboTipoEncomienda;
    private javax.swing.JComboBox<Trabajador> cboTrabajador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbnEfectivo;
    private javax.swing.JRadioButton rbnTarjeta;
    private javax.swing.JRadioButton rbnYape;
    private javax.swing.JTextArea taDescripcionEncomienda;
    private javax.swing.JTextField txtAlto;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtBuscarDestinatario;
    private javax.swing.JTextField txtBuscarRemitente;
    private javax.swing.JTextField txtDNIDestinatario;
    private javax.swing.JTextField txtDNIRemitente;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtNombreDestinatario;
    private javax.swing.JTextField txtNombreRemitente;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtTelefonoDestinatario;
    private javax.swing.JTextField txtTelefonoRemitente;
    private javax.swing.JTextField txtTotalAPagar;
    // End of variables declaration//GEN-END:variables
}
