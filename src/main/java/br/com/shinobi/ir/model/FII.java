package br.com.shinobi.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class FII {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int id;
	@Getter @Setter private String nome;
	
}
