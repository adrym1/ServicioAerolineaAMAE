package model;

public class tipo_usuario {
	private int idTipo;
	private String descripcion;
	
	@Override
	public String toString() {
		return "tipo_usuario [idTipo=" + idTipo + ", descripcion=" + descripcion + "]";
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
