package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
@Autowired
private Alumno alumno;
	
	@GetMapping("/listado")
	 public String getalumnopage(Model model) {
		model.addAttribute("alumno",CollectionAlumno.getAlumnos());
		model.addAttribute("titulo","Alumnos");
		model.addAttribute("exito",false);
		model.addAttribute("mensaje","");
	    return "alumno";
    }
	@GetMapping("/nuevo")
	public String getnuevoalumno(Model model) {
		boolean edicion = false;
		model.addAttribute("alumnoedit",alumno);
	    model.addAttribute("edicion", edicion);
	    model.addAttribute("titulo","Nuevo alumno");
	    return "AlumnoNewMod";
	}
	 
	@PostMapping("/guardar")
	public ModelAndView guardaralumno(@ModelAttribute("alumnoedit") Alumno alumno) {
		ModelAndView modelView = new ModelAndView("alumno");
		String mensaje;
		boolean exito= CollectionAlumno.agregaralumno(alumno);
		if(exito) {
			mensaje="El alumno se guardo correctamente";
		}else {
			mensaje="ERROR, el Alumno no se guardo correctamente";
		}
		modelView.addObject("exito",exito);
		modelView.addObject("mensaje",mensaje);
		modelView.addObject("alumno", CollectionAlumno.getAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificar/{lu}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="lu")String LU) {
	Alumno alumnoEncontrado = new Alumno();
	boolean edicion = true;
	alumnoEncontrado = CollectionAlumno.buscar(LU);
	model.addAttribute("edicion", edicion);
	model.addAttribute("alumnoedit", alumnoEncontrado);
	model.addAttribute("titulo", "Modificar Alumno");
	return "AlumnoNewMod";
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumnoedit") Alumno alumno, Model model){
		String mensaje;
		boolean exito = false;
		try {
			  CollectionAlumno.modificar(alumno);
			  mensaje = "el alumno con el codigo " + alumno.getLU() +" fue modificado con exito";
			  exito = true;
		}catch (Exception e) {
			  mensaje = e.getMessage();
			  e.printStackTrace();
		}
		
		model.addAttribute("alumno", CollectionAlumno.getAlumnos());
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("exito", exito);
		model.addAttribute("titulo", "Alumnos");
		
		return "alumno";
	}
	
	@GetMapping("/eliminar/{lu}")
	public String eliminarAlumno(@PathVariable(value="lu") String LU) {
	CollectionAlumno.eliminaralumno(LU);
	return "redirect:/alumno/listado";
	}
}
