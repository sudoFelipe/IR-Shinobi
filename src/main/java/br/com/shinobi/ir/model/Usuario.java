package br.com.shinobi.ir.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@Getter @Setter private String username;
	@Getter @Setter private String password;
	@Getter @Setter private Boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	@Getter @Setter private List<FII> lsFii = new ArrayList<FII>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	@Getter @Setter private List<Acao> lsAcoes = new ArrayList<Acao>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	@Getter @Setter private List<Crypto> lsCryptos = new ArrayList<Crypto>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	@Getter @Setter private List<RendaFixa> lsRF = new ArrayList<RendaFixa>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	@Getter @Setter private List<TesouroDireto> lsTD = new ArrayList<TesouroDireto>();
}
