package br.com.shinobi.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.dto.RequestFII;
import br.com.shinobi.ir.model.FII;
import br.com.shinobi.ir.repository.FIIRepository;

@Controller
@RequestMapping("fii")
public class FIIController {

	@Autowired
	private FIIRepository fiiRepo;
	
	@GetMapping("admin")
	public String fii(Model modelo) {
		
		Iterable<FII> list = fiiRepo.findAll();
		
		modelo.addAttribute("list", list);
		
		return "fii/admin";
	}
	
	@GetMapping("cadastro")
	public String fiiCadastro(RequestFII dados) {
		
		return "fii/cadastro";
	}
	
	@PostMapping("registro")
	public String fiiRegistro(RequestFII dados) {
		
		FII fii = new FII();
		fii.toFII(dados);
		
		fiiRepo.save(fii);
		
		return "fii/admin";
	}
}
