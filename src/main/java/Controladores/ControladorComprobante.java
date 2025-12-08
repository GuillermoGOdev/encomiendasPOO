
package Controladores;

import DAO.ComprobanteDAO;
import DTO.Comprobante;
import DTO.Encomienda;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorComprobante {
    private ComprobanteDAO dao;

    public ControladorComprobante() {
        dao = new ComprobanteDAO();
    }

    // ---- Registrar comprobante ----
    public boolean registrarComprobante(Comprobante c) {
        validarComprobante(c);
        return dao.registrar(c);
    }

    // ---- Listar comprobantes ----
    public List<Comprobante> listarComprobantes() {
        return dao.listar();
    }

    // ---- Buscar comprobante por ID ----
    public Comprobante buscarPorId(int id) {
        return dao.buscar(id);
    }

//    // ---- Buscar por Encomienda ----
//    public Comprobante buscarPorEncomienda(int idEncomienda) {
//        return dao.buscar(idEncomienda);
//    }

    // ---- Cálculo de totales ----
    public double calcularSubtotal(double precioServicio) {
        return precioServicio;
    }

    public double calcularIGV(double subtotal) {
        return subtotal * 0.18;
    }

    public double calcularTotal(double subtotal, double igv) {
        return subtotal + igv;
    }

    // ---- Validaciones ----
    private void validarComprobante(Comprobante c) {
        if (c.getTipo() == null || c.getTipo().isEmpty())
            throw new IllegalArgumentException("El tipo de comprobante es obligatorio");

        if (c.getSubtotal() < 0)
            throw new IllegalArgumentException("El subtotal no puede ser negativo");

        if (c.getIdMetodoPago() <= 0)
            throw new IllegalArgumentException("Debe seleccionar un método de pago");
    }

    public void generarPDF(Comprobante c, Encomienda e, String usuarioAtendio) {
        try {
            // 1. Configuración del Documento
            String nombreArchivo = "Comprobante_" + c.getNumero() + ".pdf";
            Document doc = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(nombreArchivo));
            doc.open();

            // 2. Fuentes y Colores
            BaseColor colorPrincipal = new BaseColor(44, 62, 80);
            BaseColor colorGris = new BaseColor(230, 230, 230);

            Font fontEmpresa = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, colorPrincipal);
            Font fontTituloBox = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
            Font fontCabeceraTabla = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
            Font fontNormal = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
            Font fontNegrita = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
            Font fontTotal = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
            Font fontLegal = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.GRAY);

            // Formateador de moneda
            DecimalFormat df = new DecimalFormat("S/ #,##0.00");

            // ==========================================
            // 3. ENCABEZADO (Logo + Cuadro RUC)
            // ==========================================
            PdfPTable tblHeader = new PdfPTable(2);
            tblHeader.setWidthPercentage(100);
            tblHeader.setWidths(new float[]{2f, 1f});

            // --- Celda Izquierda: Datos de la Empresa y Logo ---
            PdfPCell cellEmpresa = new PdfPCell();
            cellEmpresa.setBorder(Rectangle.NO_BORDER);

            //Logo
            try {
                String pathRecurso = "Iconos/Logo.png";
                // Usar ClassLoader para obtener la URL del recurso
                URL imageUrl = getClass().getClassLoader().getResource(pathRecurso);
                
                Image logo = Image.getInstance(imageUrl);
                logo.scaleToFit(100, 50);
                cellEmpresa.addElement(logo);
            } catch (Exception ex) {
                System.err.println("Error al cargar el logo: ");
                ex.printStackTrace();
            }
             
            cellEmpresa.addElement(new Paragraph("KREG EXPRESS S.A.C.", fontEmpresa));
            cellEmpresa.addElement(new Paragraph("Av. Principal 123, Lima, Perú", fontNormal));
            cellEmpresa.addElement(new Paragraph("Tel: (01) 555-1234 | email@empresa.com", fontNormal));
            tblHeader.addCell(cellEmpresa);

            // --- Celda Derecha: Cuadro Tipo de Comprobante ---
            PdfPTable tblRuc = new PdfPTable(1);
            PdfPCell cellRuc = new PdfPCell();
            cellRuc.setBorder(Rectangle.BOX);
            cellRuc.setBorderWidth(1.5f);
            cellRuc.setPadding(10);

            String rucFicticio = "R.U.C. 20123456789";
            Paragraph pRuc = new Paragraph(rucFicticio, fontTituloBox);
            pRuc.setAlignment(Element.ALIGN_CENTER);
            cellRuc.addElement(pRuc);

            Paragraph pTipo = new Paragraph(c.getTipo().toUpperCase(), fontTituloBox);
            pTipo.setAlignment(Element.ALIGN_CENTER);
            pTipo.setSpacingBefore(5);
            cellRuc.addElement(pTipo);

            Paragraph pNum = new Paragraph(c.getSerie() + " - " + c.getNumero(), fontTituloBox);
            pNum.setAlignment(Element.ALIGN_CENTER);
            pNum.setSpacingBefore(5);
            cellRuc.addElement(pNum);

            tblRuc.addCell(cellRuc);

            PdfPCell cellContenedorRuc = new PdfPCell(tblRuc);
            cellContenedorRuc.setBorder(Rectangle.NO_BORDER);
            tblHeader.addCell(cellContenedorRuc);

            doc.add(tblHeader);
            doc.add(new Paragraph("\n"));

            // ==========================================
            // 4. DATOS DEL CLIENTE Y FECHA
            // ==========================================
            PdfPTable tblCliente = new PdfPTable(2);
            tblCliente.setWidthPercentage(100);
            tblCliente.setSpacingAfter(10f);

            tblCliente.addCell(getCellSinBorde("Fecha de Emisión: " + c.getFechaEmision(), fontNormal));
            tblCliente.addCell(getCellSinBorde("Usuario Atiende: " + usuarioAtendio, fontNormal));

            doc.add(tblCliente);

            LineSeparator ls = new LineSeparator();
            ls.setLineColor(colorGris);
            doc.add(ls);
            doc.add(new Paragraph("\n"));

            // ==========================================
            // 5. CODIGO DE BARRAS (TRACKING)
            // ==========================================
            PdfContentByte cb = writer.getDirectContent();
            Barcode128 code128 = new Barcode128();
            code128.setCode(String.valueOf(e.getIdEncomienda()));
            code128.setCodeType(Barcode128.CODE128);
            Image code128Image = code128.createImageWithBarcode(cb, null, null);
            code128Image.scalePercent(150);
            code128Image.setAlignment(Element.ALIGN_CENTER);

            doc.add(new Paragraph("Código de Seguimiento:", fontNegrita));
            doc.add(code128Image);
            doc.add(new Paragraph("\n"));

            // ==========================================
            // 6. DETALLE (TABLA TIPO FACTURA)
            // ==========================================
            PdfPTable tblDetalle = new PdfPTable(5);
            tblDetalle.setWidthPercentage(100);
            tblDetalle.setWidths(new float[]{1f, 4f, 2f, 2f, 2f});

            // Encabezados
            tblDetalle.addCell(getHeaderCell("ID ENCOMIENDA", fontCabeceraTabla, colorPrincipal));
            tblDetalle.addCell(getHeaderCell("DESCRIPCIÓN", fontCabeceraTabla, colorPrincipal));
            tblDetalle.addCell(getHeaderCell("PESO", fontCabeceraTabla, colorPrincipal));
            tblDetalle.addCell(getHeaderCell("MEDIDAS", fontCabeceraTabla, colorPrincipal));
            tblDetalle.addCell(getHeaderCell("IMPORTE", fontCabeceraTabla, colorPrincipal));

            // Datos
            tblDetalle.addCell(getDataCell(String.valueOf(e.getIdEncomienda()), fontNormal, Element.ALIGN_CENTER));

            String desc = (e.getDescripcion() == null || e.getDescripcion().isBlank()) ? "Sin descripción" : e.getDescripcion();
            tblDetalle.addCell(getDataCell(desc, fontNormal, Element.ALIGN_LEFT));

            tblDetalle.addCell(getDataCell(e.getPeso_kg() + " kg", fontNormal, Element.ALIGN_CENTER));

            String medidas = e.getLargo() + "x" + e.getAncho() + "x" + e.getAlto() + "cm";
            tblDetalle.addCell(getDataCell(medidas, fontNormal, Element.ALIGN_CENTER));

            tblDetalle.addCell(getDataCell("S/ " + e.getCostoEnvio(), fontNormal, Element.ALIGN_RIGHT));

            // Rellenar vacíos
            for (int i = 0; i < 4; i++) {
                tblDetalle.addCell(getDataCell(" ", fontNormal, Element.ALIGN_CENTER));
                tblDetalle.addCell(getDataCell(" ", fontNormal, Element.ALIGN_CENTER));
                tblDetalle.addCell(getDataCell(" ", fontNormal, Element.ALIGN_CENTER));
                tblDetalle.addCell(getDataCell(" ", fontNormal, Element.ALIGN_CENTER));
                tblDetalle.addCell(getDataCell(" ", fontNormal, Element.ALIGN_CENTER));
            }

            doc.add(tblDetalle);
            doc.add(new Paragraph("\n"));

            // ==========================================
            // 7. TOTALES 
            // ==========================================
            PdfPTable tblTotales = new PdfPTable(2);
            tblTotales.setWidthPercentage(40);
            tblTotales.setHorizontalAlignment(Element.ALIGN_RIGHT);

            tblTotales.addCell(getCellSinBorde("SUBTOTAL:", fontNegrita));
            tblTotales.addCell(getCellMonto("S/ " + c.getSubtotal(), fontNormal));

            tblTotales.addCell(getCellSinBorde("IGV (18%):", fontNegrita));
            tblTotales.addCell(getCellMonto("S/ " + c.getIgv(), fontNormal));

            PdfPCell lineaCell = new PdfPCell(new Paragraph(" "));
            lineaCell.setBorder(Rectangle.BOTTOM);
            lineaCell.setColspan(2);
            tblTotales.addCell(lineaCell);

            PdfPCell cellLeyendaTotal = getCellSinBorde("TOTAL:", fontTotal);
            cellLeyendaTotal.setPaddingTop(5);
            tblTotales.addCell(cellLeyendaTotal);

            PdfPCell cellMontoTotal = getCellMonto("S/ " + c.getTotal(), fontTotal);
            cellMontoTotal.setPaddingTop(5);
            tblTotales.addCell(cellMontoTotal);

            doc.add(tblTotales);
            doc.add(new Paragraph("\n"));

            // ==========================================
            // 8. QR (VALIDACIÓN AL FINAL)
            // ==========================================
            String dataQR = rucFicticio + "|" + c.getTipo() + "|" + c.getSerie() + "-" + c.getNumero() + "|" + c.getTotal();
            BarcodeQRCode qrCode = new BarcodeQRCode(dataQR, 100, 100, null);
            Image imgQR = qrCode.getImage();
            imgQR.scalePercent(150);

            PdfPTable tblQR = new PdfPTable(1);
            PdfPCell cellQR = new PdfPCell(imgQR);
            cellQR.setBorder(Rectangle.NO_BORDER);
            cellQR.setHorizontalAlignment(Element.ALIGN_CENTER); // QR a la izquierda (debajo de tabla o totales)
            tblQR.addCell(cellQR);

            doc.add(tblQR);

            // ==========================================
            // 9. LEGALES Y PIE DE PÁGINA
            // ==========================================
            String legales = "CONDICIONES DEL SERVICIO: La empresa no se responsabiliza por mercadería mal embalada. "
                    + "El reclamo debe realizarse dentro de las 24 horas. Este documento es una representación impresa "
                    + "de un Comprobante Electrónico. Consulte en www.kregexpress.com.";

            Paragraph pLegales = new Paragraph(legales, fontLegal);
            pLegales.setAlignment(Element.ALIGN_JUSTIFIED);
            pLegales.setSpacingBefore(10);
            doc.add(pLegales);

            doc.add(new Paragraph("\n"));
            Paragraph footer = new Paragraph("¡Gracias por su preferencia!", fontNormal);
            footer.setAlignment(Element.ALIGN_CENTER);
            doc.add(footer);

            // 10. CERRAR DOCUMENTO (AL FINAL)
            doc.close();

            // Abrir Automáticamente
            JOptionPane.showMessageDialog(null, "Comprobante generado exitosamente.");
            File pdf = new File(nombreArchivo);
            if (pdf.exists()) {
                Desktop.getDesktop().open(pdf);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar PDF: " + ex.getMessage());
        }
    }

// ==========================================
// MÉTODOS AUXILIARES (IGUAL QUE ANTES)
// ==========================================
    private PdfPCell getHeaderCell(String text, Font font, BaseColor bg) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(bg);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(6);
        return cell;
    }

    private PdfPCell getDataCell(String text, Font font, int align) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(align);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setBorderColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(6);
        cell.setPaddingBottom(8);
        return cell;
    }

    private PdfPCell getCellSinBorde(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(4);
        return cell;
    }

    private PdfPCell getCellMonto(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPadding(4);
        return cell;
    }

// -------------------------------------------------------------------------------------------------
//    public void generarPDF(Comprobante c, Encomienda e, String usuarioAtendio) {
//        try {
//            // Archivo
//            String nombreArchivo = "Comprobante_" + c.getNumero() + ".pdf";
//            Document doc = new Document(PageSize.A4, 40, 40, 20, 20);
//            PdfWriter.getInstance(doc, new FileOutputStream(nombreArchivo));
//            doc.open();
//
//            // ====== ESTILO ======
//            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
//            Font seccionFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
//            Font normalFont = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);
//
//            // ====== TÍTULO ======
//            Paragraph titulo = new Paragraph("COMPROBANTE DE PAGO", tituloFont);
//            titulo.setAlignment(Element.ALIGN_CENTER);
//            doc.add(titulo);
//
//            doc.add(new Paragraph("\n"));
//
//            // Línea separadora
//            LineSeparator ls = new LineSeparator();
//            doc.add(ls);
//            doc.add(new Paragraph("\n"));
//
//            // ====== TABLA: DATOS DEL COMPROBANTE ======
//            doc.add(new Paragraph("Datos del Comprobante", seccionFont));
//            doc.add(new Paragraph("\n"));
//
//            PdfPTable tblComprobante = new PdfPTable(2);
//            tblComprobante.setWidthPercentage(100);
//
//            tblComprobante.addCell(cell("Tipo:", c.getTipo(), normalFont));
//            tblComprobante.addCell(cell("Serie:", c.getSerie(), normalFont));
//            tblComprobante.addCell(cell("Número:", c.getNumero(), normalFont));
//            tblComprobante.addCell(cell("Fecha emisión:", c.getFechaEmision().toString(), normalFont));
//
//            doc.add(tblComprobante);
//            doc.add(new Paragraph("\n"));
//
//            // ====== TABLA: DATOS DE LA ENCOMIENDA ======
//            doc.add(new Paragraph("Datos de la Encomienda", seccionFont));
//            doc.add(new Paragraph("\n"));
//
//            PdfPTable tblEnc = new PdfPTable(2);
//            tblEnc.setWidthPercentage(100);
//
//            tblEnc.addCell(cell("ID Encomienda:", String.valueOf(e.getIdEncomienda()), normalFont));
//            tblEnc.addCell(cell("Peso:", e.getPeso_kg() + " kg", normalFont));
//
//            tblEnc.addCell(cell("Medidas:",
//                    e.getLargo() + " x " + e.getAncho() + " x " + e.getAlto() + " cm",
//                    normalFont));
//
//            tblEnc.addCell(cell("Costo del Servicio:", "S/ " + e.getCostoEnvio(), normalFont));
//
//            doc.add(tblEnc);
//            doc.add(new Paragraph("\n"));
//
//            // ====== TABLA: CÁLCULOS ======
//            doc.add(new Paragraph("Cálculos", seccionFont));
//            doc.add(new Paragraph("\n"));
//
//            PdfPTable tblCalc = new PdfPTable(2);
//            tblCalc.setWidthPercentage(60);
//            tblCalc.setHorizontalAlignment(Element.ALIGN_LEFT);
//
//            tblCalc.addCell(cell("Subtotal:", "S/ " + c.getSubtotal(), normalFont));
//            tblCalc.addCell(cell("IGV (18%):", "S/ " + c.getIgv(), normalFont));
//            tblCalc.addCell(cell("TOTAL:", "S/ " + c.getTotal(), seccionFont));
//
//            doc.add(tblCalc);
//            doc.add(new Paragraph("\n"));
//
//            // ====== TABLA: USUARIO ======
//            doc.add(new Paragraph("Atendido por", seccionFont));
//            doc.add(new Paragraph("\n"));
//
//            PdfPTable tblUser = new PdfPTable(1);
//            tblUser.setWidthPercentage(50);
//
//            PdfPCell userCell = new PdfPCell(
//                    new Phrase("Usuario: " + usuarioAtendio, normalFont)
//            );
//            userCell.setBorder(Rectangle.BOX);
//            userCell.setPadding(8);
//            tblUser.addCell(userCell);
//
//            doc.add(tblUser);
//
//            doc.close();
//
//            JOptionPane.showMessageDialog(null, "PDF generado correctamente:\n" + nombreArchivo);
//
//            // ABRIR AUTOMÁTICAMENTE
//            File pdf = new File(nombreArchivo);
//            if (pdf.exists()) {
//                Desktop.getDesktop().open(pdf);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error generando PDF");
//        }
//    }
//
//// --- MÉTODO AUXILIAR PARA CELDAS ---
//    private PdfPCell cell(String label, String value, Font f) {
//        PdfPCell c = new PdfPCell(new Phrase(label + " " + value, f));
//        c.setPadding(6);
//        c.setBorder(Rectangle.BOX);
//        return c;
//    }
}
