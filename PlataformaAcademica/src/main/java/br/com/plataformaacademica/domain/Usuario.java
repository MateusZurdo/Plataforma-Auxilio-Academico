package br.com.plataformaacademica.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 100)
	private String sobrenome;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false, length = 1)
	private String sexo;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_nasc;

	@Column(nullable = false, length = 20)
	private String senha;

	@Column(nullable = false)
	private boolean tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

}
