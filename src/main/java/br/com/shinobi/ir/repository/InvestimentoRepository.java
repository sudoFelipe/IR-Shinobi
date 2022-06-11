package br.com.shinobi.ir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.shinobi.ir.model.Investimento;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Integer>{
	
}
