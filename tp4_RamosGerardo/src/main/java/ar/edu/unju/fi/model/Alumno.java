package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private String tel;
	private LocalDate fechanacimiento;
	private String domicilio;
	private String LU;

public Alumno() {
	
}

public Alumno(int dni, String nombre, String apellido, String email, String tel, LocalDate fechanacimiento,
		String domicilio, String lU) {
	this.dni = dni;
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
	this.tel = tel;
	this.fechanacimiento = fechanacimiento;
	this.domicilio = domicilio;
	LU = lU;
}

public int getDni() {
	return dni;
}

public void setDni(int dni) {
	this.dni = dni;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public LocalDate getFechanacimiento() {
	return fechanacimiento;
}

public void setFechanacimiento(LocalDate fechanacimiento) {
	this.fechanacimiento = fechanacimiento;
}

public String getDomicilio() {
	return domicilio;
}

public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}

public String getLU() {
	return LU;
}

public void setLU(String lU) {
	LU = lU;
}

}
