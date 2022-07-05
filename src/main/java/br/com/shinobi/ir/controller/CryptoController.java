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

import br.com.shinobi.ir.dto.RequestCrypto;
import br.com.shinobi.ir.enums.EnumMovimentacao;
import br.com.shinobi.ir.model.Crypto;
import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.CryptoRepository;
import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
@RequestMapping("crypto")
public class CryptoController {
	
	@Autowired
	private CryptoRepository cryptoRepo;
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	@GetMapping("admin")
	public String admin(Model modelo, Principal principal) {
		
		Sort ordenacao = Sort.by("dataMovimentacao").descending();
		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
		
		Iterable<Crypto> list = cryptoRepo.findAllByUsuario(principal.getName(), paginacao);
		
		modelo.addAttribute("list", list);
		
		return "crypto/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(Model modelo, RequestCrypto dados) {
		
		modelo.addAttribute("movimentacoes", EnumMovimentacao.values());
		
		return "crypto/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(Model modelo, @Valid RequestCrypto dados, BindingResult resultado) {
		
		Crypto cripto = new Crypto();
		
		if (resultado.hasErrors()) {
			
			modelo.addAttribute("movimentacoes", EnumMovimentacao.values());
			
			return "crypto/cadastro";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Usuario usu = usuRepo.findByUsername(username);
		
		cripto.toCrypto(dados);
		cripto.setUser(usu);
		
		cryptoRepo.save(cripto);
		
		return "redirect:/crypto/admin";
	}
}
