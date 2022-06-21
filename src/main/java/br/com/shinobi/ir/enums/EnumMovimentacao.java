package br.com.shinobi.ir.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum EnumMovimentacao {

	COMPRA(1, "Compra"),
	VENDA(2, "Venda"),
	ALUGUEL(3, "Aluguel");
	
	@Getter private final int id;
	@Getter private final String nome;
}
