package model;

public class usuario {
 private String codigo;
 private String usuario;
 private String clave;
 private int tipo;
 private String desc_tipo;
 private int estado;
 private String desc_estado;
 private String extension;

 
@Override
public String toString() {
	return "usuario [codigo=" + codigo + ", usuario=" + usuario + ", clave=" + clave + ", tipo=" + tipo + ", desc_tipo="
			+ desc_tipo + ", estado=" + estado + ", desc_estado=" + desc_estado + ", extension=" + extension + "]";
}
public String getExtension() {
	return extension;
}
public void setExtension(String extension) {
	this.extension = extension;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}
public int getTipo() {
	return tipo;
}
public void setTipo(int tipo) {
	this.tipo = tipo;
}
public String getDesc_tipo() {
	return desc_tipo;
}
public void setDesc_tipo(String desc_tipo) {
	this.desc_tipo = desc_tipo;
}
public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
public String getDesc_estado() {
	return desc_estado;
}
public void setDesc_estado(String desc_estado) {
	this.desc_estado = desc_estado;
}
 
}
