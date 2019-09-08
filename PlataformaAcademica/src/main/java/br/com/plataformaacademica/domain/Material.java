package br.com.plataformaacademica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Material {
	@Column(nullable = false)
	private Integer id_material;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Column(nullable = false)
	private byte[] arquivo;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Materia id_materia;

	public Integer getId_material() {
		return id_material;
	}

	public void setId_material(Integer id_material) {
		this.id_material = id_material;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public Materia getId_materia() {
		return id_materia;
	}

	public void setId_materia(Materia id_materia) {
		this.id_materia = id_materia;
	}

}
