package interfaces;

import java.util.ArrayList;

import model.Promocion;

public interface PromocionInterface {
	public ArrayList<Promocion> listarPromo();
	
	ArrayList<Promocion> listado();

	public Promocion buscar(int codigo);
	
	public int registrar(Promocion pr);
	
	public int actualizar(Promocion pr);
	
	public int eliminar (Promocion pr);
	
	ArrayList<Promocion> listadoPromocionInactivos();
	
	public int activarActualizar(Promocion pr);

	public Promocion obtenerPromo(String clave);
	
}
