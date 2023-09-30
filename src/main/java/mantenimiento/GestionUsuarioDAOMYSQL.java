package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import interfaces.UsuarioInterface;
import model.usuario;
import utils.MySQLConexion;

public class GestionUsuarioDAOMYSQL implements UsuarioInterface {

	@Override
	public int registrar(usuario u) {
		int rs = 0; 
		Connection con = null;
		PreparedStatement pstm= null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="insert into usuario values (?,?,?,?,default, null);";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getCodigo());
			pstm.setString(2, u.getUsuario());
			pstm.setString(3, u.getClave());
			pstm.setInt(4, u.getTipo());
			
			rs = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Registrar " + e.getMessage());
		}
		return rs;
	}

	@Override
	public int actualizar(usuario u) {
		int rest = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update usuario set usuario = ?, contraseña_usuario = ?, tipo_usuario = ? where cod_usuario = ?;";
			pstm = con.prepareStatement(sql);
			//PASO 4: PARAMETROS
			pstm.setString(1, u.getUsuario());
			pstm.setString(2, u.getClave());
			pstm.setInt(3, u.getTipo());
			pstm.setString(4, u.getCodigo());
			//PASO 5: EJECUTAR LA INSTRUCCION
			rest = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar" + e.getMessage());
		}finally {
			try{
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			}catch (SQLException e2) {
				System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
			}
			
		}
		return rest;
	}

	@Override
	public int eliminar(usuario u) {
		int rest = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="UPDATE usuario SET estado = '2' WHERE cod_usuario = ?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getCodigo());
			
			rest = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Eliminar" + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		return rest;
	}

	@Override
	public ArrayList<usuario> listado() {
		 ArrayList<usuario> lista = new  ArrayList<usuario>();
		 usuario usu;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="SELECT  u.*,t.desc_tipo_usuario,e.desc_estado FROM usuario u inner join tipo_usuario t on u.tipo_usuario = t.cod_tipo_usuario \r\n"
						+ "inner join estado e on u.estado = e.id_estado;";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					usu = new usuario();
					
					usu.setCodigo(res.getString(1));
					usu.setUsuario(res.getString(2));
					usu.setClave(res.getString(3));
					usu.setDesc_tipo(res.getString(7));
					usu.setDesc_estado(res.getString(8));
					lista.add(usu);
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Consultar" + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
				
			}
		return lista;
	}

	@Override
	public usuario buscar(String codigo) {
		usuario u = null;
		//plantilla
		PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="select * from usuario where cod_usuario = ?";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				pstm.setString(1, codigo);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					u = new usuario();
					u.setCodigo(res.getString(1));
					u.setUsuario(res.getString(2));
					u.setClave(res.getString(3));
					u.setTipo(res.getInt(4));
					u.setEstado(res.getInt(5));
					u.setExtension(res.getString(6));
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Buscar " + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
				
			}
		return u;
	}

	@Override
	public usuario ingresar(String email, String contra) {
		usuario u = null;
		//plantilla
		PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="select * from usuario where usuario = ? and contraseña_usuario=?";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				pstm.setString(1, email);
				pstm.setString(2, contra);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					u = new usuario();
					u.setCodigo(res.getString(1));
					u.setUsuario(res.getString(2));
					u.setClave(res.getString(3));
					u.setTipo(res.getInt(4));
					u.setEstado(res.getInt(5));
					u.setExtension(res.getString(6));
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Buscar Login " + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
				
			}
		return u;
	}

	@Override
	public ArrayList<usuario> listadoSoloUsuario() {
		ArrayList<usuario> lista = new  ArrayList<usuario>();
		 usuario usu;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="SELECT  *  FROM usuario";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					usu = new usuario();
					
					usu.setCodigo(res.getString(1));
					usu.setUsuario(res.getString(2));
					usu.setClave(res.getString(3));
					usu.setTipo(res.getInt(4));
					usu.setEstado(res.getInt(5));
					usu.setExtension(res.getString(6));
					lista.add(usu);
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Consultar Usuario" + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
				
			}
		return lista;
	}

	@Override
	public int actualizarCuenta(String cod, String email, String pass) {
		int rest = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update usuario set usuario = ?, contraseña_usuario = ? where cod_usuario = ?;";
			pstm = con.prepareStatement(sql);
			//PASO 4: PARAMETROS
			pstm.setString(1, email);
			pstm.setString(2, pass);
			pstm.setString(3, cod);
			//PASO 5: EJECUTAR LA INSTRUCCION
			rest = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar Datos Cuenta" + e.getMessage());
		}finally {
			try{
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			}catch (SQLException e2) {
				System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
			}
			
		}
		return rest;
	}

	@Override
	public int actualizarFoto(String cod, String exten) {
		int rest = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update usuario set exte_usuario = ?  where cod_usuario = ?;";
			pstm = con.prepareStatement(sql);
			//PASO 4: PARAMETROS
			pstm.setString(1, exten);
			pstm.setString(2, cod);

			//PASO 5: EJECUTAR LA INSTRUCCION
			rest = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar Foto Cuenta" + e.getMessage());
		}finally {
			try{
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			}catch (SQLException e2) {
				System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
			}
			
		}
		return rest;
	}

	
	
}
