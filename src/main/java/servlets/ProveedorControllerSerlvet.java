package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.Cliente;
import model.Proveedor;

/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet(name = "proveedor", description = "Mantenimiento proveedor", urlPatterns = { "/proveedor" })
public class ProveedorControllerSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorControllerSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Entro al Servlet de proveedor");
		
		       // la opcion seleccionada
				String accion = request.getParameter("btnAccion");
				System.out.println("Accion: " + accion);
				
		
	switch (accion) {
	
case "registrar": 
		
	 String cod_proveedor = request.getParameter("txtCodigo") ; 
	 String razonSocial = request.getParameter("txtRazonSocial");  	
	 String nombreEmpresa = request.getParameter("txtNombre"); 
	 String direccion  = request.getParameter("txtDireccion");
	 String correo = request.getParameter("txtCorreo"); 
	 int pais_proveedor = Integer.parseInt( request.getParameter("cboPais")) ;
	 String tipServicio_proveedor = request.getParameter("txtDescripcion");
	 String fechaAsociacion = request.getParameter("txtFecha"); 
	 int telefono  =  Integer.parseInt(  request.getParameter("txtTelefono"));
	 
	 Proveedor p = new Proveedor();
	 
	 p.setCod_proveedor(cod_proveedor);
	 p.setRazonSocial(razonSocial);
	 p.setNombreEmpresa(nombreEmpresa);
	 p.setPais_proveedor(pais_proveedor);
	 p.setCorreo(correo);
	 p.setTelefono(telefono);
	 p.setTipServicio_proveedor(tipServicio_proveedor);
	 p.setFechaAsociacion(fechaAsociacion);
	 p.setDireccion(direccion);
	 
		System.out.println(p);
	 
		// GestionProductoMySQL gp = new GestionProductoMySQL();
					// SE LLAMARA CON EL PATRON DAO
					DAOFactory fabrica = DAOFactory.getDaoFactory(1);

					int ok = fabrica.getProveedorDAO().registrar(p);

					//SALIDA
					if (ok == 0) {
						request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
						request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
					}else {
						
						request.setAttribute("mensaje","<script>swal('Mensaje!','Proveedor registrado', 'success');</script>");
						request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
					}
					
	 
	
	break;
	
case "actualizar": 
	
	  cod_proveedor = request.getParameter("txtCodigo") ; 
	  razonSocial = request.getParameter("txtRazonSocial");  	
	  nombreEmpresa = request.getParameter("txtNombre"); 
	  direccion  = request.getParameter("txtDireccion");
	  correo = request.getParameter("txtCorreo"); 
	  pais_proveedor = Integer.parseInt( request.getParameter("cboPais")) ;
	  tipServicio_proveedor = request.getParameter("txtDescripcion");
	  fechaAsociacion = request.getParameter("txtFecha"); 
	  telefono  =  Integer.parseInt(  request.getParameter("txtTelefono"));
	  p = new Proveedor();
	 
	 p.setCod_proveedor(cod_proveedor);
	 p.setRazonSocial(razonSocial);
	 p.setNombreEmpresa(nombreEmpresa);
	 p.setPais_proveedor(pais_proveedor);
	 p.setCorreo(correo);
	 p.setTelefono(telefono);
	 p.setTipServicio_proveedor(tipServicio_proveedor);
	 p.setFechaAsociacion(fechaAsociacion);
	 p.setDireccion(direccion);
	 
		System.out.println(p);
	 
		// GestionProductoMySQL gp = new GestionProductoMySQL();
					// SE LLAMARA CON EL PATRON DAO
					 fabrica = DAOFactory.getDaoFactory(1);

					 ok = fabrica.getProveedorDAO().actualizar(p);

					// SALIDA
						if (ok == 0) {
							request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
							request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
						}else {
							
							request.setAttribute("mensaje","<script>swal('Mensaje!','Proveedor actualizado', 'success');</script>");
							request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
						}
	 
		break ;
	
	
		
		case "eliminar": 
		
			
			
			
			
			String cod = request.getParameter("txtCodigo");
			// proceso para eliminar el producto
			 p = new Proveedor();
		   p.setCod_proveedor(cod);
			
			 fabrica = DAOFactory.getDaoFactory(1);
			//gp = new GestionProductoMySQL();
			 ok = fabrica.getProveedorDAO().eliminar(p);
			
			// SALIDA
				if (ok == 0) {
					request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
					request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
				}else {
					
					request.setAttribute("mensaje","<script>swal('Mensaje!','Proveedor desactivado', 'success');</script>");
					request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
				}

		
		break;
case "eliminarLista": 
			
			 cod = request.getParameter("codigo");
			// proceso para eliminar el producto
			 p = new Proveedor();
		   p.setCod_proveedor(cod);
			
			 fabrica = DAOFactory.getDaoFactory(1);
			//gp = new GestionProductoMySQL();
			 ok = fabrica.getProveedorDAO().eliminar(p);
			
			// SALIDA
				if (ok == 0) {
					request.setAttribute("mensaje","<script>swal({icon: 'error',title: 'Ups...', text: '¡Algo salió mal!',});</script>");
					request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
				}else {
					
					request.setAttribute("mensaje","<script>swal('Mensaje!','Proveedor desactivado', 'success');</script>");
					request.getRequestDispatcher("MantenimientoProveedor.jsp").forward(request, response);
				}
		
		break;
	
	case "listar": 
		
		 fabrica = DAOFactory.getDaoFactory(1);

		ArrayList<Proveedor>   lstProveedor = fabrica.getProveedorDAO().listado();
		
		request.setAttribute("lstProveedor", lstProveedor);
		
		request.getRequestDispatcher("FormularioProveedor.jsp").forward(request, response);
	
	break;
    case "buscar": 
		
    	// leer el codigo del producto q viene del listado
    				String codigo = request.getParameter("codigo");
    				// fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL)
    				fabrica = DAOFactory.getDaoFactory(1);
    				 p = new Proveedor();

    				p = fabrica.getProveedorDAO().buscar(codigo);
    				System.out.println(p);
    				// enviar la informacion encontrada a la pagina formulario cliente

    				//request.getSession().setAttribute("c", c);
    				//response.sendRedirect("FormularioCliente.jsp");
    				
    				
    				request.setAttribute("p", p);
    				request.getRequestDispatcher("FormularioProveedor.jsp").forward(request, response);
    				
	
	
		break;
	
	
	default:
		
	break;		
				
				
				
				

	}}}

