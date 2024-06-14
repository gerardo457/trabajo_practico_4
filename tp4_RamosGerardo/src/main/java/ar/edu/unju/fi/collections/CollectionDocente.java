package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Docente;


public class CollectionDocente {
public static List<Docente> docentes= new ArrayList<Docente>();
	
	public static List<Docente> getDocentes(){
		if(docentes. isEmpty()) {
			docentes.add (new Docente(1, "Ariel", "Vega", "Vega@gmail.com", 4223379));
			docentes.add(new Docente(2, "Gustavo", "Sosa", "Gustavososa@gmail.com", 4223379));
		}
		return docentes;	
	}
	
	public static boolean agregardocente(Docente docente) {
		return docentes.add(docente) ? true:false;
	}
	
	public static void eliminardocente(int legajo) {
		Iterator<Docente> iterator= docentes.iterator();
		while (iterator.hasNext()) {
		   if( legajo==(iterator.next().getLegajo())) {
			   iterator.remove();
		   }
		}
	}
	
	public static void modificar(Docente docente) {
		  for (Docente doce : docentes) {
			 if(docente.getLegajo()==doce.getLegajo()) {
				 doce.setNombre(docente.getNombre());
				 doce.setApellido(docente.getApellido());
				 doce.setEmail(docente.getEmail());
				 doce.setTel(docente.getTel());
			 }else {
				 System.out.println("no se encuentra");
			 }
	      }
		
	}
	
	 public static Docente buscar(int legajo) {
		Predicate<Docente> filterCodigo = c -> c.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
		if (docente.isPresent()) {
			return docente.get();
		}else{ 
			return null;
		}	 
	  }
}
