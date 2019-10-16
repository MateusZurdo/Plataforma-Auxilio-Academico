package br.com.plataformaacademica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Materia_Curso implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Materia id_materia;

	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Curso id_curso;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Professor id_professor;
}
