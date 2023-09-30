package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import dao.DAOFactory;
import model.Destino;
import model.Hotel;
import model.ReservaHabitacion;

/**
 * Servlet implementation class ReservaServlet
 */
@WebServlet(name = "reserva", urlPatterns = { "/reserva" })
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("btnAccion");
		switch (accion) {
		case "registrar":
			registrarReserva(request,response);
			break;

		default:
			break;
		}
	}

	private void registrarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numSoli = request.getParameter("txtNumSoli");
		String fechaHoy = request.getParameter("txtFecha");
		String codHotel = request.getParameter("txtCodHotel");
		String codEstadia = request.getParameter("txtCodDes");
		String fechaIngreso = request.getParameter("txtFechaIng");
		String fechaSalida = request.getParameter("txtFechaSal");
		String cantidad =request.getParameter("txtCantidad");
		String tipo = request.getParameter("cmbTipo");
		DAOFactory fabrica = DAOFactory.getDaoFactory(1);
		Hotel hotel = fabrica.getHotelDAO().obtenerHotel(codHotel);
		ReservaHabitacion ha = new ReservaHabitacion();
		ha.setNumSoli(fabrica.getReservaHabitacionDAO().obtenerCod());
		ha.setCantidad(Integer.parseInt(cantidad));
		ha.setCodDes(Integer.parseInt(codEstadia));
		ha.setCodHotel(Integer.parseInt(codHotel));
		ha.setFechaIngreso(fechaIngreso);
		ha.setFechaSalida(fechaSalida);
		LocalDate fecha = LocalDate.now();
		ha.setFechaReserva(fecha.toString());
		ha.setTipo(tipo);
		int ok = fabrica.getReservaHabitacionDAO().registrar(ha);
		if (ok == 0) {
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Registro falllido',"
					+ "            text: 'Intente nuevamente'"
					+ "        })</script>";;
					
			request.setAttribute("mensajeError", mensaje);
			request.getRequestDispatcher("reservaHotel.jsp").forward(request, response);
		}else {
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Registro Exitoso',"
					+ "            text: 'Se registro su solicitud, numero es: "+ ha.getNumSoli()+"'"
					+ "        })</script>";;
					
			request.setAttribute("mensajeError", mensaje);
			generarPDF(hotel.getNombre(), ha);
			request.getRequestDispatcher("reservaHotel.jsp").forward(request, response);
		}
	}

	private void generarPDF(String marca,ReservaHabitacion ha) {
		Date fecha1 = new Date();
		// TODO Auto-generated method stub
		String nArchivo = "D:\\Solicitud" + "_"+ha.getNumSoli()+"_"+new SimpleDateFormat("dd-MM-yyyy").format(fecha1)+".pdf";
		try {
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(nArchivo);
			
			PdfWriter pdfWriter = PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			
			
			PdfPTable table = new PdfPTable(2);
			table.setWidths(new int [] {50, 150});
			
			PdfPCell cell1 = new PdfPCell();
			Image img = Image.getInstance("D:\\\\Logo_gris_blanco.png");
			
			cell1.setFixedHeight(80f);
			cell1.addElement(img);
			cell1.setBorderColor(BaseColor.WHITE);
			
			PdfPCell cell2 = new PdfPCell();
			cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			//cell2.setPaddingLeft(60f);
			cell2.setPaddingRight(-25f);
			cell2.setBorderColor(BaseColor.WHITE);
			PdfPTable encaTable = new PdfPTable(1);
			PdfPCell fecha = new PdfPCell(
					new Paragraph("AMAE - AEROLINEA DE SIEMPRE ")
					);
			fecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
			fecha.setBorderColor(BaseColor.WHITE);
			PdfPCell blacCell = new PdfPCell();
			blacCell.setFixedHeight(30f);
			blacCell.setBorderColor(BaseColor.WHITE);
			PdfPCell Dirrecion = new PdfPCell(
					new Paragraph("Miraflores, 1698 - Perú")
					);
			Dirrecion.setHorizontalAlignment(Element.ALIGN_RIGHT);
			Dirrecion.setBorderColor(BaseColor.WHITE);
			PdfPCell fecha2 = new PdfPCell(
					new Paragraph(ha.getFechaReserva())
					);
			fecha2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			fecha2.setBorderColor(BaseColor.WHITE);
			encaTable.addCell(fecha);
			encaTable.addCell(blacCell);
			encaTable.addCell(Dirrecion);
			encaTable.addCell(fecha2);
			cell2.addElement(encaTable);
			
			table.addCell(cell1);
			table.addCell(cell2);
			plantilla.add(table);
			////////////////////////////////CUERPO
			Paragraph blaco = new Paragraph(" ");
			
			plantilla.add(blaco);
			plantilla.add(blaco);
			plantilla.add(blaco);
			plantilla.add(blaco);
			Paragraph p = new Paragraph(
					"Estimado (a) Sr. (a): "
					);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			
			p = new Paragraph("Eduardo Gomez Quinteros");
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			p = new Paragraph("Gerente de Ventas de " + marca);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			plantilla.add(blaco);
			plantilla.add(blaco);
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);
			Destino des = fabrica.getDestinoDAO().buscar(ha.getCodDes());
			p = new Paragraph(
					"Me dirijo a usted respetuosamente con la finalidad de solicitar la reserva"
					+ " de " +ha.getCantidad() + " los detalles son lo siguiente: "  
					);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			plantilla.add(blaco);
			
			p = new Paragraph("Lugar de Estadio: " + des.getCiudadDes() +" - "+ des.getPaisDes(), FontFactory.getFont("FontFamily",12, Font.BOLD));
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			p = new Paragraph("Fecha de Ingreso: " + ha.getFechaIngreso(), FontFactory.getFont("FontFamily",12, Font.BOLD));
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			p = new Paragraph("Fecha de Salida: " + ha.getFechaSalida(), FontFactory.getFont("FontFamily", 12,Font.BOLD));
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			p = new Paragraph("Tipo de Habitación: "  + ha.getTipo(), FontFactory.getFont("FontFamily", 12,Font.BOLD));
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			plantilla.add(blaco);
			
			p = new Paragraph("Por todo lo expuesto, le reitero mi solicitud de autorización, "
					+ "agradeciendo de antemano toda la cooperación que pueda prestar al respecto.");
			//p.setAlignment(15);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			
			plantilla.add(blaco);
			plantilla.add(blaco);
			
			p = new Paragraph("Sin más a qué referirme y "
					+ "en espera de una pronta y favorable respuesta a esta solicitud, me despido.");
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			plantilla.add(blaco);
			plantilla.add(blaco);
			p = new Paragraph("Atentamente, ");
			
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			
			plantilla.add(p);
			p = new Paragraph("Juan Hinostroza Campos");
			
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			
			plantilla.add(p);
			p = new Paragraph("Gerente de Ventas de AMAE");
			
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			
			plantilla.add(p);
			
			
			plantilla.close();
			Desktop.getDesktop().open(new File(nArchivo));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage() );
		}
	}

}
