package br.com.shinobi.ir.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.shinobi.ir.model.FII;
import br.com.shinobi.ir.repository.FIIRepository;

@RestController
@RequestMapping("/api/fiis")
public class FIIRest {

	@Autowired
	private FIIRepository fiiRepo;
	
	@GetMapping("lista")
	public List<FII> getTodosFundos() {
		
		Sort ordenacao = Sort.by("id").descending();
		Pageable paginacao = PageRequest.of(0, 6, ordenacao);
		
		return fiiRepo.findAllByUsuario("luis", paginacao);
	}
}
