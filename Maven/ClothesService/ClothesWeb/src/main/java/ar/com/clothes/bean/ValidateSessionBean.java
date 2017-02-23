package ar.com.clothes.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ar.com.clothes.model.Usuario;

@ManagedBean(name = "validateSessionBean")
@ViewScoped
public class ValidateSessionBean {
	public void verificarSession() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuarioSession");
			if (null == usuario) {
				context.getExternalContext().redirect("/ClothesWeb");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
