package model;

public class Pais {

	private int id_Pais ; 

   private String 	nombre ;

@Override
public String toString() {
	return "PaisDAO [id_Pais=" + id_Pais + ", nombre=" + nombre + "]";
}

public int getId_Pais() {
	return id_Pais;
}

public void setId_Pais(int id_Pais) {
	this.id_Pais = id_Pais;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}
   
   
}

