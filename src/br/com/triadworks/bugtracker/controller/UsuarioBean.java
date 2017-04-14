package br.com.triadworks.bugtracker.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtils;

@ManagedBean
public class UsuarioBean implements Serializable {
	
	@ManagedProperty("#{usuarioDao}")
	private UsuarioDao dao;
	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	public void adiciona() {

	
		dao.adiciona(this.usuario);
		
		new FacesUtils().adicionaMensagemDeSucesso("Usuário adicionadao com sucesso!");
	}

	public void lista() {
		
		this.usuarios = dao.lista();
	}

	public void remove(Usuario usuario) {
		
		dao.remove(usuario);
		this.usuarios = dao.lista();
		
		new FacesUtils().adicionaMensagemDeErro("Usuário removido com sucesso!");
	}
	
	public void altera() {
		
		dao.atualiza(usuario);
		
		new FacesUtils().adicionaMensagemDeSucesso("Usuário alterado com sucesso!");
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
