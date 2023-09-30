package model;

public class GeneroCliente {
 
	private int idGenero;
	private String descrip;
	@Override
	public String toString() {
		return "GeneroCliente [idGenero=" + idGenero + ", descrip=" + descrip + "]";
	}
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	
	
	
	
	
}


