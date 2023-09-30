package model;

public class Promocion {

	private int cod_promocion ;
	private String clave_promocion ;
	private String titulo_promocion ;
	private String descripcion ;
	private String fechaValida ;
	private String fechaCaducidad;
	private double descuento ;
	private int tipoCliente ;
	private int estado ;
	@Override
	public String toString() {
		return "Promocion [cod_promocion=" + cod_promocion + ", clave_promocion=" + clave_promocion
				+ ", titulo_promocion=" + titulo_promocion + ", descripcion=" + descripcion + ", fechaValida="
				+ fechaValida + ", fechaCaducidad=" + fechaCaducidad + ", descuento=" + descuento + ", tipoCliente="
				+ tipoCliente + ", estado=" + estado + "]";
	}
	public int getCod_promocion() {
		return cod_promocion;
	}
	public void setCod_promocion(int cod_promocion) {
		this.cod_promocion = cod_promocion;
	}
	public String getClave_promocion() {
		return clave_promocion;
	}
	public void setClave_promocion(String clave_promocion) {
		this.clave_promocion = clave_promocion;
	}
	public String getTitulo_promocion() {
		return titulo_promocion;
	}
	public void setTitulo_promocion(String titulo_promocion) {
		this.titulo_promocion = titulo_promocion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaValida() {
		return fechaValida;
	}
	public void setFechaValida(String fechaValida) {
		this.fechaValida = fechaValida;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public int getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
}
