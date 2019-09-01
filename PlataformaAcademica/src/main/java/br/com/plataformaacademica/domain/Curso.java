package br.com.plataformaacademica.domain;

import javax.persistence.Entity;

@Entity
public class Curso {
	private Integer num_mec;
	private String nome;
	private Integer carga_horaria;
	private boolean diurno;
	private boolean matutino;
	private boolean noturno;
}
