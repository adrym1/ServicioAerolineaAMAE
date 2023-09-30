package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.usuario;

/**
 * Servlet implementation class verUsuarioServlet
 */
@WebServlet(name = "verUsuario", urlPatterns = { "/verUsuario" })
public class verUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
		ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
			request.setAttribute("lstUsuario",lstUsuario);
			request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
