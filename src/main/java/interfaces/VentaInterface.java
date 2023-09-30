package interfaces;

import java.util.ArrayList;

import model.CheckIn;
import model.Persona;
import model.Tarjeta;
import model.VentaCabezera;
import model.Vuelo;

public interface VentaInterface {
	public int obtenerCod();
	public int realizarVenta(VentaCabezera cabe, ArrayList<Persona> personas,Tarjeta ta, Vuelo ida, Vuelo vuelta);
	public CheckIn obtenerCheckIn(int codVenta, String fecha, String dni);
	public int realizarCheckIn(int codVenta, String fecha, String dni);
}
