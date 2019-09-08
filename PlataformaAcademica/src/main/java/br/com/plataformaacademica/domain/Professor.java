package br.com.plataformaacademica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Professor {

	@Column(nullable = false)
	private Integer num_matricula;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario id_usuario;

	public Integer getNum_matricula() {
		return num_matricula;
	}

	public void setNum_matricula(Integer num_matricula) {
		this.num_matricula = num_matricula;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

}
