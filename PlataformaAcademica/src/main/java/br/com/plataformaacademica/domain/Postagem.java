package br.com.plataformaacademica.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Postagem {

	@Column(nullable = false)
	private Integer id_postagem;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Column(nullable = false, length = 200)
	private String descricao;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario id_usuario;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Material id_material;

	public Integer getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(Integer id_postagem) {
		this.id_postagem = id_postagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Material getId_material() {
		return id_material;
	}

	public void setId_material(Material id_material) {
		this.id_material = id_material;
	}

}
