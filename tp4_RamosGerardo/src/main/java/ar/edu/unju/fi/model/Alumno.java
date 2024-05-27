package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private int tel;
	private LocalDate fechanacimiento;
	private String domicilio;
	private String LU;
}
