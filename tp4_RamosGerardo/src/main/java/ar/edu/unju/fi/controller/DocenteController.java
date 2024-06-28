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

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
@Autowired
private Docente docente;

	@GetMapping("/listado")
	public String getdocentespage(Model model) {
		model.addAttribute("docente",CollectionDocente.getDocentes());
		model.addAttribute("titulo", "Docentes");
		model.addAttribute("exito",false);
		model.addAttribute("mensaje","");
		return "docente";
	}
	
	@GetMapping("/nuevo")
	public String getnuevodocente(Model model) {
		boolean edicion = false;
		model.addAttribute("docenteedit", docente);
	    model.addAttribute("edicion", edicion);
	    model.addAttribute("titulo","Nuevo docente");
	    return "DocenteNewMod";
	}
	 
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docenteedit") Docente docente) {
		ModelAndView modelView = new ModelAndView("docente");
		
		String mensaje;
		boolean exito= CollectionDocente.agregardocente(docente);
		if(exito) {
			mensaje="El docente se guardo correctamente";
		}else {
			mensaje="ERROR, el docente no se guardo correctamente";
		}
		modelView.addObject("exito",exito);
		modelView.addObject("mensaje",mensaje);
		modelView.addObject("docente", CollectionDocente.getDocentes());
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarDocentePage(Model model, @PathVariable(value="legajo")Integer legajo) {
		Docente docenteEncontrado = new Docente();
		boolean edicion = true;
		docenteEncontrado = CollectionDocente.buscar(legajo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docenteedit", docenteEncontrado);
		model.addAttribute("titulo", "Modificar Docente");
		return "DocenteNewMod";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docenteedit") Docente docente, Model model) {
		boolean exito = false;
		String mensaje ="";
		try {
			  CollectionDocente.modificar(docente);
			  mensaje = "el docente con el legajo " + docente.getLegajo() +" fue modificado con exito";
			  exito = true;
		}catch (Exception e) {
			  mensaje = e.getMessage();
			  e.printStackTrace();
		}
		//CollectionDocente.modificar(docente);
		
		model.addAttribute("docente", CollectionDocente.getDocentes());
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("exito", exito);
		model.addAttribute("titulo", "Docentes");
		
		return "docente";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") Integer legajo) {
		CollectionDocente.eliminardocente(legajo);
		return "redirect:/docente/listado";
	}
	
}
