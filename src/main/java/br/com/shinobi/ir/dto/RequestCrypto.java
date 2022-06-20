package br.com.shinobi.ir.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString

public class RequestCrypto {

	@Getter @Setter private String nome;
	@Getter @Setter private Double valor;
	@Getter @Setter private LocalDate data;
}
