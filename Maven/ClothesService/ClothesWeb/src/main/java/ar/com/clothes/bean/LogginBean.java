package ar.com.clothes.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import ar.com.clothes.model.Usuario;
import ar.com.clothes.model.UsuarioRol;
import ar.com.clothes.util.EncriptacionUtil;
import ar.com.clothes.util.StringUtil;

/**
 * 
 * @author MostroBook
 *
 */
@ManagedBean(name = "logginBean")
@ViewScoped
public class LogginBean extends BaseBean implements Serializable {

	private static final Logger LOG = Logger.getLogger(LogginBean.class);

	private static final String ADMINISTRADOR = "Administrador";
	private static final String VENDEDOR = "Vendedor";
	private static final String ENCARGADO = "Encargado";
	/**
	 * 
	 */
	private static final long serialVersionUID = -1948964041965109478L;

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
		RequestContext requestContext = RequestContext.getCurrentInstance();
		FacesContext context = FacesContext.getCurrentInstance();
		requestContext.update("loginForm");
		if (validateLoggin()) {
			LOG.info("Ok todo...");
			String rol = (String) context.getExternalContext().getSessionMap().get("rolSession");
			if (rol.equals(ADMINISTRADOR)) {
				return "adminListaEmpresasView";
			}
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
				RequestContext requestContext = RequestContext.getCurrentInstance();
				requestContext.update("loginForm");
				validate = Boolean.FALSE;
			}
		}
		return validate;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean validateOnDB() {
		Boolean validate = Boolean.TRUE;
		String passEncrypt = EncriptacionUtil.Encriptar(password);
		Usuario user = getUsuarioService().findByUsuarioPassword(nombreUsuario, passEncrypt);
		if (null == user) {
			validate = Boolean.FALSE;
		} else {
			List<UsuarioRol> list = getUsuarioRolService().findByUsuario(user);
			LOG.info("cantidad de roles encontrados: " + list.size());
			LOG.info("ROL ENCONTRADO: " + list.get(0).getRol().getDescripcion());
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("empresa", user.getEmpresa());
			context.getExternalContext().getSessionMap().put("usuarioSession", user);
			context.getExternalContext().getSessionMap().put("rolSession", list.get(0).getRol().getDescripcion());
		}
		return validate;
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

	public String cerrarSesion() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		return "/ClothesWeb";
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
