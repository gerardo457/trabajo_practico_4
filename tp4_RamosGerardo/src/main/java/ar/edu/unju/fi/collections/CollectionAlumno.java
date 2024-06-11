package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Alumno;

public class CollectionAlumno {
   
   
	public static List<Alumno> alumnos= new ArrayList<Alumno>();
	
	public static List<Alumno> getAlumnos(){
		if(alumnos. isEmpty()) {
			alumnos.add(new Alumno(44857346,"Pedro"," Ramos", "pedro@gmail.com", 552345, LocalDate.parse("2001-04-23"), "wafawf", "7632"));
			alumnos.add(new Alumno(44857346,"Gerardo"," Ramos", "g3rard0ram0s457@gmail.com", 5555555, LocalDate.parse("2003-07-31"), "josedelaiglesia", "7643"));
		}
		return alumnos;	
	}
	
	public static boolean agregaralumno(Alumno alumno) {
		return alumnos.add(alumno) ? true : false;
	}
	
	public static void eliminaralumno(String lu) {
		Iterator<Alumno> iterator= alumnos.iterator();
		while (iterator.hasNext()) {
		   if( lu.compareTo(iterator.next().getLU())==0) {
			   iterator.remove();
		   }
		}
	}
	
	public static void modificar(Alumno alumno) {
		  for (Alumno alu : alumnos) {
			 if(alumno.getLU().compareTo(alu.getLU())==0) {
				 alu.setNombre(alumno.getNombre());
			     alu.setApellido(alumno.getApellido());
			     alu.setDomicilio(alumno.getDomicilio());
			     alu.setFechanacimiento(alumno.getFechanacimiento());
			     alu.setEmail(alumno.getEmail());
			     alu.setTel(alumno.getTel());
			 }else {
				 System.out.println("no se encuentra");
			 }
	      }
		
	}
	
	public static Alumno buscar(String lu) {
		Predicate<Alumno> filterCodigo = c -> c.getLU().compareTo(lu)==0;
		Optional<Alumno> alumno = alumnos.stream().filter(filterCodigo).findFirst();
		if (alumno.isPresent()) {
			return alumno.get();
		}else{ 
			return null;
		}	 
	  }
}
