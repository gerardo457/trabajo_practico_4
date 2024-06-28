package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String codigo;
	private String nombre;
	private String curso;
    private int canthoras;
	private boolean modalidad;
	@Autowired
	private Docente docente;
	@Autowired
    private Carrera carrera;

 public Materia(){
	 
 }

 public Materia(String codigo, String nombre, String curso, int canthoras, boolean modalidad, Docente docente,
	            Carrera carrera) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.canthoras = canthoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String código) {
	this.codigo = código;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCurso() {
	return curso;
}

public void setCurso(String curso) {
	this.curso = curso;
}

public int getCanthoras() {
	return canthoras;
}

public void setCanthoras(int canthoras) {
	this.canthoras = canthoras;
}

public boolean isModalidad() {
	return modalidad;
}

public void setModalidad(boolean modalidad) {
	this.modalidad = modalidad;
}

public Docente getDocente() {
	return docente;
}

public void setDocente(Docente docente) {
	this.docente = docente;
}

public Carrera getCarrera() {
	return carrera;
}

public void setCarrera(Carrera carrera) {
	this.carrera = carrera;
}
	
 
	
 
}
