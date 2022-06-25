package br.com.shinobi.ir.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping("home")
	public String home(Model modelo, Principal principal) {
		
		Usuario usu = usuarioRepo.findById(principal.getName()).get();
		
		modelo.addAttribute("usuario", usu);
		
		return "home";
	}
}
