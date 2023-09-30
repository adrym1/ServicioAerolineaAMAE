package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name = "checkIn", description = "control del formulario de ingreso", urlPatterns = { "/checkIn" })
public class CheckInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Activo Check-In: ");
		
		// leer la informacion ingresada aen la pagina
		String accion = request.getParameter("btnAccion");
		String codigo = request.getParameter("txtOrden");
		String fecha = request.getParameter("txtFechaVenta");
		String dni = request.getParameter("txtDNI");
		switch (accion) {
		case "check": {
			try {
				DAOFactory fabrica  = DAOFactory.getDaoFactory(1);
				int ok = fabrica.getVentaDAO().realizarCheckIn(Integer.parseInt(codigo), fecha, dni);
				if(ok == 0) {
					String mensaje ="<script>"
							+ "Swal.fire({"
							+ "            icon: 'error',"
							+ "            title: 'Error en el Check-in',"
							+ "            text: 'Error en al momento de reservar, recuerde que lo puede realizar presencialmente'"
							+ "        })</script>";
							
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("check-in.jsp").forward(request, response);
				}else {
					
					String mensaje ="<script>"
							+ "Swal.fire({"
							+ "            icon: 'success',"
							+ "            title: 'Check-in realizado',"
							+ "            text: 'Recuerda asistir 2 horas antes'"
							+ "        })</script>";
							
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("check-in.jsp").forward(request, response);
				}
				
				
			} catch (NullPointerException e) {
				// TODO: handle exception
				String mensaje ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Error en el registro',"
						+ "            text: 'Ingrese datos para realizar el check-in'"
						+ "        })</script>";
						
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("check-in.jsp").forward(request, response);
			}
			break;
		}
		default:
			
			break;
		}
	
	}

}
