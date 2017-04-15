package br.com.triadworks.bugtracker.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.modelo.Bug;
import br.com.triadworks.bugtracker.modelo.Status;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtils;

@ManagedBean
public class BugBean {
	
	
	@ManagedProperty("#{bugDao}")
	private BugDao dao;
	
	private Bug bug = new Bug();
	
	@PostConstruct
	public void init() {
		this.bug.setResponsavel(new Usuario());
	}

	public void adiciona() {
		dao.salva(bug);
		this.bug = new Bug();
		new FacesUtils().adicionaMensagemDeSucesso("Bug Adicionado com sucesso !");
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public List<Status> getTodosOsStatus() {
		return Arrays.asList(Status.values());
	}

	public BugDao getDao() {
		return dao;
	}

	public void setDao(BugDao dao) {
		this.dao = dao;
	}


}
