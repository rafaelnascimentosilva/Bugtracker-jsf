package br.com.triadworks.bugtracker.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.service.Autenticador;
import br.com.triadworks.bugtracker.service.AutenticadorImpl;
import br.com.triadworks.bugtracker.util.FacesUtils;

@ManagedBean
@RequestScoped
public class LoginBean {
	
	private String login;
	private String senha;

	public String logar() {
		Autenticador autenticador = new AutenticadorImpl();
		Usuario usuario = autenticador.autentica(login, senha);
		//boolean loginEhValido = (usuario != null);
		//System.out.println("Login e senha são inválido? " + loginEhValido);
		if (usuario != null) {
			return "pages/usuario/lista";
		} 
		
		new FacesUtils().adicionaMensagemDeErro("Login ou Senha inválidos!!!");
		return "login";
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
