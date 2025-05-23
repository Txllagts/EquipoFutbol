package com.equipofutbol.app.controlador;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexWeb {
	@GetMapping({"/","/index","/menu"})
	public String redirectToHomePage() {
		return "index";
}
}
