package br.com.plataformaacademica.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Materia_Curso {
	@ManyToOne
	@JoinColumn(nullable = false)
	private Materia id_materia;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Curso id_curso;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Professor id_professor;
}
