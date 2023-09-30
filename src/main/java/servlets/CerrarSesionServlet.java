package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CerrarSesionServlet
 */
@WebServlet(name = "cerrarSesion", description = "Cerrar la sesion del usuario", urlPatterns = { "/cerrarSesion" })
public class CerrarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("usu");
		//Ivalidar la session --> eliminar
		request.getSession().invalidate();
		//redireccionar la pagina
		response.sendRedirect("login.jsp");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("usu");
			System.out.println("Entre al servlet cerrar sesión ....");
			//Ivalidar la session --> eliminar
			request.getSession().invalidate();
			//redireccionar la pagina
			response.sendRedirect("login.jsp");
		}

}
