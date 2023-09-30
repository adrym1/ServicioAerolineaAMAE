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
import model.Hotel;

/**
 * Servlet implementation class verReservaHabitacion
 */
@WebServlet(name = "verReserva", urlPatterns = { "/verReserva" })
public class verReservaHabitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verReservaHabitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory fabrica = DAOFactory.getDaoFactory(1);
		ArrayList<Hotel> lstHoteles = fabrica.getHotelDAO().listadoHotelDisponibles();
		ArrayList<Destino> lstDestinos = (ArrayList<Destino>) fabrica.getDestinoDAO().listarDestinos();
		String codSol = fabrica.getReservaHabitacionDAO().obtenerCod();
		LocalDate fecha = LocalDate.now();
		request.setAttribute("codSol", codSol);
		request.setAttribute("fechaActual".toString(), fecha);
		request.setAttribute("lstDestinos", lstDestinos);
		request.getSession().setAttribute("lstHoteles", lstHoteles);
		request.getRequestDispatcher("reservaHotel.jsp").forward(request, response);
	}

}
