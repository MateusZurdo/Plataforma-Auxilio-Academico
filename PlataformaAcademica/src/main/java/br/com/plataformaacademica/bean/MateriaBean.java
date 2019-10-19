package br.com.plataformaacademica.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.plataformaacademica.dao.MateriaDao;
import br.com.plataformaacademica.domain.Materia;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class MateriaBean implements Serializable {
	private List<Materia> s;

	private Materia materia = new Materia();

	public List<Materia> getMaterias() {
		return s;
	}

	public void setMaterias(List<Materia> s) {
		this.s = s;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@PostConstruct
	public void listar() {
		try {
			MateriaDao materiaDao = new MateriaDao();
			s = materiaDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar as materias!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}
	}

	public void novo() {
		materia = new Materia();
	}

	public void salvar() {
		try {
			MateriaDao materiaDao = new MateriaDao();
			materiaDao.merge(materia);

			materia = new Materia();

			String msg = "Materia salvo com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Ocorreu um erro ao tentar salvar um novo materia!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void excluir(ActionEvent event) {
		materia = (Materia) event.getComponent().getAttributes().get("materiaSelecionado");
		try {
			MateriaDao materiaDao = new MateriaDao();
			materiaDao.excluir(materia);

			s = materiaDao.listar();

			String msg = "Materia removido com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} catch (Exception e) {
			String msg = "Ocorreu um erro ao tentar remover um materia!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void editar(ActionEvent event) {
		materia = (Materia) event.getComponent().getAttributes().get("materiaSelecionado");
		System.out.println(materia.getNome());
		/*
		 * try {
		 * 
		 * MateriaDao materiaDao = new MateriaDao(); materiaDao.editar(materia);
		 * 
		 * s = materiaDao.listar();
		 * 
		 * String msg = "Materia alterado com sucesso!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); } catch (Exception e) { String msg =
		 * "Ocorreu um erro ao tentar alterar um materia!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); }
		 */
	}
}