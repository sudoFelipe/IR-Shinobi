package br.com.shinobi.ir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aporte")
public class AporteController {

	@GetMapping("admin")
	public String admin() {
		return "aporte/admin";
	}
}
