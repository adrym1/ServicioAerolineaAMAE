package model;

public class Hotel {
	private int codHotel, cantCuartos, estado;
	private String nombre, ruc;
	
	
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Hotel [codHotel=" + codHotel + ", cantCuartos=" + cantCuartos + ", estado=" + estado + ", nombre="
				+ nombre + ", ruc=" + ruc + "]";
	}
	public int getCodHotel() {
		return codHotel;
	}
	public void setCodHotel(int codHotel) {
		this.codHotel = codHotel;
	}
	public int getCantCuartos() {
		return cantCuartos;
	}
	public void setCantCuartos(int cantCuartos) {
		this.cantCuartos = cantCuartos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	
}
