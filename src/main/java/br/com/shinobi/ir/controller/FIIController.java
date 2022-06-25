package br.com.shinobi.ir.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String fii(Model modelo, Principal principal) {
		
		Iterable<FII> list = fiiRepo.findAllByUsuario(principal.getName());
		
		modelo.addAttribute("list", list);
		
		return "fii/admin";
	}
	
	@GetMapping("cadastro")
	public String fiiCadastro(Model modelo, RequestFII dados) {
		
		FII fii = new FII();
		
		modelo.addAttribute("movimentacoes", fii.movimentacoes());
		
		return "fii/cadastro";
	}
	
	@PostMapping("registro")
	public String fiiRegistro(Model modelo, @Valid RequestFII dados, BindingResult resultado) {
		
		if (resultado.hasErrors()) {
			
			FII fii = new FII();
			
			modelo.addAttribute("movimentacoes", fii.movimentacoes());
			
			return "fii/cadastro";
		}
		
		FII fii = new FII();
		fii.toFII(dados);
		
		fiiRepo.save(fii);
		
		return "redirect:/fii/admin";
	}
}
