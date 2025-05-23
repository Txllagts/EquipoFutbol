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
import com.equipofutbol.app.repositorio.AsociacionRepositorio;

@Controller
public class AsociacionWeb {
	@Autowired
	AsociacionRepositorio asociacionrepositorio;
	
	@GetMapping("/verasociaciones")
	public String mostrarAsociaciones(Model model) {
        List<Asociacion> listaAsociaciones = asociacionrepositorio.findAll();
        model.addAttribute("listaAsociaciones", listaAsociaciones);
        return "verasociaciones"; 
    }
	
	@GetMapping("/ingresarasociacion")
	public String mostrarFormulario(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "ingresarasociacion";
    }
	
	@PostMapping("/guardarasociacion")
    public String guardarAsociacion(Asociacion asociacion) {
        asociacionrepositorio.save(asociacion);
        return "redirect:/verasociaciones";
    }
	
	@GetMapping("/editarasociacion/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Asociacion asociacion = asociacionrepositorio.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        model.addAttribute("asociacion", asociacion);
        return "editarasociacion"; 
    }
	
	@PostMapping("/actualizarasociacion")
    public String actualizarAsociacion(@ModelAttribute Asociacion asociacion) {
        asociacionrepositorio.save(asociacion);
        return "redirect:/verasociaciones"; 
    }
	
	@GetMapping("/eliminarasociacion/{id}")
    public String eliminarAsociacion(@PathVariable Long id) {
        asociacionrepositorio.deleteById(id);
        return "redirect:/verasociaciones";
    }
}
