package br.com.shinobi.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.dto.RequestRendaFixa;
import br.com.shinobi.ir.model.RendaFixa;
import br.com.shinobi.ir.repository.RendaFixaRepository;

@Controller
@RequestMapping("rendaFixa")
public class RendaFixaController {

	@Autowired
	private RendaFixaRepository rfRepo;
	
	@GetMapping("admin")
	public String admin(Model modelo) {
		
		Iterable<RendaFixa> list = rfRepo.findAll();
		
		modelo.addAttribute("list", list);
		
		return "rendaFixa/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(RequestRendaFixa dados) {
		
		return "rendaFixa/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(RequestRendaFixa dados) {
		
		RendaFixa rf = new RendaFixa();
		rf.toRendaFixa(dados);
		
		rfRepo.save(rf);
		
		return "rendaFixa/admin";
	}
}
