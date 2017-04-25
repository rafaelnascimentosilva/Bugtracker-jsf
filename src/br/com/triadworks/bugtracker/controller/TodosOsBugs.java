package br.com.triadworks.bugtracker.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.modelo.Bug;

@ViewScoped
@ManagedBean
public class TodosOsBugs implements Serializable {
	@ManagedProperty("#{bugDao}")
	private BugDao dao;

	private List<Bug> bugs;

	@PostConstruct
	public void Init() {
		this.bugs = dao.lista();
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public BugDao getDao() {
		return dao;
	}

	public void setDao(BugDao dao) {
		this.dao = dao;
	}
}
