package ar.com.clothes.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import ar.com.clothes.service.UsuarioService;
import ar.com.clothes.util.SpringUtil;

@ManagedBean(name = "logginBean")
@ViewScoped
public class LogginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1948964041965109478L;

	private UsuarioService usuarioService;
	
	private String saludo;
	
	public LogginBean(){
		
	}
	
	@PostConstruct
    public void init() {
		saludo = "HOLA MUNDO DESDE BEAN!!!";
    }
	
	public void valor(ActionEvent actionEvent) {
		Integer cantidad = getUsuarioService().findAllUsuarios().size();
		System.out.println("Cantidad de registros: " + cantidad);
		addMessage("Welcome to Primefaces!!");
    }
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	/**
	 * @return the saludo
	 */
	public String getSaludo() {
		return saludo;
	}

	/**
	 * @param saludo the saludo to set
	 */
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		if (usuarioService == null) {
			usuarioService = (UsuarioService) SpringUtil.obtenerBeanSpring("usuarioService");
		}
		return usuarioService;
	}

	/**
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
