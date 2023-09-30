package interfaces;

import java.util.ArrayList;

import model.Cliente;

import model.GeneroCliente;
import model.TipoCliente;
import model.TipoDocumento;
//!----------------ARIEL - ABNER
public interface ClienteInterface {
	ArrayList<Cliente> listado();

	public Cliente buscar(String codigo);
	
	public int registrar(Cliente c);
	
	public int actualizar(Cliente c);
	
	public int eliminar (Cliente c);
	
	public int activar(Cliente c) ;
	ArrayList<Cliente> listadoClientesInactivos();

	ArrayList<GeneroCliente> listadoGenero();


	ArrayList<TipoDocumento> listadoTipoDocumento();

	ArrayList<TipoCliente> listadoTipoCliente();
}
