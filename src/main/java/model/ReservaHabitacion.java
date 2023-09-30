package model;

public class ReservaHabitacion {
	private String numSoli, fechaReserva, fechaIngreso, fechaSalida, tipo;
	private int codHotel, codDes, cantidad;
	
	
	@Override
	public String toString() {
		return "ReservaHabitacion [numSoli=" + numSoli + ", fechaReserva=" + fechaReserva + ", fechaIngreso="
				+ fechaIngreso + ", fechaSalida=" + fechaSalida + ", tipo=" + tipo + ", codHotel=" + codHotel
				+ ", codDes=" + codDes + ", cantidad=" + cantidad + "]";
	}
	public String getNumSoli() {
		return numSoli;
	}
	public void setNumSoli(String numSoli) {
		this.numSoli = numSoli;
	}
	public String getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCodHotel() {
		return codHotel;
	}
	public void setCodHotel(int codHotel) {
		this.codHotel = codHotel;
	}
	public int getCodDes() {
		return codDes;
	}
	public void setCodDes(int codDes) {
		this.codDes = codDes;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
