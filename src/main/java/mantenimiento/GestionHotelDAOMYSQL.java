package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.HotelInterface;
import model.Hotel;
import model.Pais;
import utils.MySQLConexion;

public class GestionHotelDAOMYSQL implements HotelInterface {

	@Override
	public ArrayList<Hotel> listadoHotel() {
		ArrayList<Hotel> lista = new ArrayList<>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Hotel ho = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM hotel";
			pst = con.prepareStatement(sql);

			res = pst.executeQuery();

			while (res.next()) {
				ho = new Hotel();
				ho.setCodHotel(res.getInt(1));
				ho.setNombre(res.getString(2));
				ho.setRuc(res.getString(3));
				ho.setCantCuartos(res.getInt(4));
				ho.setEstado(res.getInt(5));
				lista.add(ho);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO HOTELES " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ArrayList<Hotel> listadoHotelDisponibles() {
		ArrayList<Hotel> lista = new ArrayList<>();
		// PLANTILLA DE BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Hotel ho = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM hotel where id_estado != 2";
			pst = con.prepareStatement(sql);

			res = pst.executeQuery();

			while (res.next()) {
				ho = new Hotel();
				ho.setCodHotel(res.getInt(1));
				ho.setNombre(res.getString(2));
				ho.setRuc(res.getString(3));
				ho.setCantCuartos(res.getInt(4));
				ho.setEstado(res.getInt(5));
				lista.add(ho);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN EL LISTADO HOTELES DISPONIBLES" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public Hotel obtenerHotel(String codigo) {
		// PLANTILLA DE BD
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet res = null;
				Hotel ho = null;
				try {
					con = MySQLConexion.getConexion();
					String sql = "SELECT * FROM hotel where cod_hotel = ?";
					pst = con.prepareStatement(sql);
					pst.setString(1, codigo);
					res = pst.executeQuery();

					if (res.next()) {
						ho = new Hotel();
						ho.setCodHotel(res.getInt(1));
						ho.setNombre(res.getString(2));
						ho.setRuc(res.getString(3));
						ho.setCantCuartos(res.getInt(4));
						ho.setEstado(res.getInt(5));
						
					}

				} catch (Exception e) {
					System.out.println("ERROR EN EL OBTENER EL HOTEL " + e.getMessage());
				} finally {
					MySQLConexion.closeConexion(con);
				}

				return ho;
	}
}
