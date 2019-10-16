package br.com.plataformaacademica.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Aluno {

	@Id
	private Integer ra;

	@OneToOne
	@JoinColumn(nullable = false)
	private Usuario id_usuario;

	@OneToOne
	@JoinColumn(nullable = false)
	private Curso id_curso;

	public Integer getRa() {
		return ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Curso getId_curso() {
		return id_curso;
	}

	public void setId_curso(Curso id_curso) {
		this.id_curso = id_curso;
	}

}
