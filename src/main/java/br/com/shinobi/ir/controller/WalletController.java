package br.com.shinobi.ir.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.shinobi.ir.model.Wallet;
import br.com.shinobi.ir.repository.AcaoRepository;
import br.com.shinobi.ir.repository.CryptoRepository;
import br.com.shinobi.ir.repository.FIIRepository;
import br.com.shinobi.ir.repository.RendaFixaRepository;
import br.com.shinobi.ir.repository.TesouroDiretoRepository;

@Controller
public class WalletController {

	@Autowired
	private AcaoRepository acaoRepository;
	
	@Autowired
	private FIIRepository fiiRepository;
	
	@Autowired
	private TesouroDiretoRepository tdRepository;
	
	@Autowired
	private RendaFixaRepository rfRepository;
	
	@Autowired
	private CryptoRepository cryptoRepository;
	
	@GetMapping("wallet")
	public String wallet(Model modelo, Principal principal) {
		
		Sort ordenacao = Sort.by("id").descending();
		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
		
		Wallet wallet = new Wallet();
		
		wallet.setAcao(acaoRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setFii(fiiRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setRf(rfRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setTd(tdRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setCrypto(cryptoRepository.findAllByUsuario(principal.getName(), paginacao));
		
		modelo.addAttribute("totalAcao", wallet.getTotalAcoes());
		modelo.addAttribute("totalFii", wallet.getTotalFii());
		modelo.addAttribute("totalRF", wallet.getTotalRF());
		modelo.addAttribute("totalTD", wallet.getTotalTD());
		modelo.addAttribute("totalCrypto", wallet.getTotalCrypto());
		modelo.addAttribute("totalWallet", wallet.getTotalCarteira());
		
		return "wallet/dashboard";
	}
}
