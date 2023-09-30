package interfaces;

import java.util.ArrayList;

import model.ReporteDestino;

public interface ReporteDestinoInterface {
	public ArrayList<ReporteDestino> listado();
	public ArrayList<ReporteDestino> BuscarDestino (String desc);
}
