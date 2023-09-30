package model;

public class VentaDetalle {
	private int codVenta, codPersona;
	private String codIdaVuelo, codVueltaVuelo;
	
	@Override
	public String toString() {
		return "VentaDetalle [codVenta=" + codVenta + ", codPersona=" + codPersona + ", codIdaVuelo=" + codIdaVuelo
				+ ", codVueltaVuelo=" + codVueltaVuelo + "]";
	}
	public int getCodVenta() {
		return codVenta;
	}
	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}
	public int getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(int codPersona) {
		this.codPersona = codPersona;
	}
	public String getCodIdaVuelo() {
		return codIdaVuelo;
	}
	public void setCodIdaVuelo(String codIdaVuelo) {
		this.codIdaVuelo = codIdaVuelo;
	}
	public String getCodVueltaVuelo() {
		return codVueltaVuelo;
	}
	public void setCodVueltaVuelo(String codVueltaVuelo) {
		this.codVueltaVuelo = codVueltaVuelo;
	}
	
	
}
