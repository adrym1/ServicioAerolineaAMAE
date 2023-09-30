package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.PromocionInterface;
import model.Cliente;
import model.Promocion;
import utils.MySQLConexion;

public class GestionPromocionDAOMYSQL implements PromocionInterface {

	@Override
	public ArrayList<Promocion> listado() {
		ArrayList<Promocion> lista = new ArrayList<Promocion>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.promocion where estado = 1;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Promocion pr = new Promocion();
                  
				pr.setCod_promocion(rs.getInt(1));
				pr.setClave_promocion(rs.getString(2));
				pr.setTitulo_promocion(rs.getString(3));
				pr.setDescripcion(rs.getString(4));
				pr.setFechaValida(rs.getString(5));
				pr.setFechaCaducidad(rs.getString(6));
				pr.setDescuento(rs.getDouble(7));
				pr.setTipoCliente(rs.getInt(8));
				
				
				
				
				
				
		
				
				lista.add(pr);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO DE PROMOCION" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}
	@Override
	public ArrayList<Promocion> listarPromo() {
		ArrayList<Promocion> lista = new ArrayList<Promocion>();
		Promocion pr = null;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="select * from promocion";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					pr = new Promocion();
					pr.setCod_promocion(res.getInt(1));
					pr.setClave_promocion(res.getString(2));
					pr.setTitulo_promocion(res.getString(3));
					pr.setDescripcion(res.getString(4));
					pr.setFechaValida(res.getString(5));
					pr.setFechaCaducidad(res.getString(6));
					pr.setDescuento(res.getDouble(7));
					pr.setTipoCliente(res.getInt(8));
					lista.add(pr);
				}
			}catch (Exception e){
				System.out.println(">>>>> Error Promocion - Listar" + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD - Promocion" + e2.getMessage());			
				}
				
			}
		return lista;
	
	}

	@Override
	public Promocion obtenerPromo(String clave) {
		Promocion pr = null;
		//Plantilla de base de datos
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet res = null;
				try {
					conn = MySQLConexion.getConexion();
					String sql = "select * from promocion where clave_promocion=?";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, clave);
					res = pstm.executeQuery();
					if(res.next()) {
						pr = new Promocion();
						pr.setCod_promocion(res.getInt(1));
						pr.setClave_promocion(res.getString(2));
						pr.setTitulo_promocion(res.getString(3));
						pr.setDescripcion(res.getString(4));
						pr.setFechaValida(res.getString(5));
						pr.setFechaCaducidad(res.getString(6));
						pr.setDescuento(res.getDouble(7));
						pr.setTipoCliente(res.getInt(8));
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error en la busqueda de promoción: " + e.getMessage());
				}finally {
					MySQLConexion.closeConexion(conn);
				}
				return pr;
	}
	@Override
	public Promocion buscar(int codigo) {
		Promocion pr = null;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.promocion where cod_promocion = ? ;";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();

			while (rs.next()) {
				pr = new Promocion();
				pr.setCod_promocion(rs.getInt(1));
				pr.setClave_promocion(rs.getString(2));
				pr.setTitulo_promocion(rs.getString(3));
				pr.setDescripcion(rs.getString(4));
				pr.setFechaValida(rs.getString(5));
				pr.setFechaCaducidad(rs.getString(6));
				pr.setDescuento(rs.getDouble(7));
				pr.setTipoCliente(rs.getInt(8));
				
				
			}
		} catch (Exception e) {
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Buscar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e2) {
				System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());
			}

		}
		return pr;
	}

	@Override
	public int registrar(Promocion pr) {
		int rs = 0; // valor x default en caso de error

		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "Insert into promocion values ( ?, ? , ?,?,\r\n"
					+ "?, ?, ? , ?,   default );";
			pst = con.prepareStatement(sql);

			
			
			
	
			

			pst.setInt(1, pr.getCod_promocion());
			pst.setString(2, pr.getClave_promocion());
			pst.setString(3, pr.getTitulo_promocion());
			pst.setString(4, pr.getDescripcion());
			pst.setString(5, pr.getFechaValida());
			pst.setString(6, pr.getFechaCaducidad());
			pst.setDouble(7, pr.getDescuento());
			pst.setInt(8, pr.getTipoCliente());
			

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el registrar promocion: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	@Override
	public int actualizar(Promocion pr) {
		int res = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update promocion set  clave_promocion = ? , \r\n"
					+ "titulo_promocion = ? ,descripcion_promocion = ? \r\n"
					+ ", fechavalida_promocion = ? , fechaCaducidad_promocion = ? , \r\n"
					+ " descuento_promocion = ? , tipoCliente_promocion = ?      where cod_promocion = ? ;";
			pst = con.prepareStatement(sql);
	
			//PASO 4: PARAMETROS
			
	     

		
			pst.setString(1, pr.getClave_promocion());
			pst.setString(2, pr.getTitulo_promocion());
			pst.setString(3, pr.getDescripcion());
			pst.setString(4, pr.getFechaValida());
			pst.setString(5, pr.getFechaCaducidad());
			pst.setDouble(6, pr.getDescuento());
			pst.setInt(7, pr.getTipoCliente());
			pst.setInt(8, pr.getCod_promocion());
			
			
			//PASO 5: EJECUTAR LA INSTRUCCION
			res = pst.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar Cliente" + e.getMessage());
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
	public int eliminar(Promocion pr) {
		int rs = 0; // valor x default en caso de error

		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update promocion set estado = 2  where cod_promocion = ? ; ";
			pst = con.prepareStatement(sql);
			pst.setInt(1, pr.getCod_promocion());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en eliminar : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	@Override
	public ArrayList<Promocion> listadoPromocionInactivos() {
		ArrayList<Promocion> lista = new ArrayList<Promocion>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.promocion where estado = 2;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Promocion pr = new Promocion();
                  
				pr.setCod_promocion(rs.getInt(1));
				pr.setClave_promocion(rs.getString(2));
				pr.setTitulo_promocion(rs.getString(3));
				pr.setDescripcion(rs.getString(4));
				pr.setFechaValida(rs.getString(5));
				pr.setFechaCaducidad(rs.getString(6));
				pr.setDescuento(rs.getDouble(7));
				pr.setTipoCliente(rs.getInt(8));
				
				
				
				
				
				
		
				
				lista.add(pr);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO DE PROMOCION" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public int activarActualizar(Promocion pr) {
		int res = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update promocion set  clave_promocion = ? , \r\n"
					+ "titulo_promocion = ? ,descripcion_promocion = ? \r\n"
					+ ", fechavalida_promocion = ? , fechaCaducidad_promocion = ? , \r\n"
					+ " descuento_promocion = ? , tipoCliente_promocion = ?  ,estado = 1    where cod_promocion = ? ;";
			pst = con.prepareStatement(sql);
	
			//PASO 4: PARAMETROS
			
	     

		
			pst.setString(1, pr.getClave_promocion());
			pst.setString(2, pr.getTitulo_promocion());
			pst.setString(3, pr.getDescripcion());
			pst.setString(4, pr.getFechaValida());
			pst.setString(5, pr.getFechaCaducidad());
			pst.setDouble(6, pr.getDescuento());
			pst.setInt(7, pr.getTipoCliente());
			pst.setInt(8, pr.getCod_promocion());
			
			
			//PASO 5: EJECUTAR LA INSTRUCCION
			res = pst.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar Cliente" + e.getMessage());
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

}
