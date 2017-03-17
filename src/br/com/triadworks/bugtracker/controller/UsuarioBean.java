package br.com.triadworks.bugtracker.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	public void adiciona() {

		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(this.usuario);
	}

	public void lista() {
		UsuarioDao dao = new UsuarioDao();
		this.usuarios = dao.lista();
	}

	public void remove(Usuario usuario) {
		UsuarioDao dao = new UsuarioDao();
		dao.remove(usuario);
		this.usuarios = dao.lista();
	}
	
	public void altera() {
		UsuarioDao dao = new UsuarioDao();
		dao.atualiza(usuario);
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
