package br.com.shinobi.ir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.shinobi.ir.dto.RequestAcao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString

@Entity
public class Acao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	@Getter @Setter private String nome;
	@Getter @Setter private String ticker;
	@Getter @Setter private int quantidade;
	@Getter @Setter private double valor;
	@Getter @Setter private double total;
	@Getter @Setter private LocalDate dataMovimentacao;

	public void toAcao(RequestAcao dados) {
		
		this.nome = dados.getNome();
		this.ticker = dados.getTicker();
		this.quantidade = dados.getQuantidade();
		this.valor = dados.getValor();
		this.total = dados.getValor() * dados.getQuantidade();
		this.dataMovimentacao = dados.getData();
	}
}
