package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DestinoInterface;
import model.Destino;
import model.Vuelo;
import model.tipoDestino;
import utils.MySQLConexion;

public class GestionDestinoDAOMYSQL implements DestinoInterface{

	@Override
	public Destino buscar(int cod) {
		Destino des = null;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from destinos where cod_destino=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cod);
			res = pstm.executeQuery();
			if(res.next()) {
				des = new Destino();
				des.setCodDestino(res.getInt(1));
				des.setAeropueDes(res.getString(2));
				des.setCiudadDes(res.getString(3));
				des.setPaisDes(res.getString(4));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return des;
	}

	@Override
	public ArrayList<Destino> listarDestinos() {
		ArrayList<Destino> listado = new ArrayList();
		Destino des = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from destinos";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			while(res.next()) {
				des = new Destino();
				des.setCodDestino(res.getInt(1));
				des.setAeropueDes(res.getString(2));
				des.setCiudadDes(res.getString(3));
				des.setPaisDes(res.getString(4));
				listado.add(des);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
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
	public ArrayList<Destino> BuscarDestino(String desc) {
		ArrayList<Destino> buscar = new  ArrayList<Destino>();//null
		Destino des;
		 PreparedStatement pstm = null; //porq vamos a ejecutar un comando en sql
		 Connection con = null;//para poder conectarnos a la base de datos
		 ResultSet res = null;// para hacer una consulta y scar la info
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="{call usp_buscarDestino(?)}"; //se usa con comilla cuando es una instruccion asi
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				//PASO 4: PARAMETROS <--- no hay
				pstm.setString(1, desc);
				//paso 5 : ejecutar la instruccion
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					des = new Destino ();
					//setear(asignar valores del objeto res a los atributos privados)
					des.setCodDestino(res.getInt(1));
					des.setAeropueDes(res.getString(2));
					des.setCiudadDes(res.getString(3));
					des.setPaisDes(res.getString(4));
					//a�adir el objeto user al arreglo
					buscar.add(des);
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Reportar Cliente x nombre" + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
	}
		return buscar;
	}

	@Override
	public ArrayList<tipoDestino> listarTipoDestinos() {
		ArrayList<tipoDestino> lista = new ArrayList<tipoDestino>();
		tipoDestino d;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="SELECT cod_destino,aeropuerto_destino FROM destinos;";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					d = new tipoDestino();
					
					d.setCod_destino(res.getInt(1));
					d.setDesc_destino(res.getString(2));
					
					lista.add(d);
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
	
}
