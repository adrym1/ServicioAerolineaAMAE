package interfaces;

import java.util.ArrayList;

import model.Destino;
import model.tipoDestino;
//!----------------ARIEL - ABNER
public interface DestinoInterface {
	public Destino buscar(int cod);
	public ArrayList<Destino> listarDestinos();
	public ArrayList<Destino> BuscarDestino (String desc);
	public ArrayList<tipoDestino> listarTipoDestinos();
}
