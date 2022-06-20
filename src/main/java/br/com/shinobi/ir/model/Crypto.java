package br.com.shinobi.ir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.shinobi.ir.dto.RequestCrypto;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Crypto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	@Getter @Setter private String nome;
	@Getter @Setter private double valor;
	@Getter @Setter private LocalDate dataMovimentacao;
	
	public void toCrypto(RequestCrypto dados) {
		
		this.nome = dados.getNome();
		this.valor = dados.getValor();
		this.dataMovimentacao = dados.getData();
	}
}
