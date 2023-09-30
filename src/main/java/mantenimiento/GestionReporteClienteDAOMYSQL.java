package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReporteClienteInterface;
import model.ReporteCliente;
import utils.MySQLConexion;

public class GestionReporteClienteDAOMYSQL implements ReporteClienteInterface{

	@Override
	public ArrayList<ReporteCliente> listado() {
		 ArrayList<ReporteCliente> lista = new  ArrayList<ReporteCliente>();
		 ReporteCliente cli;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="{call usp_ListarCliente}";
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					cli = new ReporteCliente();
					
					cli.setCodCli(res.getString(1));
					cli.setNombCli(res.getString(2));
					cli.setCorreoCli(res.getString(3));
					cli.setTipoDocCli(res.getString(4));
					cli.setNumDocCli(res.getString(5));
					cli.setTipoClie(res.getString(6));
					cli.setFechaAso(res.getString(7));
					lista.add(cli);
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
	public ArrayList<ReporteCliente> listarClienteXFecha(String Fecha1) {
		ArrayList<ReporteCliente> filtrar = new  ArrayList<ReporteCliente>();//null
		ReporteCliente cli;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				
				con = MySQLConexion.getConexion();
				
				String sql ="{call usp_filtrarxFechaCliente(?)}"; 
			
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, Fecha1);
				
				res = pstm.executeQuery();
				
				while(res.next()) {
					
					cli = new ReporteCliente ();
					
					cli.setCodCli(res.getString(1));
					cli.setNombCli(res.getString(2));
					cli.setCorreoCli(res.getString(3));
					cli.setTipoDocCli(res.getString(4));
					cli.setNumDocCli(res.getString(5));
					cli.setTipoClie(res.getString(6));
					cli.setFechaAso(res.getString(7));
					//a�adir el objeto user al arreglo
					filtrar.add(cli);
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Reportar Cliente x Fecha" + e.getMessage());
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
	public ArrayList<ReporteCliente> buscar(String nomb) {
		ArrayList<ReporteCliente> bus = new  ArrayList<ReporteCliente>();//null
		ReporteCliente cli;
		 PreparedStatement pstm = null; //porq vamos a ejecutar un comando en sql
		 Connection con = null;//para poder conectarnos a la base de datos
		 ResultSet res = null;// para hacer una consulta y scar la info
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="{call usp_ClienteBuscar(?)}"; //se usa con comilla cuando es una instruccion asi
				//PASO 3: enviar la instrucion al objeto pstm --> obtner los comandos sql
				pstm = con.prepareStatement(sql);
				//PASO 4: PARAMETROS <--- no hay
				pstm.setString(1, nomb);
				//paso 5 : ejecutar la instruccion
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					cli = new ReporteCliente ();
					//setear(asignar valores del objeto res a los atributos privados)
					cli.setCodCli(res.getString(1));
					cli.setNombCli(res.getString(2));
					cli.setCorreoCli(res.getString(3));
					cli.setTipoDocCli(res.getString(4));
					cli.setNumDocCli(res.getString(5));
					cli.setTipoClie(res.getString(6));
					cli.setFechaAso(res.getString(7));
					//a�adir el objeto user al arreglo
					bus.add(cli);
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
		return bus;
	}

}
