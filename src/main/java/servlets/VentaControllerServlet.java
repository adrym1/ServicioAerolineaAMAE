package servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.PrimitiveIterator.OfDouble;
import java.awt.Desktop;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.DAOFactory;
import model.Destino;
import model.Pais;
import model.Persona;
import model.Promocion;
import model.Tarjeta;
import model.VentaCabezera;
import model.VentaDetalle;
import model.Vuelo;

/**
 * Servlet implementation class VentaControllerServlet
 */
@WebServlet(name = "ventaController", description = "Controlador de la venta", urlPatterns = { "/ventaController" })
public class VentaControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Cambiar esto al de vd
		
		
		/*******************************************************************/
		String accion = request.getParameter("btnSiguiente");
		switch (accion) {
		case "vuelos":{
			
			guardarVuelos(response, request);
			
			break;
		}
		case "promocion":{
			validarPromocion(request, response);
			break;
		}
		case "personas":{
			
			ArrayList<Persona> listado = obtenerPersonas(request, response);
			//System.out.println(listado.get(0).toString());
			request.getSession().setAttribute("Personas", listado);

			int tamanio = listado.size();
			Vuelo v1 = (Vuelo) request.getSession().getAttribute("vuelo_1");
			Vuelo v2 = (Vuelo) request.getSession().getAttribute("vuelo_2");
			
			Promocion pr = (Promocion) request.getSession().getAttribute("promo");
			double descuento = 0.0;
			if(pr != null) {
				descuento = pr.getDescuento();
			}
			else {
				descuento = 0.0;
			}
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);
			double precioTo = (v1.getPrecioVuelo() + v2.getPrecioVuelo()) * tamanio;
			double impuesto = 0.18;
			double montoTotal = (precioTo + (precioTo * impuesto) - (precioTo * descuento)) ;
			request.getSession().setAttribute("cantidad", tamanio);
			request.getSession().setAttribute("descuento", descuento);
			System.out.println("Descuento de: " + descuento);
			request.getSession().setAttribute("impuesto", impuesto);
			request.getSession().setAttribute("precioTotal", precioTo);
			request.getSession().setAttribute("montoTotal", montoTotal);
			int codigo = fabrica.getVentaDAO().obtenerCod() + 1;
			request.getSession().setAttribute("codVenta", codigo);
			request.getRequestDispatcher("ventas_03.jsp").forward(request, response);
			break;
		} 
		case "pago_visa":{
			
			int ok = registrarPago(request, response, accion);
			if(ok ==0) {
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Error en el pago',"
						+ "            text: 'Intentalo más tarde, contacte con un administrador si se registro un pago',"
						+ "            footer: '<a href=\"\">Leer documentación</a>'"
						+ "        })</script>";;
						
				request.setAttribute("pagoError", mensaje);
				request.getRequestDispatcher("ventas_03.jsp").forward(request, response);
			}else {
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'success',"
						+ "            title: 'Pago Exitoso',"
						+ "            text: 'Se realizo el pago correctamente'"
						+ "        })</script>";;
						
				request.setAttribute("mensajeError", mensaje);
				request.getRequestDispatcher("ventas_04.jsp").forward(request, response);
			}
			break;
		}
		case "pago_mast":{
			int ok = registrarPago(request, response, accion);
			if(ok == 0) {
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Error en el pago',"
						+ "            text: 'Intentalo más tarde, contacte con un administrador si se registro un pago',"
						+ "            footer: '<a href=\"\">Leer documentación</a>'"
						+ "        })</script>";;
						
				request.setAttribute("pagoError", mensaje);
				
			}else {
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'success',"
						+ "            title: 'Pago Exitoso',"
						+ "            text: 'Se realizo el pago correctamente'"
						+ "        })</script>";;
						
				request.setAttribute("mensajeError", mensaje);
				request.getRequestDispatcher("ventas_04.jsp").forward(request, response);
			}		
			break;
		}
		case "pago_bill":{
			String codigo = request.getParameter("txtCodVenta");
			break;
		}
		case "finalizado":{
			
			
			borrarAtributosVentas(request, response);
			
			break;
		}
		case "pdf":{
			ArrayList<Persona> personas = (ArrayList<Persona>) request.getSession().getAttribute("Personas");
			Vuelo v1 = (Vuelo) request.getSession().getAttribute("vuelo_1");
			Vuelo v2 = (Vuelo) request.getSession().getAttribute("vuelo_2");
			int codigo = (int) request.getSession().getAttribute("codVenta");
			crearPDFVenta(personas, v1, v2, codigo);
			request.getRequestDispatcher("ventas_04.jsp").forward(request, response);
			break;
		}
		
		default:
			break;
		}
	}
	private void crearPDFVenta(ArrayList<Persona> listado, Vuelo v1, Vuelo v2, int codigo) {
		// TODO Auto-generated method stub
		Date fecha1 = new Date();
		String ruta = "D:\\Pasajes_"+new SimpleDateFormat("dd-MM-yyyy").format(fecha1)+".pdf";
		
		try {
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(ruta);
			PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			
			//Creando la cabezera del documento
			PdfPTable cabezera = new PdfPTable(2);
			cabezera.setWidths(new int[] {120, 50});
			
			PdfPCell cabeBlanco = new PdfPCell();
			
			cabeBlanco.setBorderColor(BaseColor.WHITE);
			PdfPCell logoCelda = new PdfPCell();
			Image logo = Image.getInstance("D:\\Logo_gris_blanco.png");
			logoCelda.setPaddingLeft(60f);
			logoCelda.setPaddingRight(-40f);
			logoCelda.setFixedHeight(80f);
			logoCelda.addElement(logo);
			logoCelda.setBorderColor(BaseColor.WHITE);
			
			cabezera.addCell(cabeBlanco);
			cabezera.addCell(logoCelda);
			
			plantilla.add(cabezera);
			
			/*Crear un separador de espacios*/
			Paragraph blaco = new Paragraph(" ");
			
			plantilla.add(blaco);	
			
			Paragraph fecha = new Paragraph(LocalDate.now().toString());
			fecha.setAlignment(Element.ALIGN_RIGHT);
			plantilla.add(fecha);
			
			plantilla.add(blaco);	
			/*Titulo*/
			Paragraph titulo = new Paragraph("INFORMACIÓN DE LOS PASAJES ",FontFactory.getFont("FontFamily", 20, Font.BOLD) );
			titulo.setAlignment(Element.ALIGN_CENTER);
			
			
			plantilla.add(titulo);

			
			plantilla.add(blaco);	
			Paragraph p = new Paragraph(
					"Codigo de reserva es: " + codigo, FontFactory.getFont("FontFamily", 17, Font.BOLD)
					);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			p.setAlignment(Element.ALIGN_CENTER);
			plantilla.add(p);
			
			PdfPTable contVuelo1 = new PdfPTable(1);
			contVuelo1.setWidths(new int[] {200});
			for (Persona per: listado) {
				PdfPCell separador = new PdfPCell(new Paragraph("              "));
				separador.setBorderColor(BaseColor.WHITE);
				contVuelo1.addCell(separador);
				/*Vuelo n1*/
				
				PdfPCell cell1 = new PdfPCell();
				cell1.setPaddingRight(-50f);
				cell1.setPaddingLeft(-50f);
				cell1.setFixedHeight(145f);
				//cell1.setBorderColor(BaseColor.WHITE);
				PdfPCell subpie = new PdfPCell();
				Paragraph notas = new Paragraph("Ticket recortable para su uso individual, de toda manera en aeropueto "
						+ "se le pedira su DNI y codigo de Venta para comprobar su existentcia", FontFactory.getFont("FontFamily", 8));
				
				subpie.addElement(notas);
				
				contVuelo1.addCell(separador);
				contVuelo1.addCell(separador);
				PdfPTable contInfo = new PdfPTable(2);
				contInfo.setWidths(new int[] {190, 190});
				PdfPCell contPersonas = new PdfPCell();
				contPersonas.setFixedHeight(190f);
				contPersonas.setBorderColor(BaseColor.WHITE);
				contPersonas.setPaddingTop(4f);
				PdfPTable persona = new PdfPTable(1);
				persona.setWidthPercentage(100f);
				
				PdfPCell tituPerso = new PdfPCell(new Phrase("Pasajero"));
				tituPerso.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell nombrePerso = new PdfPCell(new Paragraph("Nombre: " +per.getNombre(), FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				nombrePerso.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell apellidoPerso = new PdfPCell(new Paragraph("Apellido: " + per.getApellido(), FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				apellidoPerso.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell dniPerso = new PdfPCell(new Paragraph("DNI: " + per.getDni(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				dniPerso.setHorizontalAlignment(Element.ALIGN_LEFT);
				
				PdfPCell nacionalidad = new PdfPCell(new Paragraph("Nacionalidad: " + per.getNaciona(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				nacionalidad.setHorizontalAlignment(Element.ALIGN_LEFT);
				
				PdfPCell domiciPerso = new PdfPCell(new Paragraph("Domicilio: " + per.getNaciona(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				PdfPCell paisRePerso = new PdfPCell(new Paragraph("Pais Residencia: " + per.getNaciona(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				PdfPCell sexoPerso = new PdfPCell(new Paragraph("Sexo:  " + per.getSexo(), FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				//Codigo de barras
				Image barras = Image.getInstance("D:\\codigoBarras.png");
				
				persona.addCell(tituPerso);
				persona.addCell(nombrePerso.getPhrase());
				persona.addCell(apellidoPerso);
				persona.addCell(dniPerso);
				persona.addCell(nacionalidad);
				persona.addCell(domiciPerso);
				persona.addCell(paisRePerso);
				persona.addCell(sexoPerso);
				persona.addCell(barras);
				contPersonas.addElement(persona);
				
				//**Full Vuelo*/
				PdfPCell contSubVuelo = new PdfPCell();
				contSubVuelo.setFixedHeight(150f);
				contSubVuelo.setBorderColor(BaseColor.WHITE);
				PdfPTable contVuelos = new PdfPTable(1);
				contVuelos.setWidthPercentage(100f);
				PdfPCell vuelo1cell = new PdfPCell();
				vuelo1cell.setFixedHeight(250f);
				vuelo1cell.setBorderColor(BaseColor.WHITE);
				PdfPTable tablaVuelo1 = new PdfPTable(1);
				tablaVuelo1.setWidthPercentage(100f);
				
				
				PdfPCell vuelo1 = new PdfPCell(new Paragraph("Vuelo 1",FontFactory.getFont("arial",10,com.itextpdf.text.Font.BOLD)));
				vuelo1.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell vuelo2 = new PdfPCell(new Paragraph("Vuelo 2",FontFactory.getFont("arial",10,com.itextpdf.text.Font.BOLD)));
				vuelo2.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell codigo1 = new PdfPCell(new Paragraph("Codigo: " + v1.getCodVuelo(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				
				PdfPCell codigo2 = new PdfPCell(new Paragraph("Codigo: " + v2.getCodVuelo(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				
				PdfPCell hora1 = new PdfPCell(new Paragraph("Hora: " + v1.getHoraVuelo(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				
				PdfPCell hora2 = new PdfPCell(new Paragraph("Hora: " + v1.getHoraVuelo(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				DAOFactory fabrica = DAOFactory.getDaoFactory(1);
				Destino des1 = fabrica.getDestinoDAO().buscar(v1.getCodDesLlegada());
				Destino des2 = fabrica.getDestinoDAO().buscar(v2.getCodDesLlegada());
				PdfPCell destino1 = new PdfPCell(new Paragraph("Destino: " + des1.getAeropueDes() + " " + des1.getPaisDes(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				PdfPCell destino2 = new PdfPCell(new Paragraph("Destino: "+ des2.getAeropueDes() + " " + des2.getPaisDes(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				
				PdfPCell fechaSalida1 = new PdfPCell(new Paragraph("Fecha de Salida: " + v1.getFechaSalida(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				PdfPCell fechaSalida2 = new PdfPCell(new Paragraph("Fecha de Salida: " + v2.getFechaSalida(),FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL)));
				
				PdfPCell blanco = new PdfPCell(new Paragraph("              ",FontFactory.getFont("arial",4,com.itextpdf.text.Font.NORMAL)));
				blanco.setBorderColor(BaseColor.WHITE);
				tablaVuelo1.addCell(vuelo1);
				tablaVuelo1.addCell(codigo1);
				tablaVuelo1.addCell(hora1);
				
				tablaVuelo1.addCell(destino1);
				tablaVuelo1.addCell(fechaSalida1);
				tablaVuelo1.addCell(blanco);
				tablaVuelo1.addCell(vuelo2);
				tablaVuelo1.addCell(codigo2);
				
				tablaVuelo1.addCell(hora2);
				
				tablaVuelo1.addCell(destino2);
				tablaVuelo1.addCell(fechaSalida2);
				
				
				vuelo1cell.addElement(tablaVuelo1);
				contVuelos.addCell(vuelo1cell);
				contSubVuelo.addElement(contVuelos);
				
				contInfo.addCell(contPersonas);
				contInfo.addCell(contSubVuelo);
				
				cell1.addElement(contInfo);
				
				
				contVuelo1.addCell(cell1);
				contVuelo1.addCell(subpie);
			}
			
			plantilla.add(blaco);	
			
			
			plantilla.add(contVuelo1);
			
			//Pie de la paginas
			
			p = new Paragraph(
					"NOTAS", FontFactory.getFont("FontFamily", 15, Font.BOLD)
					);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			p = new Paragraph(
					"Este metodo es pago es una reserva, para confirmar su viaje, debera realizarlo un dia antes del vuelo. En caso de olvido, "
					+ "tiene hasta un tiempo de 2 meses para realizar un cambio de fecha despues pasado la fecha se procede a invalidar la compra.",
					FontFactory.getFont("FontFamily", 12, Font.ITALIC, BaseColor.GRAY)
					);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			
			plantilla.close();
			Desktop.getDesktop().open(new File(ruta));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void guardarVuelos(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vuelo1= request.getParameter("txtNumVuelo01");
		String vuelo2= request.getParameter("txtNumVuelo02");
		DAOFactory fabrica = DAOFactory.getDaoFactory(1);
		Vuelo vu1 = fabrica.getVueloDAO().buscar(vuelo1);
		Vuelo vu2 = fabrica.getVueloDAO().buscar(vuelo2);
		Destino des1 = fabrica.getDestinoDAO().buscar(vu1.getCodDesLlegada());
		Destino des2 = fabrica.getDestinoDAO().buscar(vu2.getCodDesLlegada());
		ArrayList<Pais> lstPais = fabrica.getPaisDAO().listado();
		request.getSession().setAttribute("vuelo_1", vu1);
		request.getSession().setAttribute("vuelo_2", vu2);
		request.getSession().setAttribute("des1", des1);
		request.getSession().setAttribute("des2", des2);
		request.getSession().setAttribute("lstPais", lstPais);
		request.getRequestDispatcher("ventas_02.jsp").forward(request, response);
	}

	

	private void borrarAtributosVentas(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("vuelo_1");
		request.getSession().removeAttribute("vuelo_2");
		request.getSession().removeAttribute("Personas");
		request.getSession().removeAttribute("cantidad");
		request.getSession().removeAttribute("montoTotal");
		request.getSession().removeAttribute("promo");
		response.sendRedirect("IntranetPrincipal.jsp");
	}

	private void validarPromocion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String promo = request.getParameter("txtPromo");
		System.out.println("La promoción es: " + promo);
		if(promo.equals("")) {
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Ingrese datos del promocion',"
					+ "            text: 'Ingresar datos, no es obligatorio el ingreso de una promocion'"
					+ "        })</script>";;
					
			request.setAttribute("mensajeError", mensaje);
			request.getRequestDispatcher("ventas_01.jsp").forward(request, response);
		}else {
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);
			Promocion pro = fabrica.getPromocionDAO().obtenerPromo(promo);
			if(pro == null) {
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Promoción no encontrada',"
						+ "            text: 'Estructura de ingreso no valida, intente nuevamente'"
						+ "        })</script>";;
				request.setAttribute("mensajeError", mensaje);
				request.getRequestDispatcher("ventas_01.jsp").forward(request, response);
			}else {
				Date fechaactual = new Date(System.currentTimeMillis());
				String fechaInicio = pro.getFechaCaducidad(); 
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaInicioDate;
				try {
					fechaInicioDate = date.parse(fechaInicio);
					if(fechaInicioDate.after(fechaactual)){
					    System.out.println("Fecha inicio mayor");
					    double porcentaje = pro.getDescuento() * 100;
						String mensaje ="<script>"
								+ "Swal.fire({"
								+ "            icon: 'success',"
								+ "            title: 'Promoción encontrada',"
								+ "            text: 'Promoción con un descuento de "+porcentaje + "%'"
								+ "        })</script>";

						request.setAttribute("mensajeError", mensaje);
						
						int codVenta = fabrica.getVentaDAO().obtenerCod();
						LocalDate today = LocalDate.now();
						
						ArrayList<Vuelo> listado = (ArrayList<Vuelo>) fabrica.getVueloDAO().listadoVuelo();
						ArrayList<Destino> lstDestinos = (ArrayList<Destino>) fabrica.getDestinoDAO().listarDestinos();
						request.getSession().setAttribute("codVenta", codVenta);
						request.getSession().setAttribute("fechaHoy", today.toString());
						request.setAttribute("listado", listado);
						request.setAttribute("lstDestinos", lstDestinos);
						request.getSession().setAttribute("promo", pro);
						request.getSession().setAttribute("descuento", pro.getDescuento());
						request.getRequestDispatcher("ventas_01.jsp").forward(request, response);
					}else{
					    System.out.println("Fecha actual mayor");
					    String mensaje ="<script>"
								+ "Swal.fire({"
								+ "            icon: 'error',"
								+ "            title: 'Promoción caducada',"
								+ "            text: 'Codigo de promoción no valida, contacta con la empresa'"
								+ "        })</script>";;
							
								int codVenta = fabrica.getVentaDAO().obtenerCod();
								LocalDate today = LocalDate.now();
								
								ArrayList<Vuelo> listado = (ArrayList<Vuelo>) fabrica.getVueloDAO().listadoVuelo();
								ArrayList<Destino> lstDestinos = (ArrayList<Destino>) fabrica.getDestinoDAO().listarDestinos();
								request.getSession().setAttribute("codVenta", codVenta);
								request.getSession().setAttribute("fechaHoy", today.toString());
								request.setAttribute("listado", listado);
								request.setAttribute("lstDestinos", lstDestinos);
						request.setAttribute("mensajeError", mensaje);
						request.getRequestDispatcher("ventas_01.jsp").forward(request, response);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  //String a date

		}
		
		
		}
		
	}

	private ArrayList<Persona> obtenerPersonas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] nombre = request.getParameterValues("txtNombre");
		
		String[] apellido = request.getParameterValues("txtApellido");
		String[] dni = request.getParameterValues("txtDNI");
		String[] sexo = request.getParameterValues("cmbSexo");
		String[] nacio = request.getParameterValues("txtNacionalidad");
		String[] edad = request.getParameterValues("txtEdad");
		String[] domici = request.getParameterValues("txtDomicilio");
		String[] estado = request.getParameterValues("txtEstado");
		String[] codigoPost = request.getParameterValues("txtCodigoPos");
		String[] pais = request.getParameterValues("cmbPais");
		
		/*
		System.out.println("tamaño de nombre: " + nombre.length);
		System.out.println("tamaño de apellido: " + apellido.length);
		System.out.println("tamaño de dni: " + dni.length);
		System.out.println("tamaño de nacio: " + nacio.length);
		System.out.println("tamaño de edad: " + edad.length);
		System.out.println("tamaño de domicilio: " + domici.length);
		System.out.println("tamaño de estado: " + estado.length);
		System.out.println("tamaño de postal: " + codigoPost.length);
		System.out.println("tamaño de paius: " + pais.length);*/
		ArrayList<Persona> listado = new ArrayList<>();
		Persona per;
		System.out.println("Pais: " + pais.length);
		//System.out.println("Cantidad de persona: "+(nombre.length));
		for (int i = 0; i < nombre.length ; i++) {
			
			try {
				/*System.out.println("---------------------Persona" + i );
				System.out.println("Nombre: " + nombre[i]);
				System.out.println("Apellido: " + apellido[i]);
				//System.out.println("Persona: " + nombre[i]);
				*/
				per = new Persona();
				per.setCodPersona(i);
				per.setNombre(nombre[i]);
				System.out.println("Nombre: " + i + " es: " + nombre[i]);
				per.setApellido(apellido[i]);
				per.setDni(dni[i]);
				per.setEdad(Integer.parseInt(edad[i]));
				per.setSexo(sexo[i]);
				per.setDomici(domici[i]);
				per.setNaciona(nacio[i]);
				per.setCodiPostal(Integer.parseInt(codigoPost[i]));
				per.setEstado(estado[i]);
				per.setPais(Integer.parseInt(pais[i]));
				System.out.println(per.toString());
				
				listado.add(per);
				//System.out.println(listado.get(i).toString());
								
			} catch (NumberFormatException e) {
				// TODO: handle exception
				String error = "<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Error en tipeo',"
						+ "            text: 'Tipos de numeros no coincididos',"
						+ "            footer: '<a href=\"\">Leer documentación</a>'"
						+ "        })</script>";
				request.setAttribute("mensajeError",error);

				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.out.println(e.getMessage());
			}
			
		}
		return listado;
	}

	private int registrarPago(HttpServletRequest request, HttpServletResponse response, String tipoPago) throws ServletException, IOException {
		
		String pago = tipoPago;
		int ok = 0;
		
		//-------------------Datos generales
		Vuelo v1 = (Vuelo) request.getSession().getAttribute("vuelo_1");
		Vuelo v2 = (Vuelo) request.getSession().getAttribute("vuelo_2");
		ArrayList<Persona> listado = (ArrayList)request.getSession().getAttribute("Personas");
		VentaCabezera cabezera = null;
		Tarjeta ta = new Tarjeta();
		//Falta poner lo de pormociones
		try {
			switch (pago) {
			case "pago_visa":{
				String numTarjeta = request.getParameter("txtNumero_visa");
				System.out.println("Numero tarjeta: " + numTarjeta);
				String tipo = request.getParameter("cmbTipoTarje_visa");
				//System.out.println("Tipo: " + tipo);
				String cvv = request.getParameter("txtCVV_visa");
				//System.out.println("CVV: " + cvv);
				String autor = request.getParameter("txtAutor_visa");
				String dni = request.getParameter("txtDni_visa");
				DAOFactory fabrica = DAOFactory.getDaoFactory(1);
				//-----------------Tarjeta
				int codigo = fabrica.getTarjetaDAO().obtenerCod() ;
				ta.setCodTarjeta(codigo);
				ta.setCvv(cvv);
				ta.setDni(dni);
				ta.setNumero(numTarjeta);
				ta.setMarca("Visa");
				ta.setTutor(autor);
				ta.setTipo(tipo);
				for (int i = 0; i < listado.size(); i++) {
					
					listado.get(i).setCodPersona(fabrica.getPersonaDAO().obtenerCod() + (i+1));
					//System.out.println("Codigo 1: " + listado.get(i).getCodPersona());
				}
				//----------------Cabezera
				cabezera = new VentaCabezera();
				int codi = fabrica.getVentaDAO().obtenerCod() + 1;
				cabezera.setCodVenta(codi);
				request.getSession().setAttribute("codVenta", codi);
				cabezera.setCanti((int)request.getSession().getAttribute("cantidad"));
				Promocion pr = (Promocion) request.getSession().getAttribute("promo");
				if(pr == null) {
					cabezera.setClave("ZZZZ-9999");
				}
				else {
					cabezera.setClave(pr.getClave_promocion());
				}
				cabezera.setCodTarjeta(codigo);
				LocalDate today = LocalDate.now();
				cabezera.setFecha(today.toString());
				cabezera.setPrecioTotal((double)request.getSession().getAttribute("montoTotal"));
				cabezera.setTipo("null");
			
				ok = fabrica.getVentaDAO().realizarVenta(cabezera, listado, ta, v1, v2);
				request.setAttribute("boleta", cabezera);
				request.setAttribute("detalle", listado);
				return ok;
			}
				case "pago_mast":{
					String numTarjeta = request.getParameter("txtNumero_mast");
					//System.out.println("Numero tarjeta: " + numTarjeta);
					String tipo = request.getParameter("cmbTipoTarje_mast");
					//System.out.println("Tipo: " + tipo);
					String cvv = request.getParameter("txtCVV_mast");
					//System.out.println("CVV: " + cvv);
					String autor = request.getParameter("txtAutor_mast");
					String dni = request.getParameter("txtDni_mast");
					DAOFactory fabrica = DAOFactory.getDaoFactory(1);
					//-----------------Tarjeta
					int codigo = fabrica.getTarjetaDAO().obtenerCod();
					ta.setCodTarjeta(codigo);
					ta.setCvv(cvv);
					ta.setDni(dni);
					ta.setNumero(numTarjeta);
					ta.setMarca("Mastercard");
					ta.setTutor(autor);
					ta.setTipo(tipo);
					//Poner el codigo
					for (int i = 0; i < listado.size(); i++) {
						listado.get(i).setCodPersona(fabrica.getPersonaDAO().obtenerCod() + (i+1));
						//System.out.println("Codigo 1: " + listado.get(i).getCodPersona());
					}
					//----------------Cabezera
					
					cabezera = new VentaCabezera();
					int codi = fabrica.getVentaDAO().obtenerCod() + 1;
					cabezera.setCodVenta(codi);
					cabezera.setCanti((int)request.getSession().getAttribute("cantidad"));
					Promocion pr = (Promocion) request.getSession().getAttribute("promo");
					if(pr == null) {
						cabezera.setClave("ZZZZ-9999");
					}
					else {
						cabezera.setClave(pr.getClave_promocion());
					}
					cabezera.setCodTarjeta(codigo);
					LocalDate today = LocalDate.now();
					cabezera.setFecha(today.toString());
					cabezera.setPrecioTotal((double)request.getSession().getAttribute("montoTotal"));
					cabezera.setTipo("null");
				
					ok = fabrica.getVentaDAO().realizarVenta(cabezera, listado, ta, v1, v2);
					request.getSession().setAttribute("boleta", cabezera);
					request.getSession().setAttribute("detalle", listado);
					return ok;
				}
				} 
			
			}
		 catch (NumberFormatException e) {
			// TODO: handle exception
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Datos incorrectos',"
					+ "            text: 'Ponga datos correctos',"
					+ "            footer: '<a href=\"\">Leer documentación</a>'"
					+ "        })</script>";;
					
			request.setAttribute("pagoError", mensaje);
			request.getRequestDispatcher("ventas_03.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error inesperado',"
					+ "            text: 'Error: "+e.getMessage()+"',"
					+ "            footer: '<a href=\"\">Leer documentación</a>'"
					+ "        })</script>";;
					
			request.setAttribute("pagoError", mensaje);
			request.getRequestDispatcher("ventas_03.jsp").forward(request, response);
		}
		

		return ok;
	}
	
}
