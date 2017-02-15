package ar.com.clothes.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import ar.com.clothes.model.Usuario;
import ar.com.clothes.service.UsuarioService;
import ar.com.clothes.util.SpringUtil;
import ar.com.clothes.util.StringUtil;

@ManagedBean(name = "logginBean")
@ViewScoped
public class LogginBean extends BaseBean implements Serializable {
	private static final Logger LOG = Logger.getLogger(LogginBean.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -1948964041965109478L;

	private UsuarioService usuarioService;

	private String saludo;

	private String nombreUsuario;
	private String password;

	public LogginBean() {

	}

	/**
	 * Metodo para redireccionar validar el login
	 * 
	 * @return String
	 * @author JLopez
	 * @since 31/10/2015
	 * @version 1.0
	 */
	public String validarLogin() {
		LOG.info("Usuario seleccionado: " + nombreUsuario);
		LOG.info("Contraseña ingresada: " + password);
		if (validateLoggin()) {
			LOG.info("Ok todo...");
			return "listaClientesView";
		} else {
			LOG.info("Error de loggin");
			return "";
		}
	}

	/**
	 * 
	 * @return
	 */
	private Boolean validateLoggin() {
		Boolean validate = Boolean.TRUE;
		if (StringUtil.esVacio(nombreUsuario) && StringUtil.esVacio(password)) {
			validate = Boolean.FALSE;
			addMessageWarning("Warning!", "Debe ingresar usuario y password.");
		} else {
			if (!validateOnDB()) {
				addMessageWarning("Warning!", "Usuario y/o Password incorrecta");
				validate = Boolean.FALSE;
			}
		}
		return validate;
	}

	public Boolean validateOnDB() {
		Boolean validate = Boolean.TRUE;
		Usuario user = getUsuarioService().findByUsuarioPassword(nombreUsuario, password);
		if (null == user) {
			validate = Boolean.FALSE;
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("empresa", user.getEmpresa());
		}
		return validate;
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
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * @return the saludo
	 */
	public String getSaludo() {
		return saludo;
	}

	/**
	 * @param saludo
	 *           the saludo to set
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
	 * @param usuarioService
	 *           the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario
	 *           the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *           the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
