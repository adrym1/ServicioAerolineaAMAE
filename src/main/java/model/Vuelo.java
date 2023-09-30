package model;

public class Vuelo {
	private int codAvion, codDesSalida, codDesLlegada, estado;
	private String codVuelo, piloto, copiloto, fechaLlegada,fechaSalida, horaVuelo;
	private double precioVuelo;
	
	public Vuelo() {
		
	}
	
	

	@Override
	public String toString() {
		return "Vuelo [codAvion=" + codAvion + ", codDesSalida=" + codDesSalida + ", codDesLlegada=" + codDesLlegada
				+ ", estado=" + estado + ", codVuelo=" + codVuelo + ", piloto=" + piloto + ", copiloto=" + copiloto
				+ ", fechaLlegada=" + fechaLlegada + ", fechaSalida=" + fechaSalida + ", horaVuelo=" + horaVuelo
				+ ", precioVuelo=" + precioVuelo + "]";
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}



	public int getCodAvion() {
		return codAvion;
	}
	public void setCodAvion(int codAvion) {
		this.codAvion = codAvion;
	}
	public int getCodDesSalida() {
		return codDesSalida;
	}
	public void setCodDesSalida(int codDesSalida) {
		this.codDesSalida = codDesSalida;
	}
	public int getCodDesLlegada() {
		return codDesLlegada;
	}
	public void setCodDesLlegada(int codDesLlegada) {
		this.codDesLlegada = codDesLlegada;
	}
	public String getCodVuelo() {
		return codVuelo;
	}
	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
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
	
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getHoraVuelo() {
		return horaVuelo;
	}
	public void setHoraVuelo(String horaVuelo) {
		this.horaVuelo = horaVuelo;
	}
	
	public double getPrecioVuelo() {
		return precioVuelo;
	}
	public void setPrecioVuelo(double precioVuelo) {
		this.precioVuelo = precioVuelo;
	}
	
	
}
