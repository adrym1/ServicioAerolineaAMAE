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
import mantenimiento.GestionClienteDAOMYSQL;
import mantenimiento.GestionDestinoDAOMYSQL;
import mantenimiento.GestionHotelDAOMYSQL;
import mantenimiento.GestionPaisDAOMySQL;
import mantenimiento.GestionPersonaDAOMYSQL;
import mantenimiento.GestionPromocionDAOMYSQL;
import mantenimiento.GestionProveedorDAOMYSQL;
import mantenimiento.GestionReporteClienteDAOMYSQL;
import mantenimiento.GestionReporteDestinoDAOMYSQL;
import mantenimiento.GestionReporteVueloDAOMYSQL;
import mantenimiento.GestionReservaHabitacionDAOMYSQL;
import mantenimiento.GestionTarjetaDAOMYSQL;
import mantenimiento.GestionTipoUsuarioDAOMYSQL;
import mantenimiento.GestionUsuarioDAOMYSQL;
import mantenimiento.GestionVentaDAOMYSQL;
import mantenimiento.GestionVueloDAOMYSQL;

public class MYSQLDAOFactory extends DAOFactory {

	@Override
	public VueloIntefarce getVueloDAO() {
		// TODO Auto-generated method stub
		return new GestionVueloDAOMYSQL();
	}

	@Override
	public DestinoInterface getDestinoDAO() {
		// TODO Auto-generated method stub
		return new GestionDestinoDAOMYSQL();
	}

	@Override
	public PersonaInterface getPersonaDAO() {
		// TODO Auto-generated method stub
		return new GestionPersonaDAOMYSQL();
	}

	@Override
	public TarjetaInterface getTarjetaDAO() {
		// TODO Auto-generated method stub
		return new GestionTarjetaDAOMYSQL();
	}

	@Override
	public VentaInterface getVentaDAO() {
		// TODO Auto-generated method stub
		return new GestionVentaDAOMYSQL();
	}

	@Override
	public ClienteInterface getClienteDAO() {
		// TODO Auto-generated method stub
		return new GestionClienteDAOMYSQL();
	}

	@Override
	public UsuarioInterface getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionUsuarioDAOMYSQL();
	}

	@Override
	public PaisInterfaces getPaisDAO() {
		// TODO Auto-generated method stub
		return new GestionPaisDAOMySQL();
	}

	@Override
	public ReporteClienteInterface getReporteClienteDAO() {
		// TODO Auto-generated method stub
		return new GestionReporteClienteDAOMYSQL();
	}

	@Override
	public ReporteDestinoInterface getReporteDestinoDAO() {
		// TODO Auto-generated method stub
		return new GestionReporteDestinoDAOMYSQL();
	}

	@Override
	public ReporteVueloInterface getReporteVueloDAO() {
		// TODO Auto-generated method stub
		return new GestionReporteVueloDAOMYSQL();
	}

	@Override
	public PromocionInterface getPromocionDAO() {
		// TODO Auto-generated method stub
		return new GestionPromocionDAOMYSQL();
	}

	@Override
	public TipoUsuarioInterface getTipoUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionTipoUsuarioDAOMYSQL();
	}

	@Override
	public ProveedorInterface getProveedorDAO() {
		// TODO Auto-generated method stub
		return new GestionProveedorDAOMYSQL();
	}

	@Override
	public HotelInterface getHotelDAO() {
		// TODO Auto-generated method stub
		return new GestionHotelDAOMYSQL();
	}

	@Override
	public ReservaHabitacionInterface getReservaHabitacionDAO() {
		// TODO Auto-generated method stub
		return new GestionReservaHabitacionDAOMYSQL();
	}

}
