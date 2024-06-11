package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

public class CollectionMateria {
@Autowired
static Docente docente;
static Carrera carrera;
	
public static List<Materia> materias= new ArrayList<Materia>();
	
	public static List<Materia> getMaterias(){
		if(materias. isEmpty()) {
			materias.add(new Materia("214", "PE", "1a", 46, true, docente, carrera));
			materias.add(new Materia("124", "lso", "1a", 42, true, docente, carrera));
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
	
	public static void modificar(Materia materia) {
		  for (Materia mat : materias) {
			 if(materia.getCodigo().compareTo(mat.getCodigo())==0) {
				 mat.setNombre(materia.getNombre());
				 mat.setCurso(materia.getCurso());
				 mat.setCanthoras(materia.getCanthoras());
				 mat.setModalidad(materia.isModalidad());
			 }else {
				 System.out.println("no se encuentra");
			 }
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
