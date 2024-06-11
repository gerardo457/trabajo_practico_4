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

import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
@Autowired
private Materia materia;
	
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
	    return "MateriaNewMod";
	}
	 
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materiaedit") Materia materia) {
		ModelAndView modelView = new ModelAndView("materia");
		//CollectionMateria.agregarmateria(materia);
		String mensaje;
		boolean exito= CollectionMateria.agregarmateria(materia);
		if(exito) {
			mensaje="La materia se guardo correctamente";
		}else {
			mensaje="ERROR, La materia no se guardo correctamente";
		}
		modelView.addObject("exito",exito);
		modelView.addObject("mensaje",mensaje);
		modelView.addObject("materia", CollectionMateria.getMaterias());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo")String codigo) {
	Materia materiaEncontrada = new Materia();
	boolean edicion = true;
	materiaEncontrada = CollectionMateria.buscar(codigo);
	model.addAttribute("edicion", edicion);
	model.addAttribute("materiaedit", materiaEncontrada);
	model.addAttribute("titulo", "Modificar Materia");
	return "MateriaNewMod";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materiaedit") Materia materia) {
	CollectionMateria.modificar(materia);
	return "redirect:/materia/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") String codigo) {
	CollectionMateria.eliminarmateria(codigo);
	return "redirect:/materia/listado";
	}
}
