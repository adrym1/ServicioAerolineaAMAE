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

/**
 * Servlet implementation class verClienteServlet
 */
@WebServlet(name = "verCliente", urlPatterns = { "/verCliente" })
public class verClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			ArrayList<ReporteCliente> listado = fabrica.getReporteClienteDAO().listado();
			request.setAttribute("lstClientes",listado);
			request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);			
	}

}
