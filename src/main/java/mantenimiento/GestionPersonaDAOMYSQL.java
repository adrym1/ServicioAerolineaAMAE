package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import interfaces.PersonaInterface;
import model.Persona;
import utils.MySQLConexion;

public class GestionPersonaDAOMYSQL implements PersonaInterface{

	@Override
	public int registrarPer(Persona p) {
		return 0;

		
	}

	@Override
	public int actualizarPer(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Persona buscar(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int obtenerCod(Persona p) {
		// TODO Auto-generated method stub
		return 0;
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
			String sql = "{call usp_cod_persona()}";
			
			pstm = conn.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			if(res.next()) {
				codigo = res.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}
	

}
