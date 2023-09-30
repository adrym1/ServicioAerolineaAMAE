package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.ReporteCliente;
import model.ReporteDestino;
import model.ReporteVuelo;
import model.usuario;
/**
 * Servlet implementation class principalServlet
 */
@WebServlet(name = "principal", description = "controlador de producto", urlPatterns = { "/principal" })
public class ReportesControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportesControladorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		// segun la accion seleccionada, ralizar.....
		switch (accion) {		
		case"listaCliente":			
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteCliente> lstClientes = fabrica.getReporteClienteDAO().listado();
			request.setAttribute("lstClientes",lstClientes);
			request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);
			break;
		case"listaDestino":
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteDestino> lstDestinos = fabrica.getReporteDestinoDAO().listado();
			request.setAttribute("lstDestinos",lstDestinos);
			request.getRequestDispatcher("reporteDestinos.jsp").forward(request, response);
			break;
		case"listaVuelo":
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteVuelo> lstVuelos = fabrica.getReporteVueloDAO().listado();
			request.setAttribute("lstVuelos",lstVuelos);		
			request.getRequestDispatcher("reporteVuelo.jsp").forward(request, response);
			break;
		case"usuario":
				fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
					request.setAttribute("lstUsuario",lstUsuario);
					request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
			break;
		default:
		}

	}

}
