package br.com.shinobi.ir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.shinobi.ir.dto.RequestFII;
import br.com.shinobi.ir.enums.EnumMovimentacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString

@Entity
public class FII {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int id;
	@Getter @Setter private String nome;
	@Getter @Setter private String ticker;
	@Getter @Setter private String gestora;
	@Getter @Setter private int quantidade;
	@Getter @Setter private double valor;
	@Getter @Setter private double total;
	
	@Enumerated(value = EnumType.STRING)
	@Getter @Setter private EnumMovimentacao movimentacao;
	@Getter @Setter private LocalDate dataMovimentacao;


	public void toFII(RequestFII dados) {
		
		this.nome = dados.getNome();
		this.ticker = dados.getTicker();
		this.gestora = dados.getGestora();
		this.quantidade = dados.getQuantidade();
		this.valor = dados.getValor();
		this.total = dados.getQuantidade() * dados.getValor();
		this.dataMovimentacao = dados.getData();
		this.movimentacao = dados.getMovimentacao();
	}
	
	public EnumMovimentacao[] movimentacoes() {
		return EnumMovimentacao.values();
	}
}
