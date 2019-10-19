package br.com.plataformaacademica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Material implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_material;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Column(nullable = true)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_material == null) ? 0 : id_material.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (id_material == null) {
			if (other.id_material != null)
				return false;
		} else if (!id_material.equals(other.id_material))
			return false;
		return true;
	}

}
