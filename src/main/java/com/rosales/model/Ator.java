package com.rosales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ator")
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "nome_filme", nullable = false, foreignKey = @ForeignKey(name = "FK_filme_det"))
	private Filme filme;
	
	public Ator() {}
	
	public Ator(String nome, Filme filme) {
		this.nome = nome;
		this.filme = filme;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}	
	
}
