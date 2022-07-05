package br.com.shinobi.ir.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.dto.RequestAcao;
import br.com.shinobi.ir.model.Acao;
import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.AcaoRepository;
import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
@RequestMapping("acao")
public class AcaoController {

	@Autowired
	private AcaoRepository acaoRepo;
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	@GetMapping("admin")
	public String admin(Model modelo, Principal principal) {
		
		Sort ordenacao = Sort.by("dataMovimentacao").descending();
		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
		
		Iterable<Acao> lsAcoes = acaoRepo.findAllByUsuario(principal.getName(), paginacao);
		
		modelo.addAttribute("list", lsAcoes);
		
		return "acao/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(Model modelo, RequestAcao dados) {
		
		Acao acao = new Acao();
		
		modelo.addAttribute("movimentacoes", acao.getMovimentacoes());
		
		return "acao/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(Model modelo, @Valid RequestAcao dados, BindingResult resultado) {
		
		if (resultado.hasErrors()) {
			
			Acao acao = new Acao();
			
			modelo.addAttribute("movimentacoes", acao.getMovimentacoes());
			
			return "acao/cadastro";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Usuario usu = usuRepo.findByUsername(username);
		
		Acao acao = new Acao();
		
		System.out.println(dados);
		
		acao.toAcao(dados);
		acao.setUser(usu);
		
		acaoRepo.save(acao);
		
		return "redirect:/acao/admin";
	}
}
