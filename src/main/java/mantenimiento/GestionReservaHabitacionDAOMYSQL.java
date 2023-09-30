package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import interfaces.ReservaHabitacionInterface;
import model.ReservaHabitacion;
import utils.MySQLConexion;

public class GestionReservaHabitacionDAOMYSQL implements ReservaHabitacionInterface {

	@Override
	public int registrar(ReservaHabitacion re) {
		int res = 0;
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into reserva_hotel values(?,?,?,?,?,?,?,?);";
			pstm = con.prepareStatement(sql);

			pstm.setString(1, re.getNumSoli());
			pstm.setString(2, re.getFechaReserva());
			pstm.setInt(3, re.getCodHotel());
			pstm.setInt(4, re.getCodDes());
			pstm.setString(5, re.getFechaIngreso());
			pstm.setString(6, re.getFechaSalida());
			pstm.setInt(7, re.getCantidad());
			pstm.setString(8, re.getTipo());
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el registrar Cliente: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return res;
	}

	@Override
	public String obtenerCod() {
		String codigo = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select MAX(substring(numSol_reserva,3)) from reserva_hotel";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("000");
				codigo = "SO" + df.format(Integer.parseInt(res.getString(1)) + 1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en obtener el codigo: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}

}
