package br.com.plataformaacademica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	
	@Column(nullable = false)
	private Integer ra;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Curso id_curso;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario id_usuario;

	public Integer getRa() {
		return ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
	}

	public Curso getId_curso() {
		return id_curso;
	}

	public void setId_curso(Curso id_curso) {
		this.id_curso = id_curso;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
}
