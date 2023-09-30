package interfaces;
import model.tipo_usuario;
import java.util.ArrayList;

public interface TipoUsuarioInterface {
	 public ArrayList<tipo_usuario>Listado();
	 public tipo_usuario obtenerTipo(int tipo);
}
