package model;

public class TipoCliente {

	private int idTipoCliente;
	private String descripcion;
	@Override
	public String toString() {
		return "TipoClienteDAO [idTipoCliente=" + idTipoCliente + ", descripcion=" + descripcion + "]";
	}
	public int getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
}
