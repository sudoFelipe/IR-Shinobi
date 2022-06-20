package br.com.shinobi.ir.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString

public class RequestFII {
	
	@Getter @Setter private String nome;
	@Getter @Setter private String ticker;
	@Getter @Setter private String gestora;
	@Getter @Setter private Integer quantidade;
	@Getter @Setter private Double valor;
	@Getter @Setter private Double total;
	@Getter @Setter private LocalDate data;
}
