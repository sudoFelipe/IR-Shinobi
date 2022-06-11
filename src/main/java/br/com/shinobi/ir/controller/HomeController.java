package br.com.shinobi.ir.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.shinobi.ir.model.Investimento;
import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.InvestimentoRepository;
import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
public class HomeController {
	
	@Autowired
	private InvestimentoRepository investimentoRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping("home")
	public String home(Model modelo) {
		
		usuarioRepo.save(new Usuario(null, "Luís Felipe", 25, LocalDate.of(1997, 5, 14), "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/48px-User_icon_2.svg.png?20070812155648"));
		
		Usuario usu = usuarioRepo.findById(1).get();
		
		List<Investimento> lsInvestimentos = investimentoRepo.findAll();
		
		modelo.addAttribute("usuario", usu);
		modelo.addAttribute("investimentos", lsInvestimentos);
		
		return "home";
	}
}
