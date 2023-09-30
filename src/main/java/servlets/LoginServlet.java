package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.tipo_usuario;
import model.usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", description = "Entrar al sistema", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ingresar = request.getParameter("btnIngresar");
		
		switch (ingresar) {
		case "loguear": {
			String email = request.getParameter("txtEmail");
			String contra = request.getParameter("txtContra").toString();
			DAOFactory fabrica = DAOFactory.getDaoFactory(1);
			usuario usu = fabrica.getUsuarioDAO().ingresar(email, contra);
			if(usu == null) {
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Usuario no encontrado',"
						+ "            text: 'Usuario y/o contraseña incorrectos'"
						+ "        })</script>";
						
				request.setAttribute("mensajeError", mensaje);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				tipo_usuario tipo = fabrica.getTipoUsuarioDAO().obtenerTipo(usu.getTipo());
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'success',"
						+ "            title: 'Bienvenido " +tipo.getDescripcion()+" '"
						+ "        })</script>";
				request.getSession().setAttribute("usu", usu);
				request.getSession().setAttribute("codTipo", tipo.getIdTipo());
				request.getSession().setAttribute("tipo", tipo.getDescripcion());
				request.setAttribute("mensajeError", mensaje);
				request.getRequestDispatcher("IntranetPrincipal.jsp").forward(request, response);
			}
			
		}
		default:
			
		}
		
	}

}
