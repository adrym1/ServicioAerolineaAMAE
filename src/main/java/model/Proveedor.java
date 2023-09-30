package model;

public class Proveedor {
   
	
	private String cod_proveedor ; 
	private String razonSocial;  	
	private String nombreEmpresa; 
	private String direccion ;
	private String correo; 
	private int pais_proveedor ;
	private String tipServicio_proveedor ;
	private String fechaAsociacion; 
	private int telefono ;
	private int estado ;
	@Override
	public String toString() {
		return "Proveedor [cod_proveedor=" + cod_proveedor + ", razonSocial=" + razonSocial + ", nombreEmpresa="
				+ nombreEmpresa + ", direccion=" + direccion + ", correo=" + correo + ", pais_proveedor="
				+ pais_proveedor + ", tipServicio_proveedor=" + tipServicio_proveedor + ", fechaAsociacion="
				+ fechaAsociacion + ", telefono=" + telefono + ", estado=" + estado + "]";
	}
	public String getCod_proveedor() {
		return cod_proveedor;
	}
	public void setCod_proveedor(String cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getPais_proveedor() {
		return pais_proveedor;
	}
	public void setPais_proveedor(int pais_proveedor) {
		this.pais_proveedor = pais_proveedor;
	}
	public String getTipServicio_proveedor() {
		return tipServicio_proveedor;
	}
	public void setTipServicio_proveedor(String tipServicio_proveedor) {
		this.tipServicio_proveedor = tipServicio_proveedor;
	}
	public String getFechaAsociacion() {
		return fechaAsociacion;
	}
	public void setFechaAsociacion(String fechaAsociacion) {
		this.fechaAsociacion = fechaAsociacion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
