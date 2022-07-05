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

import br.com.shinobi.ir.dto.RequestTesouroDireto;
import br.com.shinobi.ir.enums.EnumMovimentacao;
import br.com.shinobi.ir.model.TesouroDireto;
import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.TesouroDiretoRepository;
import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
@RequestMapping("tesouro")
public class TesouroDiretoController {

	@Autowired
	private TesouroDiretoRepository tdRepo;
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	@GetMapping("admin")
	public String tesouroDireto(Model modelo, Principal principal) {
		
		Sort ordenacao = Sort.by("dataMovimentacao").descending();
		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
		
		Iterable<TesouroDireto> list = tdRepo.findAllByUsuario(principal.getName(), paginacao);
		
		modelo.addAttribute("list", list);
		
		return "tesouroDireto/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(Model modelo, RequestTesouroDireto dados) {
		
		modelo.addAttribute("movimentacoes", EnumMovimentacao.values());
		
		return "tesouroDireto/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(Model modelo, @Valid RequestTesouroDireto dados, BindingResult resultado) {
		
		TesouroDireto td = new TesouroDireto();
		
		if (resultado.hasErrors()) {
			
			modelo.addAttribute("movimentacoes", EnumMovimentacao.values());
			
			return "tesouroDireto/cadastro";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Usuario usu = usuRepo.findByUsername(username);
		
		td.toTesouroDireto(dados);
		td.setUser(usu);
		
		tdRepo.save(td);
		
		return "redirect:/tesouro/admin";
	}
}
