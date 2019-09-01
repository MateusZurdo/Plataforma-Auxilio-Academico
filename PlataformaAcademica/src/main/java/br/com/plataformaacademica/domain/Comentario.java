package br.com.plataformaacademica.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Comentario {
	private Integer id_comentario;
	private String texto;
	private Date data;
	private Integer id_postagem;
	private Integer id_usuario;
	private Integer id_material;
}
