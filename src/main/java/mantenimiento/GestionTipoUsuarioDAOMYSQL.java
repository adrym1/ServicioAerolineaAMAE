package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.TipoUsuarioInterface;
import model.tipo_usuario;
import utils.MySQLConexion;

public class GestionTipoUsuarioDAOMYSQL implements TipoUsuarioInterface{

	@Override
	public ArrayList<tipo_usuario> Listado() {
		ArrayList<tipo_usuario> lista = new ArrayList<tipo_usuario>();
		tipo_usuario c;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="select * from tipo_usuario";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					c = new tipo_usuario();
					
					c.setIdTipo(res.getInt(1));
					c.setDescripcion(res.getString(2));
					
					lista.add(c);
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Listar" + e.getMessage());
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
	public tipo_usuario obtenerTipo(int tipo) {
		
		tipo_usuario c = null;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="select * from tipo_usuario where cod_tipo_usuario = ?";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, tipo);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					c = new tipo_usuario();
					
					c.setIdTipo(res.getInt(1));
					c.setDescripcion(res.getString(2));
					
					
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Listar" + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
				
			}
		return c;	
		}

}
