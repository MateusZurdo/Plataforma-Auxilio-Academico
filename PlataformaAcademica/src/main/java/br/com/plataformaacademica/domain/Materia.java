package br.com.plataformaacademica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Materia {
	@Column(nullable = false, length = 10)
	private String sigla;

	@Column(nullable = false, length = 100)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
