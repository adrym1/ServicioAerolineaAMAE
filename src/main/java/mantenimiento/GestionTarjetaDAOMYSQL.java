package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.TarjetaInterface;
import model.Tarjeta;
import utils.MySQLConexion;

public class GestionTarjetaDAOMYSQL implements TarjetaInterface {

	@Override
	public int realizarPago(Tarjeta ta) {
		// TODO Auto-generated method stub
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "insert into tarjetas values (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ta.getCodTarjeta());
			pstm.setString(2, ta.getMarca());
			pstm.setString(3, ta.getNumero());
			pstm.setString(4, ta.getTipo());
			pstm.setString(5, ta.getCvv());
			pstm.setString(6, ta.getTutor());
			pstm.setString(7, ta.getDni());
			

			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar - Tarjeta: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public int obtenerCod() {
		int codigo = 0;
		//Plantilla
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "{call usp_cod_tarjeta()}";
			
			pstm = conn.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			if(res.next()) {
				codigo = res.getInt(1) + 1;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrarlo: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}

}
