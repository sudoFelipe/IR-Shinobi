package br.com.shinobi.ir.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.shinobi.ir.enums.EnumMovimentacao;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString

public class RequestAcao {

	@NotBlank
	@Getter @Setter private String nome;
	
	@NotBlank
	@Getter @Setter private String ticker;
	
	@NotNull
	@Getter @Setter private Integer quantidade;
	
	@NotNull
	@Getter @Setter private Double valor;
	
	@NotNull
	@Getter @Setter private LocalDate data;
	
	@NotNull
	@Getter @Setter private EnumMovimentacao movimentacao;
}
