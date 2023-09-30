package interfaces;

import java.util.ArrayList;

import model.ReporteCliente;

public interface ReporteClienteInterface {
	public ArrayList<ReporteCliente> listado();
	public ArrayList<ReporteCliente> listarClienteXFecha(String Fecha1);
	public ArrayList<ReporteCliente> buscar (String nomb);
}
