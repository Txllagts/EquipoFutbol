package com.equipofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.equipofutbol.app.entidades.Asociacion;
import com.equipofutbol.app.entidades.Club;
import com.equipofutbol.app.entidades.Competicion;
import com.equipofutbol.app.entidades.Entrenador;
import com.equipofutbol.app.repositorio.AsociacionRepositorio;
import com.equipofutbol.app.repositorio.ClubRepositorio;
import com.equipofutbol.app.repositorio.CompeticionRepositorio;
import com.equipofutbol.app.repositorio.EntrenadorRepositorio;

@Controller
public class ClubWeb {
	@Autowired
	ClubRepositorio clubrepositorio;
	
	@Autowired
	EntrenadorRepositorio entrenadorrepositorio;
	
	@Autowired
	AsociacionRepositorio asociacionrepositorio;
	
	@Autowired
	CompeticionRepositorio competicionrepositorio;
	
	@GetMapping("/verclubes")
	public String mostrarClubes(Model model) {
        List<Club> listaClubes = clubrepositorio.findAll();
        model.addAttribute("listaClubes", listaClubes);
        return "verclubes"; 
    }
	
	@GetMapping("/ingresarclub")
	public String mostrarFormulario(Model model) {
	    model.addAttribute("club", new Club());
	    List<Entrenador> entrenadores = entrenadorrepositorio.findAll();
	    List<Asociacion> asociaciones = asociacionrepositorio.findAll();
	    List<Competicion> competiciones = competicionrepositorio.findAll();

	    model.addAttribute("entrenadores", entrenadores);
	    model.addAttribute("asociaciones", asociaciones);
	    model.addAttribute("competiciones", competiciones);

	    return "ingresarclub";
	}
	
	@PostMapping("/guardarclub")
    public String guardarClub(Club club) {
        clubrepositorio.save(club);
        return "redirect:/verclubes";
    }
	
	@GetMapping("/editarclub/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Club club = clubrepositorio.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        model.addAttribute("club", club);
        
        List<Entrenador> entrenadores = entrenadorrepositorio.findAll();
	    List<Asociacion> asociaciones = asociacionrepositorio.findAll();
	    List<Competicion> competiciones = competicionrepositorio.findAll();

	    model.addAttribute("entrenadores", entrenadores);
	    model.addAttribute("asociaciones", asociaciones);
	    model.addAttribute("competiciones", competiciones);
        return "editarclub"; 
    }
	
	@PostMapping("/actualizarclub")
    public String actualizarClub(@ModelAttribute Club club) {
        clubrepositorio.save(club);
        return "redirect:/verclubes"; 
    }
	
	@GetMapping("/eliminarclub/{id}")
    public String eliminarClub(@PathVariable Long id) {
        clubrepositorio.deleteById(id);
        return "redirect:/verclubes";
    }
	
	
}
