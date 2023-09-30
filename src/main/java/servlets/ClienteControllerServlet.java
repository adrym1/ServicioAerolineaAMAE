package servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.DAOFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Desktop;
import com.itextpdf.text.Image;
import java.awt.Font;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ReporteCliente;

/**
 * Servlet implementation class ClienteControlador
 */
@WebServlet(name = "cliente", urlPatterns = { "/cliente" })
public class ClienteControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		switch (accion) {
		case "buscarCliente": 
			String nomb = request.getParameter("txtNombre");		
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteCliente> bus = fabrica.getReporteClienteDAO().buscar(nomb);
			 request.setAttribute("lstClientes",bus);
			 request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);
			break;
		case "buscarFecha":
			String fecha1 = request.getParameter("Fecha1");
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteCliente> list = fabrica.getReporteClienteDAO().listarClienteXFecha(fecha1);
			 request.setAttribute("lstClientes",list);
			 request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);
			break;
		case "pdf":
			String Archivo = "D:\\ReporteCliente.pdf";
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
				plantilla.add(img);*/
				//fecha
				Paragraph fecha = new Paragraph();
				fecha.setAlignment(Chunk.ALIGN_RIGHT);
				Date date = new Date();
				fecha.add("Fecha: "+ new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
				plantilla.add(fecha);
				//agregar titulo
				Paragraph p = new Paragraph("AMAE AERLINES ",FontFactory.getFont("FontFamily",22,Font.BOLD,BaseColor.GRAY));
				p.setAlignment(Element.ALIGN_JUSTIFIED);
				plantilla.add(p);
				//agregar Subtitulo
				Paragraph p1 = new Paragraph("Reporte de Clientes ",FontFactory.getFont("FontFamily",12,Font.BOLD,BaseColor.DARK_GRAY));
				p1.setAlignment(Element.ALIGN_JUSTIFIED);
				plantilla.add(p1);
				/*
				//pie de pagina
				Image pie1 = Image.getInstance("D:\\ARIEL\\CIBERTEC 4 CICLO\\LENGUAJE DE PROGRAMACION II\\ECLIPSE\\Proyecto\\Proyecto\\src\\main\\webapp\\img\\ig.jpg");
				pie1.scaleToFit(90,90);
				pie1.setAlignment(Chunk.ALIGN_CENTER);
				*/
				//pie2
				Paragraph pie2 = new Paragraph("Derechos Reservados, Lima - Peú 2022 ",FontFactory.getFont("FontFamily",12,Font.BOLD,BaseColor.DARK_GRAY));
				pie2.setAlignment(Element.ALIGN_CENTER);
				//separador2
				Paragraph ca1 = new Paragraph("      ",FontFactory.getFont("FontFamily",145));
				ca1.setAlignment(Element.ALIGN_CENTER);
				//separador
				Paragraph ca = new Paragraph("      ",FontFactory.getFont("FontFamily",22));
				ca.setAlignment(Element.ALIGN_JUSTIFIED);
				plantilla.add(ca);				
					//crear tabla
					PdfPTable tabla = new PdfPTable(5);
					tabla.setWidthPercentage(110);
					tabla.getDefaultCell().setBorder(0);
					float[] ColumnaProd = new float[] {15f, 30f, 30f,20f, 20f};
					tabla.setWidths(ColumnaProd);
					PdfPCell cli1 = new PdfPCell(new Phrase("Codigo"));
					PdfPCell cli2 = new PdfPCell(new Phrase("Nombre"));
					PdfPCell cli3 = new PdfPCell(new Phrase("Correo"));
					PdfPCell cli4 = new PdfPCell(new Phrase("Tipo"));
					PdfPCell cli5 = new PdfPCell(new Phrase("Fecha de asociacion"));
					
					cli1.setBorder(0);
					cli2.setBorder(0);
					cli3.setBorder(0);
					cli4.setBorder(0);
					cli5.setBorder(0);
					
					cli1.setBackgroundColor(BaseColor.GREEN);
					cli2.setBackgroundColor(BaseColor.GREEN);
					cli3.setBackgroundColor(BaseColor.GREEN);
					cli4.setBackgroundColor(BaseColor.GREEN);
					cli5.setBackgroundColor(BaseColor.GREEN);
					
					tabla.addCell(cli1);
					tabla.addCell(cli2);
					tabla.addCell(cli3);
					tabla.addCell(cli4);
					tabla.addCell(cli5);
					
					//RECORRIDO
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<ReporteCliente> lstClientes = fabrica.getReporteClienteDAO().listado();

					 request.setAttribute("lstClientes",lstClientes);
					 request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);
					for(ReporteCliente c : lstClientes) {
						tabla.addCell(c.getCodCli() + " ");
						tabla.addCell(c.getNombCli());
						tabla.addCell(c.getCorreoCli());						
						tabla.addCell(c.getTipoClie());
						tabla.addCell(c.getFechaAso());
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
		case "registrar":
		     
			String codigo = request.getParameter("txtCodigo");
			String nombCli = request.getParameter("txtNombre");
			String apeCli = request.getParameter("txtApellido");
			String correoCli = request.getParameter("txtCorreo");
			String nacionalCli = request.getParameter("txtNacionalidad");
			int paisCli = Integer.parseInt(request.getParameter("cboPais"));
			String direCli = request.getParameter("txtDireccion");
			String codPostalCli = request.getParameter("txtCodigoPostal");
			int telefCli = Integer.parseInt(request.getParameter("txtNumero"));
			int tipoDoCli = Integer.parseInt(request.getParameter("cboTipoDoc"));
			String numDocCli =  request.getParameter("txtNumDoc");
			int sexoCli = Integer.parseInt(request.getParameter("cboGenero"));
			int tipoClie = Integer.parseInt(request.getParameter("cboTipoCliente"));	
			String fechaAso = request.getParameter("txtFecha");

			// proceso grabar el producto
			Cliente c = new Cliente();
			
			c.setCodCli(codigo);
			c.setNombCli(nombCli);
		    c.setApeCli(apeCli);
		    c.setCorreoCli(correoCli);
		    c.setNacionalCli(nacionalCli);
		    c.setPaisCli(paisCli);
		    c.setDireCli(direCli);
		    c.setCodPostalCli(codPostalCli);
		    c.setTelefCli(telefCli);
		    c.setTipoClie(tipoClie);
		    c.setNumDocCli(numDocCli);
		    c.setSexoCli(sexoCli);
		    c.setTipoClie(tipoClie);
		    c.setFechaAso(fechaAso);
		    c.setTipoDocCli(tipoDoCli);


			System.out.println(c);

			// GestionProductoMySQL gp = new GestionProductoMySQL();
			// SE LLAMARA CON EL PATRON DAO
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);

			int ok = fabrica.getClienteDAO().registrar(c);
			//SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("FormularioCliente.jsp").forward(request, response);
			}else {
				
				request.setAttribute("mensaje","<script>swal('Mensaje!','Cliente Registrado', 'success');</script>");
				request.getRequestDispatcher("MantenimientoCliente.jsp").forward(request, response);
			}
			

		

			break;

		case "listar":

			fabrica = DAOFactory.getDaoFactory(1);

			ArrayList<Cliente> lstCliente = fabrica.getClienteDAO().listado();
			request.setAttribute("lstCliente", lstCliente);
			
			request.getRequestDispatcher("FormularioCliente.jsp").forward(request, response);
			
			
			
		
	
			//redireccionar
		

			break;

		case "buscar":

			// leer el codigo del producto q viene del listado
			codigo = request.getParameter("codigo");
			// fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL)
			fabrica = DAOFactory.getDaoFactory(1);
			 c = new Cliente();

			c = fabrica.getClienteDAO().buscar(codigo);
			System.out.println(c);
			// enviar la informacion encontrada a la pagina formulario cliente

			//request.getSession().setAttribute("c", c);
			//response.sendRedirect("FormularioCliente.jsp");
			
			
			request.setAttribute("c", c);
			request.getRequestDispatcher("FormularioCliente.jsp").forward(request, response);
			
			
			
		
		
           
			/*
			 * request.setAttribute("c", c);
			 * request.getRequestDispatcher("ForumlarioCliente.jsp").forward(request,
			 * response);
			 */
			break;
    
		case "eliminar":

			String cod = request.getParameter("txtCodigo");
			// proceso para eliminar el producto
			 c = new Cliente();
		   c.setCodCli(cod);
			
			 fabrica = DAOFactory.getDaoFactory(1);
			//gp = new GestionProductoMySQL();
			 ok = fabrica.getClienteDAO().eliminar(c);
			
			//SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("FormularioCliente.jsp").forward(request, response);
			}else {
				
				request.setAttribute("mensaje","<script>swal('Mensaje!','Cliente Eliminado', 'success');</script>");
				request.getRequestDispatcher("FormularioCliente.jsp").forward(request, response);
			}
			
			

	
	
			break;
			
		case "eliminarLista":

			 cod = request.getParameter("codigo");
			// proceso para eliminar el producto
			 c = new Cliente();
		   c.setCodCli(cod);
			
		   fabrica = DAOFactory.getDaoFactory(1);
			//gp = new GestionProductoMySQL();
			 ok = fabrica.getClienteDAO().eliminar(c);
			
			//SALIDA
				if (ok == 0) {
					//request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
					request.getRequestDispatcher("MantenimientoCliente.jsp").forward(request, response);
				}else {
					
					//request.setAttribute("mensaje","<script>swal('Mensaje!','Cliente Actualizado', 'success');</script>");
					request.getRequestDispatcher("MantenimientoCliente.jsp").forward(request, response);
				}
				
			

	
	
			break;
		case "activar":

			 cod = request.getParameter("codigo");
			// proceso para eliminar el producto
			 c = new Cliente();
		   c.setCodCli(cod);
			
			 fabrica = DAOFactory.getDaoFactory(1);
			//gp = new GestionProductoMySQL();
			 ok = fabrica.getClienteDAO().activar(c);
			
			//SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("FormularioCliente.jsp").forward(request, response);
			}else {
				
				request.setAttribute("mensaje","<script>swal('Mensaje!','Cliente Activado', 'success');</script>");
				request.getRequestDispatcher("MantenimientoCliente.jsp").forward(request, response);
			}
			
			

	
	
			break;
		case "actualizar":

			 codigo = request.getParameter("txtCodigo");
			 nombCli = request.getParameter("txtNombre");
			 apeCli = request.getParameter("txtApellido");
			 correoCli = request.getParameter("txtCorreo");
			 nacionalCli = request.getParameter("txtNacionalidad");
			 paisCli = Integer.parseInt(request.getParameter("cboPais"));
			 direCli = request.getParameter("txtDireccion");
			 codPostalCli = request.getParameter("txtCodigoPostal");
			 telefCli = Integer.parseInt(request.getParameter("txtNumero"));
			 tipoDoCli = Integer.parseInt(request.getParameter("cboTipoDoc"));
			 numDocCli = request.getParameter("txtNumDoc");
			 sexoCli = Integer.parseInt(request.getParameter("cboGenero"));
			 tipoClie = Integer.parseInt(request.getParameter("cboTipoCliente"));	
			 fechaAso = request.getParameter("txtFecha");

            c = new Cliente();
			
	       c.setCodCli(codigo);
			c.setNombCli(nombCli);
		    c.setApeCli(apeCli);
		    c.setCorreoCli(correoCli);
		    c.setNacionalCli(nacionalCli);
		    c.setPaisCli(paisCli);
		    c.setDireCli(direCli);
		    c.setCodPostalCli(codPostalCli);
		    c.setTelefCli(telefCli);
		    c.setTipoClie(tipoClie);
		    c.setNumDocCli(numDocCli);
		    c.setSexoCli(sexoCli);
		    c.setTipoClie(tipoClie);
		    c.setFechaAso(fechaAso);
		    c.setTipoDocCli(tipoDoCli);


			System.out.println(c);
			
			
			fabrica = DAOFactory.getDaoFactory(1);
			 
			int ok1 = fabrica.getClienteDAO().actualizar(c);
			
			//SALIDA
			if (ok1 == 0) {
				request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("FormularioCliente.jsp").forward(request, response);
			}else {
				
				request.setAttribute("mensaje","<script>swal('Mensaje!','Cliente Actualizado', 'success');</script>");
				request.getRequestDispatcher("MantenimientoCliente.jsp").forward(request, response);
			}
			


				
						
			break;
		default:
	}
		
	}
}
