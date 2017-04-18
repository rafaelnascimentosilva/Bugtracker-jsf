package br.com.triadworks.bugtracker.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.triadworks.bugtracker.modelo.Usuario;
/* anotações JSF  */
//@ManagedBean 
//@SessionScoped

/* anotações Spring equivalentes */
@Component
@Scope("session")
public class UsuarioWeb implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	
	public void loga(Usuario usuario){
		this.usuario = usuario;
	}
	public void desloga(){
		this.usuario = null;
	}
	
	public boolean isLogado(){
		return this.usuario != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
