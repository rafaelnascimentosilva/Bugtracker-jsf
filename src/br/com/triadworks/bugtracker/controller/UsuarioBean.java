package br.com.triadworks.bugtracker.controller;

import javax.faces.bean.ManagedBean;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();

	public void adiciona() {

		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(this.usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
