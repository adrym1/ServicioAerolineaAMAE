package model;

public class ReporteDestino {
	private int codigo;
	private String aeropuerto;
	private String ciudad;
	private String pais;
	@Override
	public String toString() {
		return "Destino [codigo=" + codigo + ", aeropuerto=" + aeropuerto + ", ciudad=" + ciudad + ", pais=" + pais
				+ "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(String aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
