package br.com.plataformaacademica.domain;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Usuario {
	
	private Integer id_usuario;
	private String nome;
	private String sobrenome;
	private String email;
	private String sexo;
	private Date data;
	private String senha;
	private boolean tipo;
}
