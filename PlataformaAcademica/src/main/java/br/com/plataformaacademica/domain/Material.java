package br.com.plataformaacademica.domain;

import javax.persistence.Entity;

@Entity
public class Material {
	private Integer id_material;
	private String titulo;
	private byte[] arquivo;
	private Integer id_materia;
}
