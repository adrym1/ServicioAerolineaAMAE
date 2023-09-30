package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.Destino;
import model.Hotel;
import model.ReporteCliente;
import model.ReporteDestino;
import model.ReporteVuelo;
import model.Vuelo;
import model.usuario;

/**
 * Servlet implementation class RedireccionarSerlvet
 */
@WebServlet(name = "obtenerEnlace", description = "Redireccionar a un enlace", urlPatterns = { "/obtenerEnlace" })
public class RedireccionarSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedireccionarSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String link = request.getParameter("btnLink");
		System.out.println("Link es: " + link);
		switch (link) {
		case "ManVuelos":{
			response.sendRedirect("MantenimientoVuelo.jsp");
			break;
		}
		case "ManPromo":{
			response.sendRedirect("MantenimientoPromocion.jsp");
			break;
		}
		case "ManCliente":{
			
			response.sendRedirect("MantenimientoCliente.jsp");
			break;
		}
		case "ManUsuario":{
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
			request.setAttribute("lstUsuario",lstUsuario);
			request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
			break;
		}
		case "ManProvee":{
			response.sendRedirect("MantenimientoProveedor.jsp");
			break;
		}
		case "RepVuelos":{
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteVuelo> lstVuelos = fabrica.getReporteVueloDAO().listado();
			request.setAttribute("lstVuelos",lstVuelos);		
			request.getRequestDispatcher("reporteVuelo.jsp").forward(request, response);
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
			break;
		}
		case "RepCliente":{
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteCliente> listado = fabrica.getReporteClienteDAO().listado();
			request.setAttribute("lstClientes",listado);
			request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);		
			break;
		}
		case "RepDestino":{
			DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteDestino> lstDestinos = fabrica.getReporteDestinoDAO().listado();
			request.setAttribute("lstDestinos",lstDestinos);
			request.getRequestDispatcher("reporteDestinos.jsp").forward(request, response);
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
			break;
		}
		case "CompraInsu":{
			
			break;
		}
		case "Reserva":{
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);
			ArrayList<Hotel> lstHoteles = fabrica.getHotelDAO().listadoHotelDisponibles();
			ArrayList<Destino> lstDestinos = (ArrayList<Destino>) fabrica.getDestinoDAO().listarDestinos();
			String codSol = fabrica.getReservaHabitacionDAO().obtenerCod();
			LocalDate fecha = LocalDate.now();
			request.setAttribute("codSol", codSol);
			request.setAttribute("fechaActual".toString(), fecha);
			request.setAttribute("lstDestinos", lstDestinos);
			request.getSession().setAttribute("lstHoteles", lstHoteles);
			request.getRequestDispatcher("reservaHotel.jsp").forward(request, response);
			break;
		}
		case "Pasajes":{
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);
			int codVenta = fabrica.getVentaDAO().obtenerCod();
			LocalDate today = LocalDate.now();
			
			ArrayList<Vuelo> listado = (ArrayList<Vuelo>) fabrica.getVueloDAO().listadoVueloActivos();
			ArrayList<Destino> lstDestinos = (ArrayList<Destino>) fabrica.getDestinoDAO().listarDestinos();
			request.getSession().setAttribute("codVenta", codVenta);
			request.getSession().setAttribute("fechaHoy", today.toString());
			request.setAttribute("listado", listado);
			request.setAttribute("lstDestinos", lstDestinos);
			request.getRequestDispatcher("ventas_01.jsp").forward(request, response);
			break;
		}
		case "check-in":{
			response.sendRedirect("check-in.jsp");
			break;
		}
		
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
