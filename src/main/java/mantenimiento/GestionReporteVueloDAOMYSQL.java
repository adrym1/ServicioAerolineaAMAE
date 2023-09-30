package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReporteVueloInterface;
import model.ReporteVuelo;
import utils.MySQLConexion;

public class GestionReporteVueloDAOMYSQL implements ReporteVueloInterface{

	@Override
	public ArrayList<ReporteVuelo> listado() {
		ArrayList<ReporteVuelo> lista = new  ArrayList<ReporteVuelo>();
		ReporteVuelo vu;
		 PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				con = MySQLConexion.getConexion();		
				String sql ="{call usp_listarVuelos}";				
				pstm = con.prepareStatement(sql);
				res = pstm.executeQuery();
				while(res.next()) {
					vu = new ReporteVuelo();					
					vu.setCodigo(res.getString(1));
					vu.setPiloto(res.getString(2));
					vu.setCopiloto(res.getString(3));
					vu.setPrecio(res.getDouble(4));
					vu.setHora(res.getString(5));
					vu.setFecha_Salida(res.getString(6));
					vu.setFecha_Llegada(res.getString(7));
					lista.add(vu);
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Listar " + e.getMessage());
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
	public ArrayList<ReporteVuelo> buscarxFecha(String Fecha1, String Fecha2) {
		ArrayList<ReporteVuelo> filtrar = new  ArrayList<ReporteVuelo>();//null
		ReporteVuelo vu;
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
					vu = new ReporteVuelo ();
					vu.setCodigo(res.getString(1));
					vu.setPiloto(res.getString(2));
					vu.setCopiloto(res.getString(3));
					vu.setPrecio(res.getDouble(4));
					vu.setHora(res.getString(5));
					vu.setFecha_Salida(res.getString(6));
					vu.setFecha_Llegada(res.getString(7));
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

}
