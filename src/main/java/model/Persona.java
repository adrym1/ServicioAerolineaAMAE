package model;

public class Persona {
	private int codPersona, codiPostal,edad, pais;
	private String nombre, apellido, dni, sexo, naciona, domici,estado,carnetVacu;
	
	
	
	
	@Override
	public String toString() {
		return "Persona [codPersona=" + codPersona + ", codiPostal=" + codiPostal + ", edad=" + edad + ", pais=" + pais
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", sexo=" + sexo + ", naciona="
				+ naciona + ", domici=" + domici + ", estado=" + estado + ", carnetVacu=" + carnetVacu + "]";
	}
	public int getPais() {
		return pais;
	}
	public void setPais(int pais) {
		this.pais = pais;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	public int getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(int codPersona) {
		this.codPersona = codPersona;
	}
	public int getCodiPostal() {
		return codiPostal;
	}
	public void setCodiPostal(int codiPostal) {
		this.codiPostal = codiPostal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNaciona() {
		return naciona;
	}
	public void setNaciona(String naciona) {
		this.naciona = naciona;
	}
	public String getDomici() {
		return domici;
	}
	public void setDomici(String domici) {
		this.domici = domici;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCarnetVacu() {
		return carnetVacu;
	}
	public void setCarnetVacu(String carnetVacu) {
		this.carnetVacu = carnetVacu;
	}
	
}
