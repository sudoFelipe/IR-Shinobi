package br.com.shinobi.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.dto.RequestTesouroDireto;
import br.com.shinobi.ir.model.TesouroDireto;
import br.com.shinobi.ir.repository.TesouroDiretoRepository;

@Controller
@RequestMapping("tesouro")
public class TesouroDiretoController {

	@Autowired
	private TesouroDiretoRepository tdRepo;
	
	@GetMapping("admin")
	public String tesouroDireto(Model modelo) {
		
		Iterable<TesouroDireto> list = tdRepo.findAll();
		
		modelo.addAttribute("list", list);
		
		return "tesouroDireto/admin";
	}
	
	@GetMapping("cadastro")
	public String cadastro(RequestTesouroDireto dados) {
		
		return "tesouroDireto/cadastro";
	}
	
	@PostMapping("registro")
	public String registro(RequestTesouroDireto dados) {
		
		TesouroDireto td = new TesouroDireto();
		td.toTesouroDireto(dados);
		
		tdRepo.save(td);
		
		return "tesouroDireto/admin";
	}
}
