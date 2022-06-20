package br.com.shinobi.ir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.shinobi.ir.dto.RequestFII;
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
	@Getter @Setter private LocalDate dataMovimentacao;


	public void toFII(RequestFII dados) {
		
		this.nome = dados.getNome();
		this.ticker = dados.getTicker();
		this.gestora = dados.getGestora();
		this.quantidade = dados.getQuantidade();
		this.valor = dados.getValor();
		this.total = dados.getQuantidade() * dados.getValor();
		this.dataMovimentacao = dados.getData();
	}
}
