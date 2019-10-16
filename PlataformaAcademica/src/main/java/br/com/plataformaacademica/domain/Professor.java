package br.com.plataformaacademica.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Professor {

	@Id
	private Integer num_matricula;

	@OneToOne
	@JoinColumn(nullable = false)
	private Usuario id_usuario;

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getNum_matricula() {
		return num_matricula;
	}

	public void setNum_matricula(Integer num_matricula) {
		this.num_matricula = num_matricula;
	}

}
