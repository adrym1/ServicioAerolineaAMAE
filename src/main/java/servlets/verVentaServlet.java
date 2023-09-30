package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.Destino;
import model.Vuelo;

/**
 * Servlet implementation class verVentaServlet
 */
@WebServlet(name = "verVenta", urlPatterns = { "/verVenta" })
public class verVentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verVentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory fabrica = DAOFactory.getDaoFactory(1);
		int codVenta = fabrica.getVentaDAO().obtenerCod();
		LocalDate today = LocalDate.now();
		
		ArrayList<Vuelo> listado = (ArrayList<Vuelo>) fabrica.getVueloDAO().listadoVueloActivos();
		ArrayList<Destino> lstDestinos = (ArrayList<Destino>) fabrica.getDestinoDAO().listarDestinos();
		request.getSession().setAttribute("codVenta", codVenta);
		request.getSession().setAttribute("fechaHoy", today.toString());
		request.setAttribute("listado", listado);
		request.setAttribute("lstDestinos", lstDestinos);
		request.getRequestDispatcher("ventas_01.jsp").forward(request, response);
	}

}
