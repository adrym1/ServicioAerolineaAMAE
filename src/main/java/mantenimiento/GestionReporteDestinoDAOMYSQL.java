package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReporteDestinoInterface;
import model.ReporteDestino;
import utils.MySQLConexion;

public class GestionReporteDestinoDAOMYSQL implements ReporteDestinoInterface{

	@Override
	public ArrayList<ReporteDestino> listado() {
		 ArrayList<ReporteDestino> lista = new  ArrayList<ReporteDestino>();
		 ReporteDestino des;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				con = MySQLConexion.getConexion();		
				String sql ="{call usp_listarDestino}";				
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				while(res.next()) {
					des = new ReporteDestino();
					
					des.setCodigo(res.getInt(1));
					des.setAeropuerto(res.getString(2));
					des.setCiudad(res.getString(3));
					des.setPais(res.getString(4));
					lista.add(des);
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
	public ArrayList<ReporteDestino> BuscarDestino(String desc) {
		ArrayList<ReporteDestino> buscar = new  ArrayList<ReporteDestino>();//null
		ReporteDestino des;
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
					des = new ReporteDestino ();
					//setear(asignar valores del objeto res a los atributos privados)
					des.setCodigo(res.getInt(1));
					des.setAeropuerto(res.getString(2));
					des.setCiudad(res.getString(3));
					des.setPais(res.getString(4));
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

}
