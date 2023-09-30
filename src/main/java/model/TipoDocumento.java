package model;

public class TipoDocumento {

	private int idTipo ;
	private String descrip;
	@Override
	public String toString() {
		return "TipoDocumento [idTipo=" + idTipo + ", descrip=" + descrip + "]";
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	
	
}
