package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Carrera;

public class CollectionCarrera {
	
	public static List<Carrera> carreras= new ArrayList<Carrera>();
	
	public static List<Carrera> getCarreras(){
		if(carreras. isEmpty()) {
			carreras.add (new Carrera("1","A.P.U",3, true));
			carreras.add(new Carrera("2", "Ingeniería Informática", 5, true));
			carreras. add (new Carrera("3", "Ingeniería Química", 5, false));
		}
		return carreras;	
	}
	
	public static boolean agregarcarrera(Carrera carrera) {
		return carreras.add(carrera) ? true : false;
	}
	
	public static void eliminarcarrera(String codigo) {
		Iterator<Carrera> iterator= carreras.iterator();
		while (iterator.hasNext()) {
		   if( codigo.compareTo(iterator.next().getCodigo())==0) {
			   iterator.remove();
		   }
		}
	}
	
	public static void modificar(Carrera carrera) throws Exception {
		  boolean encontrado=false;
		  try {
			  for (Carrera carre : carreras) {
				 if(carrera.getCodigo().compareTo((carre.getCodigo()))==0) {
					 carre.setNombre(carrera.getNombre());
					 carre.setCantaños(carrera.getCantaños());
					 carre.setEstado(carrera.isEstado());
					 encontrado=true;
				 }
		      }
			  
			  if(encontrado==false) {
				  throw new Exception("La carrera con el codigo " + carrera.getCodigo() + " no existe");
			  }
		  }catch (Exception e) {
			  System.out.print(e.getMessage());
			  throw e;
		  }
		
	}
	
	public static Carrera buscar(String codigo) {
		Predicate<Carrera> filterCodigo = c -> c.getCodigo().compareTo(codigo)==0;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		if (carrera.isPresent()) {
			return carrera.get();
		}else{ 
			return null;
		}	 
	  }
}
