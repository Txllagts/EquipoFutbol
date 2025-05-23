package com.equipofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.equipofutbol.app.entidades.Jugador;
import com.equipofutbol.app.repositorio.JugadorRepositorio;

@Controller
public class JugadorWeb {
	@Autowired
	JugadorRepositorio jugadorrepositorio;
	
	@GetMapping("/verjugadores")
	public String mostrarJugadores(Model model) {
        List<Jugador> listaJugadores = jugadorrepositorio.findAll();
        model.addAttribute("listaJugadores", listaJugadores);
        return "verjugadores"; 
    }
	
	@GetMapping("/ingresarjugador")
	public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "ingresarjugador";
    }
	
	@PostMapping("/guardarjugador")
    public String guardarJugador(Jugador jugador) {
        jugadorrepositorio.save(jugador);
        return "redirect:/verjugadores";
    }
	
	@GetMapping("/editarjugador/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Jugador jugador = jugadorrepositorio.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        model.addAttribute("jugador", jugador);
        return "editarjugador"; 
    }
	
	@PostMapping("/actualizarjugador")
    public String actualizarJugador(@ModelAttribute Jugador jugador) {
        jugadorrepositorio.save(jugador);
        return "redirect:/verjugadores"; 
    }
	
	@GetMapping("/eliminarjugador/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorrepositorio.deleteById(id);
        return "redirect:/verjugadores";
    }

}
