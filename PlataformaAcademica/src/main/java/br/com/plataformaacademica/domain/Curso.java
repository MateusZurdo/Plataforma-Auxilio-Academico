package br.com.plataformaacademica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso implements Serializable {
	@Id
	private Integer num_mec;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	private Integer carga_horaria;

	@Column(nullable = false)
	private boolean diurno;

	@Column(nullable = false)
	private boolean matutino;

	@Column(nullable = false)
	private boolean noturno;

	public Integer getNum_mec() {
		return num_mec;
	}

	public void setNum_mec(Integer num_mec) {
		this.num_mec = num_mec;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public boolean isDiurno() {
		return diurno;
	}

	public void setDiurno(boolean diurno) {
		this.diurno = diurno;
	}

	public boolean isMatutino() {
		return matutino;
	}

	public void setMatutino(boolean matutino) {
		this.matutino = matutino;
	}

	public boolean isNoturno() {
		return noturno;
	}

	public void setNoturno(boolean noturno) {
		this.noturno = noturno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((num_mec == null) ? 0 : num_mec.hashCode());
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
		Curso other = (Curso) obj;
		if (num_mec == null) {
			if (other.num_mec != null)
				return false;
		} else if (!num_mec.equals(other.num_mec))
			return false;
		return true;
	}

}
