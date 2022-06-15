package br.com.shinobi.ir.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.shinobi.ir.dto.RequestInvestimento;
import br.com.shinobi.ir.model.Investimento;
import br.com.shinobi.ir.model.Usuario;
import br.com.shinobi.ir.repository.InvestimentoRepository;
import br.com.shinobi.ir.repository.UsuarioRepository;

@Controller
@RequestMapping("investimento")
public class InvestimentoController {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private InvestimentoRepository investimentoRepo;
	
	@GetMapping("formulario")
	public String formInvestimento() {
		return "investimento/formulario";
	}
	
	@PostMapping("novo")
	public String novo(Model modelo, @Valid RequestInvestimento requisicao, BindingResult resultado) {
		
		Usuario usu = usuarioRepo.findById(1).get();
		
		modelo.addAttribute("usuario", usu);
		
		if (!resultado.hasErrors()) {
			
			Investimento invest = requisicao.toInvestimento();
			
			investimentoRepo.save(invest);
		}

		List<Investimento> lsInvestimentos = investimentoRepo.findAll();
		
		modelo.addAttribute("investimentos", lsInvestimentos);
		
		return "redirect:/home";
	}
}
