package interfaces;

import model.Persona;
//!----------------ENZO
public interface PersonaInterface {
	public int obtenerCod(Persona p);
	public int registrarPer(Persona p);
	public int actualizarPer(Persona p);
	public Persona buscar(int cod);
	public int obtenerCod();
}
