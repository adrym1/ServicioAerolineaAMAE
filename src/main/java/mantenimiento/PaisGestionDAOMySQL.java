package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.PaisInterfacesDAO;

import model.Pais;

import utils.MySQLConexion;

public class PaisGestionDAOMySQL implements PaisInterfacesDAO {

	@Override
	public ArrayList<Pais> listado() {
		ArrayList<Pais> lista = new ArrayList<Pais>();
		//PLANTILLA DE BD
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				try {
					con = MySQLConexion.getConexion();
					String sql = "SELECT id_Pais , nombre FROM bd_amae.paises;";
				    pst = con.prepareStatement(sql);
					
				    rs = pst.executeQuery();
				    
				while(rs.next()) {
					Pais p = new Pais();
				p.setId_Pais(rs.getInt(1));
				p.setNombre(rs.getString(2));
				
				lista.add(p);
				}
				
				} catch (Exception e) {
					System.out.println("ERROR EN EL LISTADO PAISES " + e.getMessage());
				}finally {
					MySQLConexion.closeConexion(con);
				}
				
				
				return lista;

	
}
}