package br.com.shinobi.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.shinobi.ir.repository.FIIRepository;

@Controller
public class FIIController {

	@Autowired
	private FIIRepository fiiRepo;
	
	@GetMapping("fiis")
	public String fiis() {
		
		return "investimentos/fiis";
	}
}
