package interfaces;

import java.util.ArrayList;

import model.Hotel;

public interface HotelInterface {
	public ArrayList<Hotel> listadoHotel();
	public ArrayList<Hotel> listadoHotelDisponibles();
	public Hotel obtenerHotel(String codigo);
}
