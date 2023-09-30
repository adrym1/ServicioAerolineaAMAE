package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ClienteInterface;

import model.Cliente;
import model.GeneroCliente;
import model.TipoCliente;
import model.TipoDocumento;
import utils.MySQLConexion;

public class GestionClienteDAOMYSQL implements ClienteInterface {

	@Override
	public ArrayList<Cliente> listado() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.cliente where estado = 1;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();

				c.setCodCli(rs.getString(1));
				c.setNombCli(rs.getString(2));
				c.setApeCli(rs.getString(3));
				c.setCorreoCli(rs.getString(4));
				c.setNacionalCli(rs.getString(5));
				c.setPaisCli(rs.getInt(6));
				c.setDireCli(rs.getString(7));
				c.setCodPostalCli(rs.getString(8));
				c.setTelefCli(rs.getInt(9));
				c.setTipoDocCli(rs.getInt(10));
				c.setNumDocCli(rs.getString(11));
				c.setSexoCli(rs.getInt(12));
				c.setTipoClie(rs.getInt(13));
				c.setFechaAso(rs.getString(14));


				lista.add(c);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO DE CLIENTES" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public ArrayList<TipoDocumento> listadoTipoDocumento() {
		ArrayList<TipoDocumento> lista = new ArrayList<TipoDocumento>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tipodocumento;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				TipoDocumento t = new TipoDocumento();
				t.setIdTipo(rs.getInt(1));
				t.setDescrip(rs.getString(2));

				lista.add(t);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO  " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}
	@Override
	public Cliente buscar(String codigo) {
		Cliente c = null;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.cliente where cod_cliente = ? ;";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, codigo);
			rs = pstm.executeQuery();

			while (rs.next()) {
				c = new Cliente();

				c.setCodCli(rs.getString(1));
				c.setNombCli(rs.getString(2));
				c.setApeCli(rs.getString(3));
				c.setCorreoCli(rs.getString(4));
				c.setNacionalCli(rs.getString(5));
				c.setPaisCli(rs.getInt(6));
				c.setDireCli(rs.getString(7));
				c.setCodPostalCli(rs.getString(8));
				c.setTelefCli(rs.getInt(9));
				c.setTipoDocCli(rs.getInt(10));
				c.setNumDocCli(rs.getString(11));
				c.setSexoCli(rs.getInt(12));
				c.setTipoClie(rs.getInt(13));
				c.setFechaAso(rs.getString(14));


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
		return c;
	}


	@Override
	public ArrayList<TipoCliente> listadoTipoCliente() {
		ArrayList<TipoCliente> lista = new ArrayList<TipoCliente>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.tipo_cliente;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				TipoCliente t = new TipoCliente();
				t.setIdTipoCliente(rs.getInt(1));
				t.setDescripcion(rs.getString(2));

				lista.add(t);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public ArrayList<GeneroCliente> listadoGenero() {
		ArrayList<GeneroCliente> lista = new ArrayList<GeneroCliente>();

		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.generocliente;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				GeneroCliente g = new GeneroCliente();
				g.setIdGenero(rs.getInt(1));
				g.setDescrip(rs.getString(2));

				lista.add(g);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public int registrar(Cliente c) {
		int rs = 0; // valor x default en caso de error

		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,1);";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getCodCli());
			pst.setString(2, c.getNombCli());
			pst.setString(3, c.getApeCli());
			pst.setString(4, c.getCorreoCli());
			pst.setString(5, c.getNacionalCli());
			pst.setInt(6, c.getPaisCli());
			pst.setString(7, c.getDireCli());
			pst.setString(8, c.getCodPostalCli());
			pst.setInt(9, c.getTelefCli());
			pst.setInt(10, c.getTipoDocCli());
			pst.setString(11, c.getNumDocCli());
			pst.setInt(12, c.getSexoCli());
			pst.setInt(13, c.getTipoClie());
			pst.setString(14, c.getFechaAso());


			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en el registrar Cliente: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return rs;
	}

	@Override
	public int actualizar(Cliente c) {
		int res = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update cliente set  nombre_cliente = ?,apellido_cliente = ?, email_cliente = ?,  \r\n"
					+ " nacionalidad_cliente = ?   ,pais_cliente = ?   , direccion_cliente = ? , codPostal_cliente = ? , telf_cliente = ? ,\r\n"
					+ "tipDocumento_cliente = ? , numDocumento_cliente = ? , sexo_cliente = ? ,  tipoCliente = ? ,\r\n"
					+ "fechaAsociacion_cliente = ?   \r\n"
					+ " where cod_cliente = ?;";
			pst = con.prepareStatement(sql);
	
			//PASO 4: PARAMETROS
			
	
			pst.setString(1, c.getNombCli());
			pst.setString(2, c.getApeCli());
			pst.setString(3, c.getCorreoCli());
			
			pst.setString(4, c.getNacionalCli());
			pst.setInt(5, c.getPaisCli());
			pst.setString(6, c.getDireCli());
			pst.setString(7, c.getCodPostalCli());
			pst.setInt(8, c.getTelefCli());
			pst.setInt(9, c.getTipoDocCli());
			pst.setString(10, c.getNumDocCli());
			pst.setInt(11, c.getSexoCli());
			pst.setInt(12, c.getTipoClie());
			pst.setString(13, c.getFechaAso());
			pst.setString(14, c.getCodCli());
			
			
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
	public int eliminar(Cliente c) {
		int res = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update cliente set  estado = 2  where cod_cliente = ?;";
			pst = con.prepareStatement(sql);
	
			//PASO 4: PARAMETROS
			
	

			pst.setString(1, c.getCodCli());
			
			
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
	public int activar(Cliente c) {
		int res = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update cliente set  estado = 1  where cod_cliente = ?;";
			pst = con.prepareStatement(sql);
	
			//PASO 4: PARAMETROS
			
	

			pst.setString(1, c.getCodCli());
			
			
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
	public ArrayList<Cliente> listadoClientesInactivos() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM bd_amae.cliente where estado = 2;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();

				c.setCodCli(rs.getString(1));
				c.setNombCli(rs.getString(2));
				c.setApeCli(rs.getString(3));
				c.setCorreoCli(rs.getString(4));
				c.setNacionalCli(rs.getString(5));
				c.setPaisCli(rs.getInt(6));
				c.setDireCli(rs.getString(7));
				c.setCodPostalCli(rs.getString(8));
				c.setTelefCli(rs.getInt(9));
				c.setTipoDocCli(rs.getInt(10));
				c.setNumDocCli(rs.getString(11));
				c.setSexoCli(rs.getInt(12));
				c.setTipoClie(rs.getInt(13));
				c.setFechaAso(rs.getString(14));


				lista.add(c);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO DE CLIENTES" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

}
