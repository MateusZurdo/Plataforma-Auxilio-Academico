package br.com.plataformaacademica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Curso {
	@Column(nullable = false)
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

}
