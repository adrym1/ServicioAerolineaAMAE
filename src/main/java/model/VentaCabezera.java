package model;

public class VentaCabezera {
	private int codVenta, canti, codTarjeta;
	private String fecha, clave, tipo, checkIn;
	private double precioTotal;
	
	
	
	public int getCodTarjeta() {
		return codTarjeta;
	}
	public void setCodTarjeta(int codTarjeta) {
		this.codTarjeta = codTarjeta;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getCodVenta() {
		return codVenta;
	}
	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}
	public int getCanti() {
		return canti;
	}
	public void setCanti(int canti) {
		this.canti = canti;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}


	
}
