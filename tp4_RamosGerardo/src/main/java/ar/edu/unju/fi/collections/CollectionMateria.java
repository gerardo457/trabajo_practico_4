package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

public class CollectionMateria {

public static List<Materia> materias= new ArrayList<Materia>();
	
	public static List<Materia> getMaterias(){
		
		if(materias.isEmpty()) {
			
			List<Docente> docentes = CollectionDocente.getDocentes();
			List<Carrera> carreras = CollectionCarrera.getCarreras();
			
			materias.add(new Materia("20", "PE", "1año", 60, true, docentes.get(0), carreras.get(0)));
			materias.add(new Materia("25", "LSO", "1año", 40, true, docentes.get(1), carreras.get(0)));
		}
		return materias;	
	}
	
	public static boolean agregarmateria(Materia materia) {
		return materias.add(materia) ? true:false;
	}
	
	public static void eliminarmateria(String codigo) {
		Iterator<Materia> iterator= materias.iterator();
		while (iterator.hasNext()) {
		   if( codigo.compareTo(iterator.next().getCodigo())==0) {
			   iterator.remove();
		   }
		}
	}
	
	public static void modificar(Materia materia) throws Exception {
		try {
			  boolean encontrado=false;
			  
			  for (Materia mat : materias) {
				 if(materia.getCodigo().compareTo(mat.getCodigo())==0) {
					 mat.setNombre(materia.getNombre());
					 mat.setCurso(materia.getCurso());
					 mat.setCanthoras(materia.getCanthoras());
					 mat.setModalidad(materia.isModalidad());
					 mat.setDocente(materia.getDocente());
					 mat.setCarrera(materia.getCarrera());
					 encontrado=true;
				 }
		      }
			    if(encontrado==false) {
			    	throw new Exception("El alumno con el codigo " + materia.getCodigo() + " no existe");
			    }
			  
		}catch (Exception e) {
			System.out.print(e.getMessage());
		    throw e;
		}
		
	}
	
	public static Materia buscar(String codigo) {
		Predicate<Materia> filterCodigo = c -> c.getCodigo().compareTo(codigo)==0;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		if (materia.isPresent()) {
			return materia.get();
		}else{ 
			return null;
		}	 
	  }
	
}
