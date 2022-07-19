package br.com.shinobi.ir.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.shinobi.ir.model.Acao;
import br.com.shinobi.ir.model.FII;
import br.com.shinobi.ir.model.Wallet;
import br.com.shinobi.ir.repository.AcaoRepository;
import br.com.shinobi.ir.repository.CryptoRepository;
import br.com.shinobi.ir.repository.FIIRepository;
import br.com.shinobi.ir.repository.RendaFixaRepository;
import br.com.shinobi.ir.repository.TesouroDiretoRepository;

@RestController
@RequestMapping("/api/wallet")
public class WalletRest {

//	@Autowired
//	private FIIRepository fiiRepo;
//	
//	@GetMapping("lista")
//	public List<FII> getTodosFundos() {
//		
//		Sort ordenacao = Sort.by("id").descending();
//		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
//		
//		return fiiRepo.findAllByUsuario("luis", paginacao);
//	}
	
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
	
	@GetMapping("geral")
	public Wallet getWallet(Principal principal) {
		
		Sort ordenacao = Sort.by("id").descending();
		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
		
		Wallet wallet = new Wallet();
		
		wallet.setAcao(acaoRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setFii(fiiRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setRf(rfRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setTd(tdRepository.findAllByUsuario(principal.getName(), paginacao));
		wallet.setCrypto(cryptoRepository.findAllByUsuario(principal.getName(), paginacao));
		
		return wallet;
	}
	
//	@GetMapping("geral")
//	public List<Acao> getWallet(Principal principal) {
//		
//		Sort ordenacao = Sort.by("id").descending();
//		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
//		
//		return acaoRepository.findAllByUsuario(principal.getName(), paginacao);
//	}
}
