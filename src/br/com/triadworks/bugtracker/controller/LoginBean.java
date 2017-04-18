package br.com.triadworks.bugtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.service.Autenticador;
import br.com.triadworks.bugtracker.util.FacesUtils;
/* anotações JSF  */
//@ManagedBean
//@RequestScoped

/* anotações Spring  */
@Controller
@Scope("request")
public class LoginBean {

	private String login;
	private String senha;
	// @ManagedProperty("#{autenticador}") JSF - remover gets - sets
	private Autenticador autenticador;
	// @ManagedProperty("#{usuarioWeb}") JSF - remover gets - sets
	private UsuarioWeb usuarioWeb;

	@Autowired
	public LoginBean(Autenticador autenticador, UsuarioWeb usuarioWeb) {
		this.autenticador = autenticador;
		this.usuarioWeb = usuarioWeb;
	}

	public String logar() {
		Usuario usuario = autenticador.autentica(login, senha);
		if (usuario != null) {
			usuarioWeb.loga(usuario);
			return "pages/usuario/lista?faces-redirect=true";
		}
		new FacesUtils().adicionaMensagemDeErro("Login ou Senha inválidos!!!");
		return null;
	}

	public String sair() {
		usuarioWeb.desloga();
		return "/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
