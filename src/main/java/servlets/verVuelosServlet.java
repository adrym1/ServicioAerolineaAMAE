package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.ReporteVuelo;

/**
 * Servlet implementation class verVuelosServlet
 */
@WebServlet(name = "verVuelos", urlPatterns = { "/verVuelos" })
public class verVuelosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verVuelosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
		ArrayList<ReporteVuelo> lstVuelos = fabrica.getReporteVueloDAO().listado();
		request.setAttribute("lstVuelos",lstVuelos);		
		request.getRequestDispatcher("reporteVuelo.jsp").forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
