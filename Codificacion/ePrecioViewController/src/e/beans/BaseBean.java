package e.beans;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import e.base.dto.contexto.UsuarioWebDto;
import e.base.dto.validacion.MensajeDto;
import e.servicio.ServicioCliente;
import e.servicio.ServicioItem;
import e.servicio.ServicioPrecio;
import e.servicio.impl.ServicioClienteImpl;
import e.util.SpringUtil;

public class BaseBean {
	private final static Logger LOG = Logger.getLogger(BaseBean.class);
	protected final static String USUARIO_WEB = "WEB_USER";
	protected final static String MENSAJE = "MENSAJE";
	protected final static String CONTEXTO = "CONTEXTO";

	private ServicioPrecio servicioGeneral;
	private ServicioItem servicioItem;
	private ServicioCliente servicioCliente;

	public BaseBean() {
		LOG.debug("");
	}

	/**
	 * Obtiene el servicio para operar con el modelo
	 * 
	 * @return ServicioGeneral
	 */
	protected ServicioPrecio getServicioPrecio() {
		if (servicioGeneral == null) {
			servicioGeneral = (ServicioPrecio) SpringUtil.obtenerBeanSpring("servicioPrecio");
		}
		return servicioGeneral;
	}

	/**
	 * Obtiene el servicio para generar listasa seleccionables
	 * 
	 * @return ServicioItem
	 */
	protected ServicioItem getServicioItem() {
		if (servicioItem == null) {
			servicioItem = (ServicioItem) SpringUtil.obtenerBeanSpring("servicioItem");
		}
		return servicioItem;
	}

	protected void guardarAtributoSesion(String nombreAtributo, Object valorAtributo) {
		LOG.debug(nombreAtributo + ": " + valorAtributo);
		if (nombreAtributo != null && !nombreAtributo.trim().isEmpty()) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(nombreAtributo, valorAtributo);
		}
	}

	protected Object obtenerAtributoSesion(String nombreAtributo) {
		Object valorAtributo = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(nombreAtributo);
		LOG.debug(nombreAtributo + ": " + valorAtributo);
		return valorAtributo;
	}

	protected void guardarUsuarioWeb(UsuarioWebDto usuarioWeb) {
		this.guardarAtributoSesion(USUARIO_WEB, usuarioWeb);
	}

	protected UsuarioWebDto obtenerUsuarioWeb() {
		return (UsuarioWebDto) this.obtenerAtributoSesion(USUARIO_WEB);

	}

	protected void setMensajeDto(MensajeDto mensajeDto) {
		guardarAtributoSesion(MENSAJE, mensajeDto);
	}

	public MensajeDto getMensajeDto() {
		return (MensajeDto) obtenerAtributoSesion(MENSAJE);
	}

	public ServicioCliente getServicioCliente() {
		if (servicioCliente == null) {
			servicioCliente = (ServicioCliente) SpringUtil.obtenerBeanSpring("servicioCliente");
		}
		return servicioCliente;
	}

	public void setServicioCliente(ServicioCliente servicioCliente) {
		this.servicioCliente = servicioCliente;
	}

}
