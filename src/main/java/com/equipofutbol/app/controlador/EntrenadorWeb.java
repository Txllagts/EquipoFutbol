package com.equipofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.equipofutbol.app.entidades.Entrenador;
import com.equipofutbol.app.repositorio.EntrenadorRepositorio;

@Controller
public class EntrenadorWeb {
	@Autowired
	EntrenadorRepositorio entrenadorrepositorio;
	
	@GetMapping("/verentrenadores")
	public String mostrarEntrenadores(Model model) {
        List<Entrenador> listaEntrenadores = entrenadorrepositorio.findAll();
        model.addAttribute("listaEntrenadores", listaEntrenadores);
        return "verentrenadores"; 
    }
	
	@GetMapping("/ingresarentrenador")
	public String mostrarFormulario(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "ingresarentrenador";
    }
	
	@PostMapping("/guardarentrenador")
    public String guardarEntrenador(Entrenador entrenador) {
        entrenadorrepositorio.save(entrenador);
        return "redirect:/verentrenadores";
    }
	
	@GetMapping("/editarentrenador/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Entrenador entrenador = entrenadorrepositorio.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        model.addAttribute("entrenador", entrenador);
        return "editarentrenador"; 
    }
	
	@PostMapping("/actualizarentrenador")
    public String actualizarEntrenador(@ModelAttribute Entrenador entrenador) {
        entrenadorrepositorio.save(entrenador);
        return "redirect:/verentrenadores"; 
    }
	
	@GetMapping("/eliminarentrenador/{id}")
    public String eliminarEntrenador(@PathVariable Long id) {
        entrenadorrepositorio.deleteById(id);
        return "redirect:/verentrenadores";
    }
}
