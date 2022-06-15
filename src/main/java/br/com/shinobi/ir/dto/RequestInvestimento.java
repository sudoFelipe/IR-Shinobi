package br.com.shinobi.ir.dto;

import javax.validation.constraints.NotBlank;

import br.com.shinobi.ir.model.Investimento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString

public class RequestInvestimento {

	@NotBlank
	@Getter @Setter private String nome;
	
	@NotBlank
	@Getter @Setter private String sigla;
	
	@NotBlank
	@Getter @Setter private String atuacao;
	
	@NotBlank
	@Getter @Setter private String path;
	
	@Getter @Setter private String descricao;
	
	public Investimento toInvestimento() {
		
		Investimento investimento = new Investimento();
		
		investimento.setNome(nome);
		investimento.setSigla(sigla);
		investimento.setAtuacao(atuacao);
		investimento.setDescricao(descricao);
		investimento.setPath(path);		
		
		return investimento;
	}
}
