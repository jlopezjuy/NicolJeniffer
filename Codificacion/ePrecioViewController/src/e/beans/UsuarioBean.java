package e.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import e.base.util.StringUtil;

public class UsuarioBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(UsuarioBean.class);
	
	private String nombreUsuario;
	private String password;
	public UsuarioBean() {
		super();
	}
	
	/**
	 * Metodo para redireccionar validar el login
	 * 
	 * @return String
	 * @author JLopez
	 * @since 31/10/2015
	 * @version 1.0
	 */
	public String validarLogin(){
		LOG.info("Usuario seleccionado: "+nombreUsuario);
		LOG.info("Contraseña ingresada: "+password);
		if(validateLoggin()){
			LOG.info("Ok todo...");
			return "listaClientesView";
		}else{
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
		if(StringUtil.esVacio(nombreUsuario) && StringUtil.esVacio(password)){
			validate = Boolean.FALSE;
			addMessageWarning("Warning!", "Debe ingresar usuario y password.");
		}else{
			if(!validateOnDB()){
				addMessageWarning("Warning!", "Usuario y/o Password incorrecta");
				validate = Boolean.FALSE;
			}
		}
		return validate;
	}
	
	public Boolean validateOnDB(){
		Boolean validate = Boolean.TRUE;
		
		if(null == getServicioUsuario().getUsuario(nombreUsuario, password)){
			validate = Boolean.FALSE;
		}
		return validate;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
