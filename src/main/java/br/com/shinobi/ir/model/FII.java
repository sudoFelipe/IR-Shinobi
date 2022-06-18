package br.com.shinobi.ir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import lombok.Getter;
import lombok.Setter;

@Entity
public class FII {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int id;
	@Getter @Setter private String nome;
	@Getter @Setter private String ticker;
	@Getter @Setter private String gestora;
	@Getter @Setter private int quantidade;
	@Getter @Setter private double valor;
	@Getter @Setter private double valorTotal;
	@Getter @Setter private LocalDate data;
	
}
