package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Persona;

/**
 * Servlet implementation class PersonaControllerServlet
 */
@WebServlet(name = "personaController", description = "Controlador de Persona para Venta", urlPatterns = { "/personaController" })
public class PersonaControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		String[] nombre = request.getParameterValues("txtNombre");
		String[] apellido = request.getParameterValues("txtApellido");
		String[] dni = request.getParameterValues("txtDNI");
		String[] sexo = request.getParameterValues("cmbSexo");
		String[] nacio = request.getParameterValues("txtNacionalidad");
		String[] edad = request.getParameterValues("txtEdad");
		String[] domici = request.getParameterValues("txtDomicilio");
		String[] estado = request.getParameterValues("txtEstado");
		String[] codigoPost = request.getParameterValues("txtCodigoPos");
		String[] pais = request.getParameterValues("txtPais");
		
		ArrayList<Persona> listado = new ArrayList<>();
		Persona per;
		for (int i = 0; i < nombre.length; i++) {
			try {
				per = new Persona();
				
				per.setNombre(nombre[i]);
				per.setApellido(apellido[i]);
				per.setDni(dni[i]);
				per.setEdad(Integer.parseInt(edad[i]));
				per.setSexo(sexo[i]);
				per.setDomici(domici[i]);
				per.setNaciona(nacio[i]);
				per.setCodiPostal(Integer.parseInt(codigoPost[i]));
				per.setEstado(estado[i]);
				per.setPais(pais[i]);
				listado.add(per);
				System.out.println(listado.get(i).toString());
				request.getSession().setAttribute("Personas", listado);
				request.getRequestDispatcher("ventas_03.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				String error = "<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Error en tipeo',"
						+ "            text: 'Tipos de numeros no coincididos',"
						+ "            footer: '<a href=\"\">Leer documentación</a>'"
						+ "        })</script>";
				request.setAttribute("mensajeError",error);
				System.out.println(e);
				request.getRequestDispatcher("ventas_02.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
		*/
	}

}
