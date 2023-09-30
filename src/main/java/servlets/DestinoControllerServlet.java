package servlets;


import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.DAOFactory;

import model.ReporteDestino;

/**
 * Servlet implementation class DestinoControlador
 */
@WebServlet(name = "destino", urlPatterns = { "/destino" })
public class DestinoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestinoControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String accion = request.getParameter("btnAccion");
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		// segun la accion seleccionada, ralizar.....
		switch (accion) {
		case "buscarDestino": 
			String datos = request.getParameter("txtNombre");	
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteDestino> busca = fabrica.getReporteDestinoDAO().BuscarDestino(datos);
			 request.setAttribute("lstDestinos",busca);
			 request.getRequestDispatcher("reporteDestinos.jsp").forward(request, response);
			break;
		case "pdf":
			String Archivo = "D:\\ReporteDestinos.pdf";
			try {
				Document plantilla = new Document();
				FileOutputStream fos = new FileOutputStream(Archivo);
				PdfWriter.getInstance(plantilla, fos);
				plantilla.open();
				//logo
				/*
				Image img = Image.getInstance("D:\\ARIEL\\CIBERTEC 4 CICLO\\LENGUAJE DE PROGRAMACION II\\ECLIPSE\\Proyecto\\Proyecto\\src\\main\\webapp\\img\\logo_blanco.png");
				img.scaleToFit(90,90);
				img.setAlignment(Chunk.ALIGN_RIGHT);
				plantilla.add(img);
				*/
				//fecha
				Paragraph fecha = new Paragraph();
				fecha.setAlignment(Chunk.ALIGN_RIGHT);
				Date date = new Date();
				fecha.add("Fecha: "+ new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
				plantilla.add(fecha);
				//agregar titulo
				Paragraph p = new Paragraph("AMAE AERLINES ",FontFactory.getFont("FontFamily",32,Font.BOLD,BaseColor.GRAY));
				p.setAlignment(Element.ALIGN_JUSTIFIED);
				plantilla.add(p);
				//agregar Subtitulo
				Paragraph p1 = new Paragraph("Reporte de Destinos ",FontFactory.getFont("FontFamily",12,Font.BOLD,BaseColor.DARK_GRAY));
				p1.setAlignment(Element.ALIGN_JUSTIFIED);
				plantilla.add(p1);
				//pie de pagina
				/*
				Image pie1 = Image.getInstance("D:\\ARIEL\\CIBERTEC 4 CICLO\\LENGUAJE DE PROGRAMACION II\\ECLIPSE\\Proyecto\\Proyecto\\src\\main\\webapp\\img\\ig.jpg");
				pie1.scaleToFit(90,90);
				pie1.setAlignment(Chunk.ALIGN_CENTER);
				*/
				//pie2
				Paragraph pie2 = new Paragraph("Derechos Reservados, Lima - Peú 2022 ",FontFactory.getFont("FontFamily",12,Font.BOLD,BaseColor.DARK_GRAY));
				pie2.setAlignment(Element.ALIGN_CENTER);		
				//separador1
				Paragraph ca = new Paragraph("      ",FontFactory.getFont("FontFamily",22));
				ca.setAlignment(Element.ALIGN_JUSTIFIED);
				plantilla.add(ca);	
				//separador2
				Paragraph ca1 = new Paragraph("      ",FontFactory.getFont("FontFamily",145));
				ca1.setAlignment(Element.ALIGN_CENTER);
					//crear tabla
					PdfPTable tabla = new PdfPTable(4);
					tabla.setWidthPercentage(110);
					tabla.getDefaultCell().setBorder(0);
					float[] ColumnaProd = new float[] {10f, 25f, 15f, 15f};
					tabla.setWidths(ColumnaProd);
					PdfPCell vu1 = new PdfPCell(new Phrase("Codigo"));
					PdfPCell vu2 = new PdfPCell(new Phrase("Aeropuerto"));
					PdfPCell vu3 = new PdfPCell(new Phrase("Ciudad"));
					PdfPCell vu4 = new PdfPCell(new Phrase("País"));
					 vu1.setBorder(0);
					 vu2.setBorder(0);
					 vu3.setBorder(0);
					 vu4.setBorder(0);
					 vu1.setBackgroundColor(BaseColor.CYAN);
					 vu2.setBackgroundColor(BaseColor.CYAN);
					 vu3.setBackgroundColor(BaseColor.CYAN);
					 vu4.setBackgroundColor(BaseColor.CYAN);
					tabla.addCell( vu1);
					tabla.addCell( vu2);
					tabla.addCell( vu3);
					tabla.addCell( vu4);
					//RECORRIDO
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<ReporteDestino> lstDestinos = fabrica.getReporteDestinoDAO().listado();
					 request.setAttribute("lstDestinos",lstDestinos);
					 request.getRequestDispatcher("reporteDestinos.jsp").forward(request, response);
					for(ReporteDestino c : lstDestinos) {
						tabla.addCell(c.getCodigo() + " ");						
						tabla.addCell(c.getAeropuerto());
						tabla.addCell(c.getCiudad());
						tabla.addCell(c.getPais());
					}
					plantilla.add(tabla);
					plantilla.add(ca1);
					//plantilla.add(pie1);
					plantilla.add(pie2);
				plantilla.close();
				Desktop.getDesktop().open(new File(Archivo));
				fos.close();
			} catch(Exception e) {
				System.out.println("ERROR AL GENERAR REPORTE "+e.getMessage());
			}
			break;
		default:
}
	}

}
