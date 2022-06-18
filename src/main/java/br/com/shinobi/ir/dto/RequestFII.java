package br.com.shinobi.ir.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class RequestFII {
	
	@Getter @Setter private String nome;
	@Getter @Setter private String ticker;
	@Getter @Setter private String gestora;
	@Getter @Setter private int quantidade;
	@Getter @Setter private double valor;
	@Getter @Setter private double valorTotal;
	@Getter @Setter private LocalDate data;
}
