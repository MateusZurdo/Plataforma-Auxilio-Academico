package br.com.plataformaacademica.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.plataformaacademica.dao.ProfessorDao;
import br.com.plataformaacademica.dao.CursoDao;
import br.com.plataformaacademica.dao.ProfessorDao;
import br.com.plataformaacademica.dao.UsuarioDao;
import br.com.plataformaacademica.domain.Professor;
import br.com.plataformaacademica.domain.Curso;
import br.com.plataformaacademica.domain.Professor;
import br.com.plataformaacademica.domain.Usuario;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class ProfessorBean implements Serializable {
	private List<Professor> professores;

	private Professor professor = new Professor();
	private Usuario usuario = new Usuario();

	public List<Professor> getProfessors() {
		return professores;
	}

	public void setProfessors(List<Professor> professores) {
		this.professores = professores;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void listar() {
		try {
			ProfessorDao professorDao = new ProfessorDao();
			professores = professorDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar os professores!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}
	}

	public void novo() {
		professor = new Professor();
		usuario = new Usuario();
	}

	public void salvar() {
		try {

			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.mergeWithReturn(usuario);
			if (usuario != null) {
				ProfessorDao professorDao = new ProfessorDao();
				professor.setId_usuario(usuario);
				professorDao.merge(professor);

				professor = new Professor();
				usuario = new Usuario();

				professores = professorDao.listar();

				String msg = "Professor salvo com sucesso!";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, message);
			} else {
				String msg = "Ocorreu um erro ao tentar salvar um novo professor!";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);

				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Ocorreu um erro ao tentar salvar um novo professor!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void excluir(ActionEvent event) {
		professor = (Professor) event.getComponent().getAttributes().get("professorSelecionado");
		try {
			ProfessorDao professorDao = new ProfessorDao();
			professorDao.excluir(professor);

			professores = professorDao.listar();

			String msg = "Professor removido com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} catch (Exception e) {
			String msg = "Ocorreu um erro ao tentar remover um professor!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void editar(ActionEvent event) {

		professor = (Professor) event.getComponent().getAttributes().get("professorSelecionado");
		usuario = (Usuario) event.getComponent().getAttributes().get("usuarioSelecionado");
		System.out.println(professor.getNum_matricula());

		/*
		 * try {
		 * 
		 * ProfessorDao professorDao = new ProfessorDao();
		 * professorDao.editar(professor);
		 * 
		 * professores = professorDao.listar();
		 * 
		 * String msg = "Professor alterado com sucesso!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); } catch (Exception e) { String msg =
		 * "Ocorreu um erro ao tentar alterar um professor!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); }
		 */
	}
}