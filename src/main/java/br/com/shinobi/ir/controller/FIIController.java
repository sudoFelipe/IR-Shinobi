package br.com.shinobi.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.repository.FIIRepository;

@Controller
@RequestMapping("fii")
public class FIIController {

	@Autowired
	private FIIRepository fiiRepo;
	
	@GetMapping("admin")
	public String fii() {
		
		return "fii/admin";
	}
	
	@GetMapping("cadastro")
	public String fiiCadastro() {
		
		return "fii/cadastro";
	}
	
	@PostMapping("registro")
	public String fiiRegistro() {
		
		return "fii/cadastro";
	}
}
