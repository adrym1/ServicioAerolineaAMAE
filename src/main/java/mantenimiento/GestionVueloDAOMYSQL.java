package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VueloIntefarce;
import model.Destino;
import model.Vuelo;
import utils.MySQLConexion;

public class GestionVueloDAOMYSQL implements VueloIntefarce{

	@Override
	public ArrayList<Vuelo> listadoVuelo() {
		ArrayList<Vuelo> listado = new ArrayList<>();
		Vuelo vu = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from vuelo";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			while(res.next()) {
				vu = new Vuelo();
				vu.setCodVuelo(res.getString(1));
				vu.setCodAvion(res.getInt(2));
				vu.setPiloto(res.getString(3));
				vu.setCopiloto(res.getString(4));
				vu.setEstado(res.getInt(5));
				vu.setCodDesSalida(res.getInt(6));
				vu.setCodDesLlegada(res.getInt(7));
				vu.setPrecioVuelo(res.getDouble(8));
				vu.setHoraVuelo(res.getString(9));
				vu.setFechaSalida(res.getString(10));
				vu.setFechaLlegada(res.getString(11));
				
				listado.add(vu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar - Ventas: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en cerrar RES : " + e.getMessage());
			}
		}
		return listado;
		
	}

	@Override
	public Vuelo buscar(String cod) {
		Vuelo vu = null;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from vuelo where cod_vuelo=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeQuery();
			if(res.next()) {
				vu = new Vuelo();
				vu.setCodVuelo(res.getString(1));
				vu.setCodAvion(res.getInt(2));
				vu.setPiloto(res.getString(3));
				vu.setCopiloto(res.getString(4));
				vu.setEstado(res.getInt(5));
				vu.setCodDesSalida(res.getInt(6));
				vu.setCodDesLlegada(res.getInt(7));
				vu.setPrecioVuelo(res.getDouble(8));
				vu.setHoraVuelo(res.getString(9));
				vu.setFechaSalida(res.getString(10));
				vu.setFechaLlegada(res.getString(11));
				

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return vu;
	}
	
	@Override
	public ArrayList<Vuelo> buscarxFecha(String Fecha1, String Fecha2) {
		ArrayList<Vuelo> filtrar = new  ArrayList<Vuelo>();//null
		Vuelo vu;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				con = MySQLConexion.getConexion();
				String sql ="{call usp_reportarVuelosXFecha(?,?)}"; 
				pstm = con.prepareStatement(sql);
				pstm.setString(1, Fecha1);
				pstm.setString(2, Fecha2);
				res = pstm.executeQuery();
				while(res.next()) {
					vu = new Vuelo ();
					vu.setCodVuelo(res.getString(1));
					vu.setPiloto(res.getString(2));
					vu.setCodDesSalida((res.getInt(3)));
					vu.setPrecioVuelo(res.getDouble(4));
					vu.setHoraVuelo(res.getString(5));
					vu.setFechaSalida(res.getString(6));
					filtrar.add(vu);
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Reportar Vuelo x Fecha" + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
	}
		return filtrar;
	}

	@Override
	public int registrar(Vuelo v) {
		int rs = 0; 

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into vuelo values(?,?,?,?,default,?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, v.getCodVuelo());
			pst.setInt(2, v.getCodAvion());
			pst.setString(3, v.getPiloto());
			pst.setString(4, v.getCopiloto());
			pst.setInt(5, v.getCodDesSalida());
			pst.setInt(6, v.getCodDesLlegada());
			pst.setDouble(7, v.getPrecioVuelo());
			pst.setString(8, v.getHoraVuelo());
			pst.setString(9, v.getFechaSalida());
			pst.setString(10, v.getFechaLlegada());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el registrar Vuelo: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	@Override
	public int actualizar(Vuelo v) {
		int res = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update vuelo set  cod_avion= ?, piloto_vuelo= ?, copiloto_vuelo = ?, cod_destino_salida = ?, cod_destino_llegada = ?, precio_vuelo = ?, hora_vuelo = ?, fechaSalida_vuelo = ?, fechaLlegada_vuelo = ?, estado_vuelo=default where cod_vuelo = ?;";
			pst = con.prepareStatement(sql);
				
			pst.setInt(1, v.getCodAvion());
			pst.setString(2, v.getPiloto());
			pst.setString(3, v.getCopiloto());
			pst.setInt(4, v.getCodDesSalida());
			pst.setInt(5, v.getCodDesLlegada());
			pst.setDouble(6, v.getPrecioVuelo());
			pst.setString(7, v.getHoraVuelo());
			pst.setString(8, v.getFechaSalida());
			pst.setString(9, v.getFechaLlegada());
			pst.setString(10, v.getCodVuelo());
			
			//PASO 5: EJECUTAR LA INSTRUCCION
			res = pst.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar Vuelo" + e.getMessage());
		}finally {
			try{
				if(pst != null) pst.close();
				if(con != null) con.close();
			}catch (SQLException e2) {
				System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
			}
			
		}
		return res;
	}

	@Override
	public int eliminar(Vuelo v) {
		int rs = 0; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "UPDATE vuelo SET estado_vuelo = '2' WHERE cod_vuelo = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, v.getCodVuelo());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en eliminar : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	@Override
	public ArrayList<Vuelo> listadoVueloActivos() {
		ArrayList<Vuelo> listado = new ArrayList<>();
		Vuelo vu = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from vuelo where estado_vuelo = 1";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			while(res.next()) {
				vu = new Vuelo();
				vu.setCodVuelo(res.getString(1));
				vu.setCodAvion(res.getInt(2));
				vu.setPiloto(res.getString(3));
				vu.setCopiloto(res.getString(4));
				vu.setEstado(res.getInt(5));
				vu.setCodDesSalida(res.getInt(6));
				vu.setCodDesLlegada(res.getInt(7));
				vu.setPrecioVuelo(res.getDouble(8));
				vu.setHoraVuelo(res.getString(9));
				vu.setFechaSalida(res.getString(10));
				vu.setFechaLlegada(res.getString(11));
				
				listado.add(vu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar - Ventas: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error en cerrar RES : " + e.getMessage());
			}
		}
		return listado;
	}
}
