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

import model.Destino;
import model.ReporteVuelo;
import model.Vuelo;


/**
 * Servlet implementation class VueloControllerServlet
 */
@WebServlet(name = "vuelocontrol", description = "Controlado de vuelos", urlPatterns = { "/vuelocontrol" })
public class VueloControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VueloControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("btnAccion");
		switch (accion) {
		case "listarVuelo": {
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);
			ArrayList<Vuelo> listado= fabrica.getVueloDAO().listadoVuelo();
			request.setAttribute("lstVuelos", listado);
		}
		case "registrar":
			String codigoVuelo = request.getParameter("txtCodigo");
			String codAvion = request.getParameter("txtAvion");
			String piloto = request.getParameter("txtPiloto");
			String copiloto = request.getParameter("txtCopiloto");
			String desSalida = request.getParameter("cboDe");
			String desLlegada = request.getParameter("cboA");
			double precio = Double.parseDouble(request.getParameter("txtPrecio")) ;
			String hora = request.getParameter("txtHora");
			String FechaSalida = request.getParameter("txtSalida");
			String FechaLlegada = request.getParameter("txtLLegada");
			Vuelo vu = new Vuelo();
			
			vu.setCodVuelo(codigoVuelo);
			vu.setCodAvion(Integer.parseInt(codAvion));
			vu.setPiloto(piloto);
			vu.setCopiloto(copiloto);
			vu.setCodDesSalida(Integer.parseInt(desSalida));
			vu.setCodDesLlegada(Integer.parseInt(desLlegada));
			vu.setPrecioVuelo(precio);
			vu.setHoraVuelo(hora);
			vu.setFechaLlegada(FechaLlegada);
			vu.setFechaSalida(FechaSalida);

			
			System.out.println(codigoVuelo);
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			int ok = fabrica.getVueloDAO().registrar(vu);

			if (ok == 0) {
				fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ArrayList<ReporteVuelo> lstVuelos = fabrica.getReporteVueloDAO().listado();
				request.setAttribute("lstVuelos",lstVuelos);		
				request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("FormularioVuelo.jsp").forward(request, response);
			}else {
				fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ArrayList<ReporteVuelo> lstVuelos = fabrica.getReporteVueloDAO().listado();
				request.setAttribute("lstVuelos",lstVuelos);		
				request.setAttribute("mensaje","<script>swal('Mensaje!','Vuelo Registrado', 'success');</script>");
				request.getRequestDispatcher("MantenimientoVuelo.jsp").forward(request, response);
			}
			break;
		case "actualizar":
			 codigoVuelo = request.getParameter("txtCodigo");
			 codAvion = request.getParameter("txtAvion");
			 piloto = request.getParameter("txtPiloto");
			 copiloto = request.getParameter("txtCopiloto");
			 desSalida = request.getParameter("cboDe");
			 desLlegada = request.getParameter("cboA");
			 precio = Double.parseDouble(request.getParameter("txtPrecio")) ;
			 hora = request.getParameter("txtHora");
			 FechaSalida = request.getParameter("txtSalida");
			 FechaLlegada = request.getParameter("txtLLegada");	 
			  vu = new Vuelo();
			 
			  	vu.setCodVuelo(codigoVuelo);
				vu.setCodAvion(Integer.parseInt(codAvion));
				vu.setPiloto(piloto);
				vu.setCopiloto(copiloto);
				vu.setCodDesSalida(Integer.parseInt(desSalida));
				vu.setCodDesLlegada(Integer.parseInt(desLlegada));
				vu.setPrecioVuelo(precio);
				vu.setHoraVuelo(hora);
				vu.setFechaLlegada(FechaLlegada);
				vu.setFechaSalida(FechaSalida);
				
				fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ok = fabrica.getVueloDAO().actualizar(vu);
				
				//SALIDA
				if (ok == 0) {
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<ReporteVuelo> lstVuelos = fabrica.getReporteVueloDAO().listado();
					request.setAttribute("lstVuelos",lstVuelos);		
					request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
					request.getRequestDispatcher("FormularioVuelo.jsp").forward(request, response);				
				}else {
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<ReporteVuelo> lstVuelos = fabrica.getReporteVueloDAO().listado();
					request.setAttribute("lstVuelos",lstVuelos);		
					request.setAttribute("mensaje","<script>swal('Mensaje','Vuelo Actualizado', 'success');</script>");
					request.getRequestDispatcher("MantenimientoVuelo.jsp").forward(request, response);
				}
			break;
		case "eliminar":
			 codigoVuelo = request.getParameter("codigo");
			  vu = new Vuelo();
				 
			 vu.setCodVuelo(codigoVuelo);
			 fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ok = fabrica.getVueloDAO().eliminar(vu);

				if (ok == 0) {
					request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Elimina primero al cliente!',});</script>");
					request.getRequestDispatcher("MantenimientoVuelo.jsp").forward(request, response);
				}else {
					request.setAttribute("mensaje","<script>swal('Mensaje','Vuelo Eliminado', 'success');</script>");
					
					request.getRequestDispatcher("MantenimientoVuelo.jsp").forward(request, response);
				}
			break;
		case "buscar":
			 codigoVuelo = request.getParameter("codigo");
			 fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			 vu =  fabrica.getVueloDAO().buscar(codigoVuelo);
			 request.setAttribute("vu", vu);
			 request.getRequestDispatcher("FormularioVuelo.jsp").forward(request, response);			
			break;
		case "FiltrarVuelos":
			String fecha1 = request.getParameter("Fecha1");
			String fecha2 = request.getParameter("Fecha2");
			 fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			 ArrayList<ReporteVuelo> list = fabrica.getReporteVueloDAO().buscarxFecha(fecha1, fecha2);
			 request.setAttribute("lstVuelos",list);
			 request.setAttribute("lstVuelos",list);
			 request.getRequestDispatcher("reporteVuelo.jsp").forward(request, response);
			break;
		case "pdf":
			
			String Archivo = "D:\\ReporteVuelos.pdf";
			convertirPDF(response, request, Archivo);
			break;
		default:
		
		}
		
	}

	private void convertirPDF(HttpServletResponse response, HttpServletRequest request, String archivo) {
		// TODO Auto-generated method stub
		try {
			String Archivo = "D:\\ReporteVuelos.pdf";
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(Archivo);
			PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			//logo
			/*
			Image img = Image.getInstance("img/logo_blanco.png");
			img.scaleToFit(90,90);
			img.setAlignment(Chunk.ALIGN_RIGHT);
			plantilla.add(img);*/
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
			Paragraph p1 = new Paragraph("Reporte de Vuelos ",FontFactory.getFont("FontFamily",12,Font.BOLD,BaseColor.DARK_GRAY));
			p1.setAlignment(Element.ALIGN_JUSTIFIED);
			plantilla.add(p1);
			//pie de pagina
			/*
			Image pie1 = Image.getInstance("img/ig.jpg");
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
				PdfPTable tabla = new PdfPTable(6);
				tabla.setWidthPercentage(110);
				tabla.getDefaultCell().setBorder(0);
				float[] ColumnaProd = new float[] {10f, 20f, 20f,10f, 15f, 15f};
				tabla.setWidths(ColumnaProd);
				PdfPCell vu1 = new PdfPCell(new Phrase("Codigo"));
				PdfPCell vu2 = new PdfPCell(new Phrase("Piloto"));
				PdfPCell vu3 = new PdfPCell(new Phrase("Copiloto"));
				PdfPCell vu4 = new PdfPCell(new Phrase("Hora"));				
				PdfPCell vu5 = new PdfPCell(new Phrase("Fecha de Salida"));
				PdfPCell vu6 = new PdfPCell(new Phrase("Fecha de Llegada"));
				 vu1.setBorder(0);
				 vu2.setBorder(0);
				 vu3.setBorder(0);
				 vu4.setBorder(0);
				 vu5.setBorder(0);
				 vu6.setBorder(0);
				 vu1.setBackgroundColor(BaseColor.CYAN);
				 vu2.setBackgroundColor(BaseColor.CYAN);
				 vu3.setBackgroundColor(BaseColor.CYAN);
				 vu4.setBackgroundColor(BaseColor.CYAN);
				 vu5.setBackgroundColor(BaseColor.CYAN);
				 vu6.setBackgroundColor(BaseColor.CYAN);
				tabla.addCell( vu1);
				tabla.addCell( vu2);
				tabla.addCell( vu3);
				tabla.addCell( vu4);
				tabla.addCell( vu5);
				tabla.addCell( vu6);
				//RECORRIDO
				DAOFactory fabrica = DAOFactory.getDaoFactory(1);
				ArrayList<ReporteVuelo> lstVuelos= fabrica.getReporteVueloDAO().listado();
				request.setAttribute("lstVuelos", lstVuelos);
				request.getRequestDispatcher("reporteVuelo.jsp").forward(request, response);
				for(ReporteVuelo c : lstVuelos) {
					tabla.addCell(c.getCodigo() + " ");						
					tabla.addCell(c.getPiloto());
					tabla.addCell(c.getCopiloto());
					tabla.addCell(c.getHora());
					tabla.addCell(c.getFecha_Salida());
					tabla.addCell(c.getFecha_Llegada());
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
		
	}

}
