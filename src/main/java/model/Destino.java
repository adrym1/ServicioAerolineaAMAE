package model;

public class Destino {
	private int codDestino;
	private String aeropueDes, ciudadDes, paisDes;
	
	@Override
	public String toString() {
		return "Destino [codDestino=" + codDestino + ", aeropueDes=" + aeropueDes + ", ciudadDes=" + ciudadDes
				+ ", paisDes=" + paisDes + "]";
	}
	public int getCodDestino() {
		return codDestino;
	}
	public void setCodDestino(int codDestino) {
		this.codDestino = codDestino;
	}
	public String getAeropueDes() {
		return aeropueDes;
	}
	public void setAeropueDes(String aeropueDes) {
		this.aeropueDes = aeropueDes;
	}
	public String getCiudadDes() {
		return ciudadDes;
	}
	public void setCiudadDes(String ciudadDes) {
		this.ciudadDes = ciudadDes;
	}
	public String getPaisDes() {
		return paisDes;
	}
	public void setPaisDes(String paisDes) {
		this.paisDes = paisDes;
	}
	
	
}
