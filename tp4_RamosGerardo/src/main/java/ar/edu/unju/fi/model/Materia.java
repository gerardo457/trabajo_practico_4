package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String código;
	private String nombre;
	private String curso;
    private int canthoras;
	private boolean modalidad;
	private Docente docente;
    private Carrera carrera;
}
