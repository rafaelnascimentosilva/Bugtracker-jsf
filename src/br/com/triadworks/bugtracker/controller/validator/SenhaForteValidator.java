package br.com.triadworks.bugtracker.controller.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("senhaForte")
public class SenhaForteValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent ui, Object value) throws ValidatorException {

		String senha = value.toString();
		if (!senha.matches("@")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_INFO,
					"O campo Senha não é forte o suficiente", "A senha deve ter de 5 a 12 caracteres"));
		}

	}

}
