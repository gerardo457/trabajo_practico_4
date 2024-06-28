package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
@Autowired
private Materia materia;
@Autowired
private Carrera carrera;
@Autowired
private Docente docente;
	
	@GetMapping("/listado")
	public String getmateriapage(Model model) {
		model.addAttribute("materia",CollectionMateria.getMaterias());
		model.addAttribute("titulo", "Materias");
		model.addAttribute("exito",false);
		model.addAttribute("mensaje","");
		return "materia";
	}

	@GetMapping("/nuevo")
	public String getnuevamateria(Model model) {
		boolean edicion = false;
		model.addAttribute("materiaedit",materia);
	    model.addAttribute("edicion", edicion);
	    model.addAttribute("titulo","Nueva materia");
	    model.addAttribute("docente", CollectionDocente.getDocentes());
		model.addAttribute("carrera", CollectionCarrera.getCarreras());
	    return "MateriaNewMod";
	}
	 
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materiaedit") Materia materia, Model model) {
		ModelAndView modelView = new ModelAndView("materia");
		
		String mensaje;
		
		docente = CollectionDocente.buscar(materia.getDocente().getLegajo());
		carrera = CollectionCarrera.buscar(materia.getCarrera().getCodigo());
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		
		boolean exito= CollectionMateria.agregarmateria(materia);
		if(exito) {
			mensaje="La materia se guardo correctamente";
		}else {
			mensaje="ERROR, La materia no se guardo correctamente";
		}
		
		model.addAttribute("exito",exito);
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("materia", CollectionMateria.getMaterias());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo")String codigo) {
	Materia materiaEncontrada = new Materia();
	boolean edicion = true;
	materiaEncontrada = CollectionMateria.buscar(codigo);
	model.addAttribute("docente", CollectionDocente.getDocentes());
	model.addAttribute("carrera", CollectionCarrera.getCarreras());
	model.addAttribute("edicion", edicion);
	model.addAttribute("materiaedit", materiaEncontrada);
	model.addAttribute("titulo", "Modificar Materia");
	return "MateriaNewMod";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materiaedit") Materia materia, Model model) {
	
		
    docente = CollectionDocente.buscar(materia.getDocente().getLegajo());
	carrera = CollectionCarrera.buscar(materia.getCarrera().getCodigo());
	materia.setCarrera(carrera);
	materia.setDocente(docente);
	
	String mensaje;
	boolean exito = false;
	
	try {
		  CollectionMateria.modificar(materia);
		  mensaje = "La materia con el codigo " + materia.getCodigo() +" fue modificado con exito";
		  exito = true;
	}catch (Exception e) {
		  mensaje = e.getMessage();
		  e.printStackTrace();
	}
	
	model.addAttribute("materia", CollectionMateria.getMaterias());
	model.addAttribute("mensaje", mensaje);
	model.addAttribute("exito", exito);
	model.addAttribute("titulo", "Materias");
	model.addAttribute("docente", CollectionDocente.getDocentes());
	model.addAttribute("carrera", CollectionCarrera.getCarreras());
	
	return "materia";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") String codigo) {
	CollectionMateria.eliminarmateria(codigo);
	return "redirect:/materia/listado";
	}
}
