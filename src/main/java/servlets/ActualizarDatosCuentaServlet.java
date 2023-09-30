package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DAOFactory;
import model.usuario;

/**
 * Servlet implementation class ActualizarDatosCuentaServlet
 */
@WebServlet(name = "actUsuario", urlPatterns = { "/actUsuario" })
public class ActualizarDatosCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ruta = "C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\Proyecto_LP2\\src\\main\\webapp\\perfiles\\";
	private File subida = new File(ruta);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarDatosCuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("btnActualizar");
		
		switch (accion) {
		case "perfil":{
			usuario usu = (usuario) request.getSession().getAttribute("usu");
			actualizarFotoPerfil(request, response,usu);
			break;
		}
		case "usuario":{
			//Funciona
			usuario usu = (usuario) request.getSession().getAttribute("usu");
			String email = request.getParameter("txtEmailAct");
			String contra = request.getParameter("txtContraAct");
			actualizarCuenta(request, response,usu, email, contra);
		}
		default:
			break;
		}
	}
	private void actualizarCuenta(HttpServletRequest request, HttpServletResponse response, usuario usu, String email, String contra) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory fabrica = DAOFactory.getDaoFactory(1);
		
		int res = fabrica.getUsuarioDAO().actualizarCuenta(usu.getCodigo(), email, contra);
		if (res == 0) {
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error en el actualizar',"
					+ "            text: 'Error en el registro de datos',"
					+ "            footer: '<a href=\"\">Leer documentación</a>'"
					+ "        })</script>";;
					
			request.setAttribute("mensajeError", mensaje);
			request.getRequestDispatcher("confiCuenta.jsp").forward(request, response);
		}else {
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Actualización completada',"
					+ "            text: 'Usuario: "+email+" y Contraseña: "+contra+"',"
					+ "            footer: '<a href=\"\">Leer documentación</a>'"
					+ "        })</script>";
			usuario us = fabrica.getUsuarioDAO().ingresar(email, contra);
			request.getSession().setAttribute("usu", us);
			request.setAttribute("mensajeError", mensaje);
			request.setAttribute("email", email);
			request.setAttribute("pass", contra);
			request.getRequestDispatcher("confiCuenta.jsp").forward(request, response);
		}
		
	}

	private void actualizarFotoPerfil(HttpServletRequest request, HttpServletResponse response, usuario usu) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Part fileFoto = request.getPart("fileFoto");
		String fullPath = guardarFotoPerfil(fileFoto, subida, usu.getCodigo());
		String extension =  fullPath.substring(fullPath.lastIndexOf(".") + 1);
		
		DAOFactory fabrica = DAOFactory.getDaoFactory(1);
		int res = fabrica.getUsuarioDAO().actualizarFoto(usu.getCodigo(), extension);
		if (res == 0) {
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error en el actualizar',"
					+ "            text: 'Error en la foto'"
				
					+ "        })</script>";;
					
			request.setAttribute("mensajeError", mensaje);
			request.getRequestDispatcher("confiCuenta.jsp").forward(request, response);
		}else {
			String mensaje ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Actualización completada',"
					+ "           text: 'Foto actualizada'"
					
					+ "        })</script>";
			
			request.setAttribute("mensajeError", mensaje);
			
			request.getRequestDispatcher("confiCuenta.jsp").forward(request, response);
		}
		
		
	}

	private String guardarFotoPerfil(Part part, File pathUploads, String codigo) {
		String fullPath = "";
		
		try {
			
			Path path = Paths.get(part.getSubmittedFileName());
			
			String fileName = path.getFileName().toString();
			String extension = fileName.substring(fileName.lastIndexOf(".")).trim();
		
			InputStream input = part.getInputStream();
			String fullFile = codigo.concat(extension) ;
			File file = new File(pathUploads, fullFile);
			if(input != null) {
				
				if(file.exists()) {
					file.delete();
				}
				
				fullPath = file.getAbsolutePath();
				Files.copy(input, file.toPath());
				
			}
			input.close();
		}
		catch (Exception e) {
			System.out.println("Error en guardar el archivo: " + e.getMessage());
		}
		
		return fullPath;
	}

}
