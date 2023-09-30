package dao;

import interfaces.ClienteInterface;
import interfaces.DestinoInterface;
import interfaces.HotelInterface;
import interfaces.PaisInterfaces;

import interfaces.PersonaInterface;
import interfaces.PromocionInterface;
import interfaces.ProveedorInterface;
import interfaces.ReporteClienteInterface;
import interfaces.ReporteDestinoInterface;
import interfaces.ReporteVueloInterface;
import interfaces.ReservaHabitacionInterface;
import interfaces.TarjetaInterface;
import interfaces.TipoUsuarioInterface;
import interfaces.UsuarioInterface;
import interfaces.VentaInterface;
import interfaces.VueloIntefarce;
import model.Proveedor;
import model.Tarjeta;

public abstract class DAOFactory {
	public static final int MySQL = 1; 
	public static final int SQLSERVER = 2;
	
	//Metodos referenciales o llamado encapsulamiento
	public abstract VueloIntefarce getVueloDAO();
	public abstract DestinoInterface getDestinoDAO();
	public abstract PersonaInterface getPersonaDAO();
	public abstract TarjetaInterface getTarjetaDAO();
	public abstract VentaInterface getVentaDAO();
	public abstract ClienteInterface getClienteDAO();
	public abstract UsuarioInterface getUsuarioDAO();
	public abstract PaisInterfaces getPaisDAO();
	public abstract ReporteClienteInterface getReporteClienteDAO();
	public abstract ReporteDestinoInterface getReporteDestinoDAO();
	public abstract ReporteVueloInterface getReporteVueloDAO();
	public abstract PromocionInterface getPromocionDAO();
	public abstract TipoUsuarioInterface getTipoUsuarioDAO();
	public abstract ProveedorInterface getProveedorDAO();
	public abstract HotelInterface getHotelDAO();
	public abstract ReservaHabitacionInterface getReservaHabitacionDAO();
	
	public static DAOFactory getDaoFactory(int sql) {
		switch (sql) {
		case 1: {
			return new MYSQLDAOFactory();
		}
		case 2:{
			return new SQLSERVERDAOFactory();
		}
		default:
			return null;
		}
	}
}
