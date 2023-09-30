package interfaces;
import java.util.ArrayList;
//!----------------ARIEL

import model.usuario;
public interface UsuarioInterface {
	public int registrar(usuario u);
	public int actualizar(usuario u);
	public int eliminar(usuario u);
	public ArrayList<usuario> listado();
	public usuario buscar(String codigo);
	
	public usuario ingresar(String email, String contra);
	
	public ArrayList<usuario> listadoSoloUsuario();
	
	public int actualizarCuenta(String cod, String email, String pass);
	public int actualizarFoto(String cod, String exten);
}
