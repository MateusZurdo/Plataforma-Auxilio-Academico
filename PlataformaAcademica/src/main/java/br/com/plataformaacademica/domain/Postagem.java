package br.com.plataformaacademica.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Postagem {
	private Integer id_postagem;
	private String titulo;
	private String descricao;
	private Date data;
	private Integer id_usuario;
	private Integer id_material;
}
