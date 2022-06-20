package br.com.shinobi.ir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.shinobi.ir.dto.RequestRendaFixa;
import lombok.Getter;
import lombok.Setter;

@Entity
public class RendaFixa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	@Getter @Setter private String nome;
	@Getter @Setter private LocalDate vencimento;
	@Getter @Setter private double valor;
	@Getter @Setter private LocalDate dataMovimentacao;
	
	public void toRendaFixa(RequestRendaFixa dados) {
		
		this.nome = dados.getNome();
		this.vencimento = dados.getVencimento();
		this.valor = dados.getValor();
		this.dataMovimentacao = dados.getData();
	}
}
