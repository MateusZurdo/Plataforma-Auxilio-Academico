package br.com.plataformaacademica.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.plataformaacademica.dao.CursoDao;
import br.com.plataformaacademica.domain.Curso;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class CursoBean implements Serializable {
	private List<Curso> cursos;

	private Curso curso = new Curso();

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@PostConstruct
	public void listar() {
		try {
			CursoDao cursoDao = new CursoDao();
			cursos = cursoDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar os cursos!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}
	}

	public void novo() {
		curso = new Curso();
	}

	public void salvar() {
		try {
			CursoDao cursoDao = new CursoDao();
			cursoDao.merge(curso);

			curso = new Curso();

			String msg = "Curso salvo com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Ocorreu um erro ao tentar salvar um novo curso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void excluir(ActionEvent event) {
		curso = (Curso) event.getComponent().getAttributes().get("cursoSelecionado");
		try {
			CursoDao cursoDao = new CursoDao();
			cursoDao.excluir(curso);

			cursos = cursoDao.listar();

			String msg = "Curso removido com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} catch (Exception e) {
			String msg = "Ocorreu um erro ao tentar remover um curso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void editar(ActionEvent event) {
		curso = (Curso) event.getComponent().getAttributes().get("cursoSelecionado");
		System.out.println(curso.getNome());
		/*
		 * try {
		 * 
		 * CursoDao cursoDao = new CursoDao(); cursoDao.editar(curso);
		 * 
		 * cursos = cursoDao.listar();
		 * 
		 * String msg = "Curso alterado com sucesso!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); } catch (Exception e) { String msg =
		 * "Ocorreu um erro ao tentar alterar um curso!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); }
		 */
	}
}