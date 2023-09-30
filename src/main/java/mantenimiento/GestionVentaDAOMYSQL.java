package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentaInterface;
import model.CheckIn;
import model.Hotel;
import model.Persona;
import model.Tarjeta;
import model.VentaCabezera;
import model.Vuelo;
import utils.MySQLConexion;

public class GestionVentaDAOMYSQL implements VentaInterface{

	@Override
	public int obtenerCod() {
		int codigo = 0;
		//Plantilla
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "{call usp_cod_venta()}";
			
			pstm = conn.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			if(res.next()) {
				codigo = res.getInt(1);
			}
			System.out.println("Codigo es: " + codigo);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrarlo: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}

	@Override
	public int realizarVenta(VentaCabezera cabe, ArrayList<Persona> personas,Tarjeta ta ,Vuelo ida, Vuelo vuelta) {
		// TODO Auto-generated method stub
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		//Para las tarjetas
		PreparedStatement pstm = null;
		//PAra la venta_pasajes
		PreparedStatement pstm1 = null;
		//Para la personas
		PreparedStatement pstm2 = null;
		//Para los detalles
		PreparedStatement pstm3 = null;
		//Para la boleta
		PreparedStatement pstm4 = null;

	
		try {
			conn = MySQLConexion.getConexion();
			//Desactivar las transacciones
			conn.setAutoCommit(false);
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
				
			String sql1 = "insert into venta_pasajes values (?,?,?,?,?,?,?,?)";
			pstm1 = conn.prepareStatement(sql1);
			pstm1.setInt(1, cabe.getCodVenta());
			pstm1.setString(2, cabe.getFecha());
			pstm1.setString(3, cabe.getClave());
			pstm1.setDouble(4, cabe.getPrecioTotal());
			pstm1.setInt(5,cabe.getCanti());
			pstm1.setString(6, cabe.getTipo());
			pstm1.setString(7, "Desactivado");
			pstm1.setInt(8, cabe.getCodTarjeta());
	
			res = pstm1.executeUpdate();
			//Para las personas
			
			for (Persona p : personas) {
				String sql2 = "insert into venta_pasaje_persona values (?,?,?,?,?,?,?,?,?,?,default)";
				pstm2 = conn.prepareStatement(sql2);
				pstm2.setInt(1, p.getCodPersona());
				pstm2.setString(2, p.getNombre());
				pstm2.setString(3, p.getApellido());
				pstm2.setString(4, p.getDni());
				pstm2.setString(5, p.getSexo());
				pstm2.setString(6, p.getNaciona());
				pstm2.setString(7, p.getDomici());
				pstm2.setString(8, p.getEstado());
				pstm2.setInt(9, p.getCodiPostal());
				pstm2.setInt(10, p.getPais());
				res = pstm2.executeUpdate();

				//Para el detalle
				String sql3 = "insert into venta_pasaje_detalle values(?,?,?,?)";
				pstm3 = conn.prepareStatement(sql3);
				pstm3.setInt(1, cabe.getCodVenta());
				pstm3.setInt(2, p.getCodPersona());
				pstm3.setString(3, ida.getCodVuelo());
				pstm3.setString(4, vuelta.getCodVuelo());
				res = pstm3.executeUpdate();
			}
		
			
			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error en el roll back: " + e1.getMessage());
			}
			// TODO: handle exception
			System.out.println("Error en registrar - Transaccion: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public CheckIn obtenerCheckIn(int codVenta, String fecha, String dni) {
		
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		CheckIn che = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_verficarCheckIn(?,? ,? )}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codVenta);
			pstm.setString(2, fecha);
			pstm.setString(3, dni);
			res = pstm.executeQuery();

			if (res.next()) {
				che = new CheckIn();
				che.setCodVenta(res.getInt(1));
				che.setFecha(res.getString(2));
				che.setCheckIn(res.getString(3));
				che.setDni(res.getString(4));
				
			}

		} catch (Exception e) {
			System.out.println("Error en el check-in: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return che;
		
	}

	@Override
	public int realizarCheckIn(int codVenta, String fecha, String dni) {
	// PLANTILLA DE BD
			Connection con = null;
			PreparedStatement pstm = null;
			
			int res = 0;
			try {
				con = MySQLConexion.getConexion();
				String sql = "update venta_pasajes set checkIn_venta = 'Activado' where cod_venta = ? AND "
						+ "fecha_venta = ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, codVenta);
				pstm.setString(2, fecha);
				res = pstm.executeUpdate();


			} catch (Exception e) {
				System.out.println("Error en activar del check-in: " + e.getMessage());
			} finally {
				MySQLConexion.closeConexion(con);
			}

			return res;
	}
	
}
