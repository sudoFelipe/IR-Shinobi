package br.com.shinobi.ir.model;

import java.util.List;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class Wallet {

	@Getter @Setter private List<Acao> acao;
	@Getter @Setter private List<FII> fii;
	@Getter @Setter private List<TesouroDireto> td;
	@Getter @Setter private List<RendaFixa> rf;
	@Getter @Setter private List<Crypto> crypto;
}
