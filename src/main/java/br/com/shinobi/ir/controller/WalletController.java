package br.com.shinobi.ir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WalletController {

	@GetMapping("wallet")
	public String wallet() {
		return "wallet/dashboard";
	}
}
