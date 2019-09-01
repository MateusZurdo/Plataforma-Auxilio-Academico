package br.com.plataformaacademica.domain;

import javax.persistence.Entity;

@Entity
public class Materia_Curso {
	private String id_materia;
	private Integer id_curso;
	private Integer id_professor;
}
