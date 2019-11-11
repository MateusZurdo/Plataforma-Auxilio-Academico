package br.com.plataformaacademica.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.plataformaacademica.dao.AlunoDao;
import br.com.plataformaacademica.dao.CursoDao;
import br.com.plataformaacademica.dao.UsuarioDao;
import br.com.plataformaacademica.domain.Aluno;
import br.com.plataformaacademica.domain.Curso;
import br.com.plataformaacademica.domain.Usuario;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {
	private List<Aluno> alunos;
	private List<Curso> cursos;

	private Aluno aluno = new Aluno();
	private Usuario usuario = new Usuario();

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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
			AlunoDao alunoDao = new AlunoDao();
			alunos = alunoDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar os alunos!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			aluno = new Aluno();
			usuario = new Usuario();

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

	public void salvar() {
		try {

			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.mergeWithReturn(usuario);
			if (usuario != null) {
				AlunoDao alunoDao = new AlunoDao();
				aluno.setId_usuario(usuario);
				alunoDao.merge(aluno);

				aluno = new Aluno();
				usuario = new Usuario();

				alunos = alunoDao.listar();

				CursoDao cursoDao = new CursoDao();
				cursos = cursoDao.listar();

				String msg = "Aluno salvo com sucesso!";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, message);
			} else {
				String msg = "Ocorreu um erro ao tentar salvar um novo aluno!";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);

				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Ocorreu um erro ao tentar salvar um novo aluno!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void excluir(ActionEvent event) {
		aluno = (Aluno) event.getComponent().getAttributes().get("alunoSelecionado");
		try {
			AlunoDao alunoDao = new AlunoDao();
			alunoDao.excluir(aluno);

			alunos = alunoDao.listar();

			String msg = "Aluno removido com sucesso!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		} catch (Exception e) {
			String msg = "Ocorreu um erro ao tentar remover um aluno!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}

	public void editar(ActionEvent event) {
		
		try {
			aluno = (Aluno) event.getComponent().getAttributes().get("alunoSelecionado");
			usuario = (Usuario) event.getComponent().getAttributes().get("usuarioSelecionado");
			System.out.println(aluno.getRa());

			CursoDao cursoDao = new CursoDao();
			cursos = cursoDao.listar();
		} catch (Exception erro) {
			String msg = "Ocorreu um erro ao carregar os cursos!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, erro.getMessage());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			erro.printStackTrace();
		}
		
		/*
		 * try {
		 * 
		 * AlunoDao alunoDao = new AlunoDao(); alunoDao.editar(aluno);
		 * 
		 * alunos = alunoDao.listar();
		 * 
		 * String msg = "Aluno alterado com sucesso!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); } catch (Exception e) { String msg =
		 * "Ocorreu um erro ao tentar alterar um aluno!"; FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR, msg, e.getMessage());
		 * 
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.addMessage(null, message); }
		 */
	}
}