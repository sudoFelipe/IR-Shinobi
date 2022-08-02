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
	
	
	public Double getTotalCarteira() {
		
		return (acao.stream().mapToDouble(acao -> acao.getTotal()).sum() +
				fii.stream().mapToDouble(fii -> fii.getTotal()).sum() +
				td.stream().mapToDouble(td -> td.getValor()).sum() +
				rf.stream().mapToDouble(rf -> rf.getValor()).sum() +
				crypto.stream().mapToDouble(crypto -> crypto.getValor()).sum());
	}
	
	public Double getTotalAcoes() {
		return acao.stream().mapToDouble(acao -> acao.getTotal()).sum();
	}
	
	public Double getTotalFii() {
		return fii.stream().mapToDouble(fii -> fii.getTotal()).sum();
	}

	public Double getTotalCrypto() {
		return crypto.stream().mapToDouble(cpto -> cpto.getValor()).sum();
	}
	
	public Double getTotalRF() {
		return rf.stream().mapToDouble(rf -> rf.getValor()).sum();
	}
	
	public Double getTotalTD() {
		return td.stream().mapToDouble(td -> td.getValor()).sum();
	}
}
