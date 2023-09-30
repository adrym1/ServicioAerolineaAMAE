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
 * Servlet implementation class UsuarioControlador
 */
@WebServlet(name = "usuario", urlPatterns = { "/usuario" })
public class UsuarioControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("btnAccion");
		switch (accion) {
		case "reg": 
				String codigo = request.getParameter("txtCodigo");
				String usuario = request.getParameter("txtUsuario");
				String clave = request.getParameter("txtClave");
				String tipo = request.getParameter("cboTipo");
				// proceso grabar el producto
				usuario u = new usuario();
				u.setCodigo(codigo);
				u.setUsuario(usuario);
				u.setClave(clave);
				u.setTipo(Integer.parseInt(tipo));
				System.out.println(u);
				fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				int ok = fabrica.getUsuarioDAO().registrar(u);
				
				//SALIDA
				if (ok == 0) {
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
						request.setAttribute("lstUsuario",lstUsuario);
					request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
					request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
				}else {
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
						request.setAttribute("lstUsuario",lstUsuario);
					request.setAttribute("mensaje","<script>swal('Mensaje!','Usuario Registrado', 'success');</script>");
					request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
				}
				
			break;	
		case "act": 

			 codigo = request.getParameter("txtCodigo");
			 usuario = request.getParameter("txtUsuario");
			 clave = request.getParameter("txtClave");
			 tipo = request.getParameter("cboTipo");

				 u = new usuario();
				u.setCodigo(codigo);
				u.setUsuario(usuario);
				u.setClave(clave);
				u.setTipo(Integer.parseInt(tipo));
				fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ok = fabrica.getUsuarioDAO().actualizar(u);
				
				//SALIDA
				if (ok == 0) {
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
						request.setAttribute("lstUsuario",lstUsuario);
					request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
					request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);				
				}else {
					fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
					ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
						request.setAttribute("lstUsuario",lstUsuario);
					request.setAttribute("mensaje","<script>swal('Mensaje','Usuario Actualizado', 'success');</script>");
					request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
				}
				
				break;			
		case "eli": 
				String cod = request.getParameter("txtCodigo");

				u = new usuario();
				u.setCodigo(cod);
				fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ok = fabrica.getUsuarioDAO().eliminar(u);

				if (ok == 0) {
					String mensaje ="<script>"
							+ "Swal.fire({"
							+ "            icon: 'error',"
							+ "            title: 'Usuario no eliminado',"
							+ "            text: 'Intentalo más tarde, contacte con un administrador si el error persiste contacte con un administrador',"
							+ "            footer: '<a href=\"\">Leer documentación</a>'"
							+ "        })</script>";;
					request.setAttribute("mensaje",mensaje);
					ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
					request.setAttribute("lstUsuario",lstUsuario);
					request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
				}else {
					String mensaje ="<script>"
							+ "Swal.fire({"
							+ "            icon: 'success',"
							+ "            title: 'Usuario Eliminado',"
							+ "            footer: '<a href=\"\">Leer documentación</a>'"
							+ "        })</script>";;
					request.setAttribute("mensaje",mensaje);
					ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
					request.setAttribute("lstUsuario",lstUsuario);
					request.getRequestDispatcher("MantenimientoUsuario.jsp").forward(request, response);
				}
			break;
		case "list": 
			fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
				ArrayList<usuario> lstUsuario = fabrica.getUsuarioDAO().listado();
					request.setAttribute("lstUsuario",lstUsuario);
					request.getRequestDispatcher("listado.jsp").forward(request, response);
			break;
		case "formBuscar":
			 codigo = request.getParameter("codigo");
			 fabrica = DAOFactory.getDaoFactory(DAOFactory.MySQL);
			 u =  fabrica.getUsuarioDAO().buscar(codigo);
			 request.setAttribute("u", u);
			 request.getRequestDispatcher("FormularioUsuario.jsp").forward(request, response);
			break;
		}
	}

}
