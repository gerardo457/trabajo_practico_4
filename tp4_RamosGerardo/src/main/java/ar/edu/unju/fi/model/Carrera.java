package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private String código; 
	private String nombre;
	private int cantaños;
	private String estado;

public Carrera() {
	
}

public Carrera(String código, String nombre, int cantaños, String estado) {
	this.código = código;
	this.nombre = nombre;
	this.cantaños = cantaños;
	this.estado = estado;
}

public String getCódigo() {
	return código;
}

public void setCódigo(String código) {
	this.código = código;
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

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

}
