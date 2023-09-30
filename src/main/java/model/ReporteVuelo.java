package model;

public class ReporteVuelo {
	private String codigo;
	private String piloto;
	private String copiloto;
	private double precio;
	private String hora;
	private String fecha_Salida;
	private String fecha_Llegada;
	@Override
	public String toString() {
		return "ReporteVuelo [codigo=" + codigo + ", piloto=" + piloto + ", copiloto=" + copiloto + ", precio=" + precio
				+ ", hora=" + hora + ", fecha_Salida=" + fecha_Salida + ", fecha_Llegada=" + fecha_Llegada + "]";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public String getCopiloto() {
		return copiloto;
	}
	public void setCopiloto(String copiloto) {
		this.copiloto = copiloto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha_Salida() {
		return fecha_Salida;
	}
	public void setFecha_Salida(String fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}
	public String getFecha_Llegada() {
		return fecha_Llegada;
	}
	public void setFecha_Llegada(String fecha_Llegada) {
		this.fecha_Llegada = fecha_Llegada;
	}
	
}
