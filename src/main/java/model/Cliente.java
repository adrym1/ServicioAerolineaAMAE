package model;

public class Cliente {
 
	private String codCli ;
	private String nombCli ; 
	private String apeCli ; 
	private String correoCli ; 
	private String nacionalCli ; 
	private int paisCli ; 
	private String direCli ; 
	private String codPostalCli ; 
	private int telefCli ; 
	private int tipoDocCli ; 
	private String numDocCli ; 
	private int sexoCli ; 
	private int tipoClie ; 
	private String fechaAso ;
	@Override
	public String toString() {
		return "ClienteDAO [codCli=" + codCli + ", nombCli=" + nombCli + ", apeCli=" + apeCli + ", correoCli="
				+ correoCli + ", nacionalCli=" + nacionalCli + ", paisCli=" + paisCli + ", direCli=" + direCli
				+ ", codPostalCli=" + codPostalCli + ", telefCli=" + telefCli + ", tipoDocCli=" + tipoDocCli
				+ ", numDocCli=" + numDocCli + ", sexoCli=" + sexoCli + ", tipoClie=" + tipoClie + ", fechaAso="
				+ fechaAso + "]";
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
	public String getApeCli() {
		return apeCli;
	}
	public void setApeCli(String apeCli) {
		this.apeCli = apeCli;
	}
	public String getCorreoCli() {
		return correoCli;
	}
	public void setCorreoCli(String correoCli) {
		this.correoCli = correoCli;
	}
	public String getNacionalCli() {
		return nacionalCli;
	}
	public void setNacionalCli(String nacionalCli) {
		this.nacionalCli = nacionalCli;
	}
	public int getPaisCli() {
		return paisCli;
	}
	public void setPaisCli(int paisCli) {
		this.paisCli = paisCli;
	}
	public String getDireCli() {
		return direCli;
	}
	public void setDireCli(String direCli) {
		this.direCli = direCli;
	}
	public String getCodPostalCli() {
		return codPostalCli;
	}
	public void setCodPostalCli(String codPostalCli) {
		this.codPostalCli = codPostalCli;
	}
	public int getTelefCli() {
		return telefCli;
	}
	public void setTelefCli(int telefCli) {
		this.telefCli = telefCli;
	}
	public int getTipoDocCli() {
		return tipoDocCli;
	}
	public void setTipoDocCli(int tipoDocCli) {
		this.tipoDocCli = tipoDocCli;
	}
	public String getNumDocCli() {
		return numDocCli;
	}
	public void setNumDocCli(String numDocCli) {
		this.numDocCli = numDocCli;
	}
	public int getSexoCli() {
		return sexoCli;
	}
	public void setSexoCli(int sexoCli) {
		this.sexoCli = sexoCli;
	}
	public int getTipoClie() {
		return tipoClie;
	}
	public void setTipoClie(int tipoClie) {
		this.tipoClie = tipoClie;
	}
	public String getFechaAso() {
		return fechaAso;
	}
	public void setFechaAso(String fechaAso) {
		this.fechaAso = fechaAso;
	}

	
	
	 
}
