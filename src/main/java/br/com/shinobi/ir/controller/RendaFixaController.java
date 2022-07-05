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

import br.com.shinobi.ir.dto.RequestRendaFixa;
import br.com.shinobi.ir.enums.EnumMovimentacao;
import br.com.shinobi.ir.model.RendaFixa;
import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.RendaFixaRepository;
import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
@RequestMapping("rendaFixa")
public class RendaFixaController {

	@Autowired
	private RendaFixaRepository rfRepo;
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	@GetMapping("admin")
	public String admin(Model modelo, Principal principal) {
		
		Sort ordenacao = Sort.by("dataMovimentacao").descending();
		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
		
		Iterable<RendaFixa> list = rfRepo.findAllByUsuario(principal.getName(), paginacao);
		
		modelo.addAttribute("list", list);
		
		return "rendaFixa/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(Model modelo, RequestRendaFixa dados) {
		
		modelo.addAttribute("movimentacoes", EnumMovimentacao.values());
		
		return "rendaFixa/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(Model modelo, @Valid RequestRendaFixa dados, BindingResult resultado) {
		
		RendaFixa rf = new RendaFixa();
		
		if (resultado.hasErrors()) {
			
			modelo.addAttribute("movimentacoes", EnumMovimentacao.values());
			
			return "rendaFixa/cadastro";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Usuario usu = usuRepo.findByUsername(username);
		
		rf.toRendaFixa(dados);
		rf.setUser(usu);
		
		rfRepo.save(rf);
		
		return "redirect:/rendaFixa/admin";
	}
}
