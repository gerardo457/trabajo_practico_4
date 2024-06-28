package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.model.Carrera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
@Autowired
private Carrera carrera;

	@GetMapping("/listado")
	public String getcarreraPage(Model model) {
		model.addAttribute("carrera",CollectionCarrera.getCarreras());
		model.addAttribute("titulo", "Carreras");
		model.addAttribute("exito",false);
		model.addAttribute("mensaje","");
		return "carrera";
	}
	
	@GetMapping("/nuevo")
	public String getnuevacarrera(Model model) {
		boolean edicion = false;
		model.addAttribute("carreras",carrera);
	    model.addAttribute("edicion", edicion);
	    model.addAttribute("titulo","Nueva carrera");
	    return "carreras";
	}
	 
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carreras") Carrera carrera) {
		ModelAndView modelView = new ModelAndView("carrera");
		String mensaje;
		carrera.setEstado(true);
		boolean exito= CollectionCarrera.agregarcarrera(carrera);
		if(exito) {
			mensaje="La carrera se guardo correctamente";
		}else {
			mensaje="ERROR, la carrera no se guardo correctamente";
		}
		modelView.addObject("exito",exito);
		modelView.addObject("mensaje",mensaje);
		modelView.addObject("carrera", CollectionCarrera.getCarreras());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	  public String getModificarCarreraPage(Model model, @PathVariable(value="codigo")String codigo) {
		Carrera carreraEncontrada = new Carrera();
		boolean edicion = true;
		carreraEncontrada = CollectionCarrera.buscar(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("carreras", carreraEncontrada);
		model.addAttribute("titulo", "Modificar Carrera");
		return "carreras";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carreras") Carrera carrera, Model model) {
		String mensaje;
		boolean exito = false;
		try {
			  CollectionCarrera.modificar(carrera);
			  mensaje = "la carrera con el codigo " + carrera.getCodigo() +" fue modificado con exito";
			  exito = true;
		}catch (Exception e) {
			  mensaje = e.getMessage();
			  e.printStackTrace();
		}
		
		model.addAttribute("carrera", CollectionCarrera.getCarreras());
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("exito", exito);
		model.addAttribute("titulo", "Carreras");
		
		return "carrera";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") String codigo) {
		CollectionCarrera.eliminarcarrera(codigo);
		return "redirect:/carrera/listado";
	}
}
