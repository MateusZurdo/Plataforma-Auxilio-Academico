package br.com.plataformaacademica.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.plataformaacademica.domain.Usuario;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	String email;
	String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void logar() throws SQLException {
		boolean retorno = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, email, senha FROM usuario WHERE email LIKE ? AND senha LIKE ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setString(1, email);
		comando.setString(2, senha);

		ResultSet result = comando.executeQuery();

		Usuario u = new Usuario();

		if (result.next()) {
			// u = new Usuario(result);
			retorno = true;
		}

		if (retorno) {
			// Coloca o usuário no contexto da aplicação para poder buscar o usuário logado
			// em qualquer tela.
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuLogado", u);
			try {
				Faces.redirect("pages/alunoPesquisa.xhtml");
				// Utils.addLog("Email", "<b>Email do usuário: </b>" + u.getEmail(),
				// Utils.LOGIN);
			} catch (IOException ex) {
				String msg = "Ocorreu um erro ao tentar realizar o login!";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ex.getMessage());

				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, message);
				ex.printStackTrace(System.out);
			}
		} else {
			String msg = "Email ou Senha incorretos!";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
			// exibir msg de erro de email
			// JSFUtil.adicionarMensagemErro("Falha na autenticação, usuário ou senha
			// incorreto.");

		}

		// PrimeFaces.current().executeScript("PF('statusDialogEmail').hide()");

		conexao.close();
		result.close();
		comando.close();

	}
}
