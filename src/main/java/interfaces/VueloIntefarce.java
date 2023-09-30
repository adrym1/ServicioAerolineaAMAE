package interfaces;

import java.util.ArrayList;

import model.Vuelo;
//!----------------ARIEL - ENZO
public interface VueloIntefarce {
	public int registrar(Vuelo v);	
	public int actualizar(Vuelo v);	
	public int eliminar (Vuelo v);
	public ArrayList<Vuelo> listadoVuelo();
	public ArrayList<Vuelo> listadoVueloActivos();
	public Vuelo buscar(String cod);
	ArrayList<Vuelo> buscarxFecha(String Fecha1, String Fecha2);
}
