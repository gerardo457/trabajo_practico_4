package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private String codigo; 
	private String nombre;
	private int cantaños;
	private boolean estado;

public Carrera() {
	
}

public Carrera(String codigo, String nombre, int cantaños, boolean estado) {
	this.codigo = codigo;
	this.nombre = nombre;
	this.cantaños = cantaños;
	this.estado = estado;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getCantaños() {
	return cantaños;
}

public void setCantaños(int cantaños) {
	this.cantaños = cantaños;
}

public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}


}
