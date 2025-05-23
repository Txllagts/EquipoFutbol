package com.equipofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.equipofutbol.app.entidades.Competicion;
import com.equipofutbol.app.repositorio.CompeticionRepositorio;

@Controller
public class CompeticionWeb {
	@Autowired
	CompeticionRepositorio competicionrepositorio;
	
	@GetMapping("/vercompeticiones")
	public String mostrarCompeticiones(Model model) {
        List<Competicion> listaCompeticiones = competicionrepositorio.findAll();
        model.addAttribute("listaCompeticiones", listaCompeticiones);
        return "vercompeticiones"; 
    }
	
	@GetMapping("/ingresarcompeticion")
	public String mostrarFormulario(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "ingresarcompeticion";
    }
	
	@PostMapping("/guardarcompeticion")
    public String guardarCompeticion(Competicion competicion) {
        competicionrepositorio.save(competicion);
        return "redirect:/vercompeticiones";
    }
	
	@GetMapping("/editarcompeticion/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Competicion competicion = competicionrepositorio.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        model.addAttribute("competicion", competicion);
        return "editarcompeticion"; 
    }
	
	@PostMapping("/actualizarcompeticion")
    public String actualizarCompeticion(@ModelAttribute Competicion competicion) {
        competicionrepositorio.save(competicion);
        return "redirect:/vercompeticiones"; 
    }
	
	@GetMapping("/eliminarcompeticion/{id}")
    public String eliminarCompeticion(@PathVariable Long id) {
        competicionrepositorio.deleteById(id);
        return "redirect:/vercompeticiones";
    }
}
