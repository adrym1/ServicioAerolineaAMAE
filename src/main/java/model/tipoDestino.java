package model;

public class tipoDestino {
 private int cod_destino;
 private String desc_destino;
@Override
public String toString() {
	return "tipoDestino [cod_destino=" + cod_destino + ", desc_destino=" + desc_destino + "]";
}
public int getCod_destino() {
	return cod_destino;
}
public void setCod_destino(int cod_destino) {
	this.cod_destino = cod_destino;
}
public String getDesc_destino() {
	return desc_destino;
}
public void setDesc_destino(String desc_destino) {
	this.desc_destino = desc_destino;
}
 
 
}
