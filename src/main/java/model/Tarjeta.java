package model;

public class Tarjeta {
	public String marca, numero, tipo, cvv, tutor, dni;
	public int codTarjeta;
	
	
	@Override
	public String toString() {
		return "Tarjeta [marca=" + marca + ", numero=" + numero + ", tipo=" + tipo + ", cvv=" + cvv + ", tutor=" + tutor
				+ ", dni=" + dni + ", codTarjeta=" + codTarjeta + "]";
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getCodTarjeta() {
		return codTarjeta;
	}
	public void setCodTarjeta(int codTarjeta) {
		this.codTarjeta = codTarjeta;
	}
	
	
}
