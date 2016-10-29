package e.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import e.base.dto.contexto.UsuarioWebDto;
import e.base.dto.validacion.MensajeDto;
import e.servicio.ServicioCliente;
import e.servicio.ServicioMedida;
import e.servicio.ServicioModelo;
import e.servicio.ServicioUsuario;
import e.util.SpringUtil;

public class BaseBean {
	private final static Logger LOG = Logger.getLogger(BaseBean.class);
	protected final static String USUARIO_WEB = "WEB_USER";
	protected final static String MENSAJE = "MENSAJE";
	protected final static String CONTEXTO = "CONTEXTO";

	private ServicioCliente servicioCliente;
	private ServicioMedida servicioMedida;
	private ServicioModelo servicioModelo;
	private ServicioUsuario servicioUsuario;

	public BaseBean() {
		LOG.debug("");
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
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public ServicioMedida getServicioMedida() {
		if (servicioMedida == null) {
			servicioMedida = (ServicioMedida) SpringUtil.obtenerBeanSpring("servicioMedida");
		}
		return servicioMedida;
	}

	public void setServicioMedida(ServicioMedida servicioMedida) {
		this.servicioMedida = servicioMedida;
	}

	public ServicioModelo getServicioModelo() {
		if (servicioModelo == null) {
			servicioModelo = (ServicioModelo) SpringUtil.obtenerBeanSpring("servicioModelo");
		}
		return servicioModelo;
	}

	public void setServicioModelo(ServicioModelo servicioModelo) {
		this.servicioModelo = servicioModelo;
	}



	public ServicioUsuario getServicioUsuario() {
		if (servicioUsuario == null) {
			servicioUsuario = (ServicioUsuario) SpringUtil.obtenerBeanSpring("servicioUsuario");
		}
		return servicioUsuario;
	}



	public void setServicioUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}
	
	

}
