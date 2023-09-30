package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProveedorInterface;
import model.Cliente;
import model.Proveedor;
import utils.MySQLConexion;

public class GestionProveedorDAOMYSQL implements ProveedorInterface {

	@Override
	public ArrayList<Proveedor> listado() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.proveedor where estado = 1 ;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Proveedor p = new Proveedor();

				p.setCod_proveedor(rs.getString(1));
			     p.setRazonSocial(rs.getString(2));
			     p.setNombreEmpresa(rs.getString(3));
			     p.setDireccion(rs.getString(4));
			     p.setCorreo(rs.getString(5));
			     p.setPais_proveedor(rs.getInt(6));
			     p.setTipServicio_proveedor(rs.getString(7));
			     p.setFechaAsociacion(rs.getString(8));
			     p.setTelefono(rs.getInt(9));
				
				
		
				
			

				lista.add(p);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO DE PROVEEDOR" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public Proveedor buscar(String codigo) {
		Proveedor p = null;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.proveedor where cod_proveedor = ? ;";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, codigo);
			rs = pstm.executeQuery();

			while (rs.next()) {
			   p = new Proveedor();

				p.setCod_proveedor(rs.getString(1));
			     p.setRazonSocial(rs.getString(2));
			     p.setNombreEmpresa(rs.getString(3));
			     p.setDireccion(rs.getString(4));
			     p.setCorreo(rs.getString(5));
			     p.setPais_proveedor(rs.getInt(6));
			     p.setTipServicio_proveedor(rs.getString(7));
			     p.setFechaAsociacion(rs.getString(8));
			     p.setTelefono(rs.getInt(9));
				

			}
		} catch (Exception e) {
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - BUSCAR PROVEEDOR " + e.getMessage());
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
		return p;
	}
	
	

	@Override
	public int registrar(Proveedor p) {
	    
		int rs = 0; // valor x default en caso de error

		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into proveedor values(?,?,?,?, ?,?,?,?,? ,default);";
			pst = con.prepareStatement(sql);

			
			
			 pst.setString(1 , p.getCod_proveedor());
			 pst.setString(2 , p.getRazonSocial());
			 pst.setString(3 , p.getNombreEmpresa());
			 pst.setString(4 , p.getDireccion());
			 pst.setString(5 , p.getCorreo());
			 pst.setInt(6 , p.getPais_proveedor());
			 pst.setString(7 , p.getTipServicio_proveedor());
			 pst.setString(8 , p.getFechaAsociacion());
			 pst.setInt(9 , p.getTelefono());

			 
		   
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el registrar Proveedor: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
		
		
	}

	@Override
	public int actualizar(Proveedor p) {
		int res = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql =" update proveedor set razonSocial_proveedor =  ?, \r\n"
					+ "                     nombreEmpresa_proveedor = ?, \r\n"
					+ "                     direccionEmpresa_proveedor =  ?  , \r\n"
					+ "                     email_proveedor = ?,\r\n"
					+ "                     pais_proveedor = ?,\r\n"
					+ "                     tipServicio_proveedor = ?,\r\n"
					+ "                     fechaAsociacion_proveedor = ? ,\r\n"
					+ "                     telf_proveedor = ? where cod_proveedor = ?;   ";
			pst = con.prepareStatement(sql);
	
			//PASO 4: PARAMETROS
			
	

			 pst.setString(1 , p.getRazonSocial());
			 pst.setString(2 , p.getNombreEmpresa());
			 pst.setString(3 , p.getDireccion());
			 pst.setString(4 , p.getCorreo());
			 pst.setInt(5 ,p.getPais_proveedor());
			 pst.setString(6 , p.getTipServicio_proveedor());
			 pst.setString(7 , p.getFechaAsociacion());
			 pst.setInt(8 , p.getTelefono());
			 pst.setString(9 , p.getCod_proveedor());
			
			//PASO 5: EJECUTAR LA INSTRUCCION
			res = pst.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar Proveedor" + e.getMessage());
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
	public int eliminar(Proveedor p) {
		int rs = 0; // valor x default en caso de error

		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update proveedor set estado = 2  where cod_proveedor = ? ; ";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getCod_proveedor());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en desactivar : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	
	
}
