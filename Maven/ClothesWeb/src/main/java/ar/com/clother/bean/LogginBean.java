package ar.com.clother.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
