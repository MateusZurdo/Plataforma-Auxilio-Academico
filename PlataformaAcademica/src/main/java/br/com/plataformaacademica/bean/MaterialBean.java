package br.com.plataformaacademica.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.plataformaacademica.dao.MaterialDao;
import br.com.plataformaacademica.dao.MateriaDao;
import br.com.plataformaacademica.dao.UsuarioDao;
import br.com.plataformaacademica.domain.Material;
import br.com.plataformaacademica.domain.Materia;
import br.com.plataformaacademica.domain.Usuario;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class MaterialBean implements Serializable {
	private List<Material> materials;
	private List<Materia> materias;

	private Material material = new Material();

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@PostConstruct
	public void listar() {
		try {
			MaterialDao materialDao = new MaterialDao();
			materials = materialDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar os materials!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			material = new Material();

			MateriaDao cursoDao = new MateriaDao();
			materias = cursoDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar os materias!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			MaterialDao materialDao = new MaterialDao();
			materialDao.merge(material);

			material = new Material();

			materials = materialDao.listar();

			MateriaDao cursoDao = new MateriaDao();
			materias = cursoDao.listar();

			String msg = "Material salvo com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);

		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Ocorreu um erro ao tentar salvar um novo material!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void excluir(ActionEvent event) {
		material = (Material) event.getComponent().getAttributes().get("materialSelecionado");
		try {
			MaterialDao materialDao = new MaterialDao();
			materialDao.excluir(material);

			materials = materialDao.listar();

			String msg = "Material removido com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} catch (Exception e) {
			String msg = "Ocorreu um erro ao tentar remover um material!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void editar(ActionEvent event) {

		try {
			material = (Material) event.getComponent().getAttributes().get("materialSelecionado");
			System.out.println(material.getTitulo());

			MateriaDao cursoDao = new MateriaDao();
			materias = cursoDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar os materias!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * MaterialDao materialDao = new MaterialDao(); materialDao.editar(material);
		 * 
		 * materials = materialDao.listar();
		 * 
		 * String msg = "Material alterado com sucesso!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); } catch (Exception e) { String msg =
		 * "Ocorreu um erro ao tentar alterar um material!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); }
		 */
	}
}