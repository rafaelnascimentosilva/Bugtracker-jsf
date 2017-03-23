package br.com.triadworks.bugtracker.util;

import javax.faces.context.FacesContext;

public class FacesUtils {

	private FacesContext facesContext;

	public FacesUtils() {
		this.facesContext = FacesContext.getCurrentInstance();
	}
}
