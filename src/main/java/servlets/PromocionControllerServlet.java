package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.Promocion;
import model.Proveedor;

/**
 * Servlet implementation class ServletPromocion
 */
@WebServlet(name = "promocion", description = "Mantenedor promocion", urlPatterns = { "/promocion" })
public class PromocionControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PromocionControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Entro al Servlet de promocion");

		// la opcion seleccionada
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);

		switch (accion) {

		case "registrar":

			int codpromo = Integer.parseInt(request.getParameter("txtCodigo"));
			String clave = request.getParameter("txtClave");
			String titulo = request.getParameter("txtTitulo");
			String descripcion = request.getParameter("txtDescripcion");
			String fechaV = request.getParameter("fechaValido");
			String fechaC = request.getParameter("fechaCaducidad");
			double descuento = Double.parseDouble(request.getParameter("txtDescuento"));
			int tipoCliente = Integer.parseInt(request.getParameter("cboTipoCliente"));

			Promocion p = new Promocion();

			p.setCod_promocion(codpromo);
			p.setClave_promocion(clave);
			p.setTitulo_promocion(titulo);
			p.setDescripcion(descripcion);
			p.setFechaValida(fechaV);
			p.setFechaCaducidad(fechaC);
			p.setDescuento(descuento);
			p.setTipoCliente(tipoCliente);

			System.out.println(p);

			// GestionProductoMySQL gp = new GestionProductoMySQL();
			// SE LLAMARA CON EL PATRON DAO
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);

			int ok = fabrica.getPromocionDAO().registrar(p);

			// SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje",
						"<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			} else {

				request.setAttribute("mensaje", "<script>swal('Mensaje!','Promoción registrada', 'success');</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			}

			break;

		case "actualizar":

			codpromo = Integer.parseInt(request.getParameter("txtCodigo"));
			clave = request.getParameter("txtClave");
			titulo = request.getParameter("txtTitulo");
			descripcion = request.getParameter("txtDescripcion");
			fechaV = request.getParameter("fechaValido");
			fechaC = request.getParameter("fechaCaducidad");
			descuento = Double.parseDouble(request.getParameter("txtDescuento"));
			tipoCliente = Integer.parseInt(request.getParameter("cboTipoCliente"));
			p = new Promocion();
			p.setCod_promocion(codpromo);
			p.setClave_promocion(clave);
			p.setTitulo_promocion(titulo);
			p.setDescripcion(descripcion);
			p.setFechaValida(fechaV);
			p.setFechaCaducidad(fechaC);
			p.setDescuento(descuento);
			p.setTipoCliente(tipoCliente);

			System.out.println(p);

			// GestionProductoMySQL gp = new GestionProductoMySQL();
			// SE LLAMARA CON EL PATRON DAO
			fabrica = DAOFactory.getDaoFactory(1);

			ok = fabrica.getPromocionDAO().actualizar(p);

			// SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje",
						"<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			} else {

				request.setAttribute("mensaje", "<script>swal('Mensaje!','Promoción actulizada', 'success');</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			}

			break;

case "buscarPromocionInactiva": 
	
	// leer el codigo del producto q viene del listado
				 int codigo = Integer.parseInt( request.getParameter("codigo"));
				// fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL)
				fabrica = DAOFactory.getDaoFactory(1);
				 p = new Promocion();

				p = fabrica.getPromocionDAO().buscar(codigo);
				System.out.println(p);
				// enviar la informacion encontrada a la pagina formulario cliente

				//request.getSession().setAttribute("c", c);
				//response.sendRedirect("FormularioCliente.jsp");
				
				
				request.setAttribute("p", p);
				request.getRequestDispatcher("FormularioPromociónInactiva.jsp").forward(request, response);
				


	break;
		case "eliminar":

			int cod = Integer.parseInt(request.getParameter("txtCodigo"));
			// proceso para eliminar el producto
			p = new Promocion();
			p.setCod_promocion(cod);

			fabrica = DAOFactory.getDaoFactory(1);
			// gp = new GestionProductoMySQL();
			ok = fabrica.getPromocionDAO().eliminar(p);

			// SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje",
						"<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			} else {

				request.setAttribute("mensaje",
						"<script>swal('Mensaje!','Promoción desactivada', 'success');</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			}

			break;
		case "eliminarLista":

			cod = Integer.parseInt(request.getParameter("txtCodigo"));
			// proceso para eliminar el producto
			p = new Promocion();
			p.setCod_promocion(cod);

			fabrica = DAOFactory.getDaoFactory(1);
			// gp = new GestionProductoMySQL();
			ok = fabrica.getPromocionDAO().eliminar(p);

			// SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje",
						"<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			} else {

				request.setAttribute("mensaje",
						"<script>swal('Mensaje!','Promoción desactivada', 'success');</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			}

			break;

		case "actualizarActivar":

			codpromo = Integer.parseInt(request.getParameter("txtCodigo"));
			clave = request.getParameter("txtClave");
			titulo = request.getParameter("txtTitulo");
			descripcion = request.getParameter("txtDescripcion");
			fechaV = request.getParameter("fechaValido");
			fechaC = request.getParameter("fechaCaducidad");
			descuento = Double.parseDouble(request.getParameter("txtDescuento"));
			tipoCliente = Integer.parseInt(request.getParameter("cboTipoCliente"));

			p = new Promocion();
			p.setCod_promocion(codpromo);
			p.setClave_promocion(clave);
			p.setTitulo_promocion(titulo);
			p.setDescripcion(descripcion);
			p.setFechaValida(fechaV);
			p.setFechaCaducidad(fechaC);
			p.setDescuento(descuento);
			p.setTipoCliente(tipoCliente);

			System.out.println(p);

			// GestionProductoMySQL gp = new GestionProductoMySQL();
			// SE LLAMARA CON EL PATRON DAO
			fabrica = DAOFactory.getDaoFactory(1);

			ok = fabrica.getPromocionDAO().activarActualizar(p);

			// SALIDA
			if (ok == 0) {
				request.setAttribute("mensaje",
						"<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			} else {

				request.setAttribute("mensaje", "<script>swal('Mensaje!','Promoción activada', 'success');</script>");
				request.getRequestDispatcher("MantenimientoPromocion.jsp").forward(request, response);
			}

			break;
		case "listarPromocionInactiva":

			fabrica = DAOFactory.getDaoFactory(1);

			ArrayList<Promocion> lstPromocion1 = fabrica.getPromocionDAO().listadoPromocionInactivos();

			request.setAttribute("lstPromocion", lstPromocion1);

			request.getRequestDispatcher("FormularioPromociónInactiva.jsp").forward(request, response);

			break;
		case "listar":

			fabrica = DAOFactory.getDaoFactory(1);

			ArrayList<Promocion> lstPromocion = fabrica.getPromocionDAO().listado();

			request.setAttribute("lstPromocion", lstPromocion);

			request.getRequestDispatcher("FormularioPromoción.jsp").forward(request, response);

			break;
		case "buscar":

			// leer el codigo del producto q viene del listado
			codigo = Integer.parseInt(request.getParameter("codigo"));
			// fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL)
			fabrica = DAOFactory.getDaoFactory(1);
			p = new Promocion();

			p = fabrica.getPromocionDAO().buscar(codigo);
			System.out.println(p);
			// enviar la informacion encontrada a la pagina formulario cliente

			// request.getSession().setAttribute("c", c);
			// response.sendRedirect("FormularioCliente.jsp");

			request.setAttribute("p", p);
			request.getRequestDispatcher("FormularioPromoción.jsp").forward(request, response);

			break;

		default:

			break;

		}

	}

}
