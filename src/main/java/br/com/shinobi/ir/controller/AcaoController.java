package br.com.shinobi.ir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.dto.RequestAcao;
import br.com.shinobi.ir.model.Acao;
import br.com.shinobi.ir.repository.AcaoRepository;

@Controller
@RequestMapping("acao")
public class AcaoController {

	@Autowired
	private AcaoRepository acaoRepo;
	
	@GetMapping("admin")
	public String admin(Model modelo) {
		
		Iterable<Acao> lsAcoes = acaoRepo.findAll();
		
		modelo.addAttribute("list", lsAcoes);
		
		return "acao/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(RequestAcao dados) {
		return "acao/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(Model modelo, RequestAcao dados) {
		
		Acao acao = new Acao();
		
		acao.toAcao(dados);
		
		acaoRepo.save(acao);
		
		return "acao/admin";
	}
}
