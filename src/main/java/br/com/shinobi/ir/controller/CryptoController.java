package br.com.shinobi.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.dto.RequestAcao;
import br.com.shinobi.ir.dto.RequestCrypto;
import br.com.shinobi.ir.model.Crypto;
import br.com.shinobi.ir.repository.CryptoRepository;

@Controller
@RequestMapping("crypto")
public class CryptoController {
	
	@Autowired
	private CryptoRepository cryptoRepo;
	
	@GetMapping("admin")
	public String admin(Model modelo) {
		
		Iterable<Crypto> list = cryptoRepo.findAll();
		
		modelo.addAttribute("list", list);
		
		return "crypto/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(RequestCrypto dados) {
		return "crypto/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(RequestCrypto dados) {
		
		Crypto cripto = new Crypto();
		cripto.toCrypto(dados);
		
		cryptoRepo.save(cripto);
		
		return "crypto/admin";
	}
}
