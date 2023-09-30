package model;

public class ReporteCliente {
	private String codCli;
	private String nombCli;
	private String correoCli;
	private String tipoDocCli;
	private String numDocCli;
	private String tipoClie;
	private String fechaAso;
	@Override
	public String toString() {
		return "Cliente [codCli=" + codCli + ", nombCli=" + nombCli + ", correoCli=" + correoCli + ", tipoDocCli="
				+ tipoDocCli + ", numDocCli=" + numDocCli + ", tipoClie=" + tipoClie + ", fechaAso=" + fechaAso + "]";
	}
	public String getCodCli() {
		return codCli;
	}
	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}
	public String getNombCli() {
		return nombCli;
	}
	public void setNombCli(String nombCli) {
		this.nombCli = nombCli;
	}
	public String getCorreoCli() {
		return correoCli;
	}
	public void setCorreoCli(String correoCli) {
		this.correoCli = correoCli;
	}
	public String getTipoDocCli() {
		return tipoDocCli;
	}
	public void setTipoDocCli(String tipoDocCli) {
		this.tipoDocCli = tipoDocCli;
	}
	public String getNumDocCli() {
		return numDocCli;
	}
	public void setNumDocCli(String numDocCli) {
		this.numDocCli = numDocCli;
	}
	public String getTipoClie() {
		return tipoClie;
	}
	public void setTipoClie(String tipoClie) {
		this.tipoClie = tipoClie;
	}
	public String getFechaAso() {
		return fechaAso;
	}
	public void setFechaAso(String fechaAso) {
		this.fechaAso = fechaAso;
	}
	
}
