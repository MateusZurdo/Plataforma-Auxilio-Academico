package br.com.plataformaacademica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comentario implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_comentario;

	@Column(nullable = false, length = 200)
	private String texto;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Postagem id_postagem;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario id_usuario;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Material id_material;

	public Integer getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Integer id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Postagem getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(Postagem id_postagem) {
		this.id_postagem = id_postagem;
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
