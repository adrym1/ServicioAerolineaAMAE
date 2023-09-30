package interfaces;

import java.util.ArrayList;

import model.Proveedor;





public interface ProveedorInterface {

	ArrayList<Proveedor> listado();

	public Proveedor buscar(String codigo);
	
	public int registrar(Proveedor p);
	
	public int actualizar(Proveedor p);
	
	public int eliminar (Proveedor p);
	
	
}
