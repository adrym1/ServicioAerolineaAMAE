package interfaces;

import model.Tarjeta;

public interface TarjetaInterface {
	public int realizarPago(Tarjeta ta);
	public int obtenerCod();
}
