package com.rosales.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {
	
	@Id
	private String nome;	
	
	@Column(name = "data_lancamento", nullable = false)
	private LocalDate dataLancamento;
	
	private boolean censurado;
	
	private String direcao;
	
	@OneToMany(mappedBy = "filme", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Ator> elenco;

	public Filme() {}
	
	public Filme(String nome, LocalDate dataLancamento, boolean censurado, String direcao, List<Ator> elenco) {
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.censurado = censurado;
		this.direcao = direcao;
		this.elenco = elenco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public boolean isCensurado() {
		return censurado;
	}

	public void setCensurado(boolean censurado) {
		this.censurado = censurado;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public List<Ator> getElenco() {
		return elenco;
	}

	public void setElenco(List<Ator> elenco) {
		this.elenco = elenco;
	}	
	
}
