package br.com.shinobi.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping("home")
	public String home() {
		
		return "home";
	}
}
