package br.com.shinobi.ir.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum EnumInvestimento {

	FII(1, "Fundos Imobiliários", "https://www.btgpactualdigital.com/wp-content/uploads/2021/02/investimento-em-fundo-imobili%C3%A1rio-1.jpg"),
	ACOES(2, "Ações", "https://i.pinimg.com/originals/44/c7/f7/44c7f7944e636e1e5736a99631794001.jpg"),
	RENDA_FIXA(3, "Renda Fixa", "https://www.onze.com.br/blog/wp-content/uploads/2020/02/shutterstock_679627549-1.jpg"),
	TESOURO_DIRETO(4, "Tesouro Direto", "https://classic.exame.com/wp-content/uploads/2020/12/dinheiro-5.jpg?quality=70&strip=info&w=960");
	
	@Getter private final int id;
	@Getter private final String nome, imagem;
}
