package br.com.shinobi.ir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.shinobi.ir.dto.RequestTesouroDireto;
import br.com.shinobi.ir.enums.EnumMovimentacao;
import lombok.Getter;
import lombok.Setter;

@Entity
public class TesouroDireto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	@Getter @Setter private String nome;
	@Getter @Setter private LocalDate vencimento;
	@Getter @Setter private double valor;
	@Getter @Setter private LocalDate dataMovimentacao;
	
	@Enumerated(value = EnumType.STRING)
	@Getter @Setter private EnumMovimentacao movimentacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore	
	@Getter @Setter private Usuario user;
	
	public void toTesouroDireto(RequestTesouroDireto dados) {
		
		this.nome = dados.getNome();
		this.vencimento = dados.getVencimento();
		this.valor = dados.getValor();
		this.dataMovimentacao = dados.getData();
		this.movimentacao = dados.getMovimentacao();
	}
}
