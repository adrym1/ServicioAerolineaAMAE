package interfaces;

import java.util.ArrayList;

import model.ReporteVuelo;

public interface ReporteVueloInterface {
	public ArrayList<ReporteVuelo> listado();
	public ArrayList<ReporteVuelo> buscarxFecha (String Fecha1, String Fecha2);
}
