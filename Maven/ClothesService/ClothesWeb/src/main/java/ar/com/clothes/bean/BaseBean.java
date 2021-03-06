package ar.com.clothes.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import ar.com.clothes.service.ClienteService;
import ar.com.clothes.service.EmpresaService;
import ar.com.clothes.service.EncargoService;
import ar.com.clothes.service.MedidaService;
import ar.com.clothes.service.ModeloService;
import ar.com.clothes.service.PagoService;
import ar.com.clothes.service.UsuarioRolService;
import ar.com.clothes.service.UsuarioService;
import ar.com.clothes.service.ValorDominioService;
import ar.com.clothes.util.SpringUtil;

public class BaseBean {
	private final static Logger LOG = Logger.getLogger(BaseBean.class);
	protected final static String USUARIO_WEB = "WEB_USER";
	protected final static String MENSAJE = "MENSAJE";
	protected final static String CONTEXTO = "CONTEXTO";

	private UsuarioService usuarioService;
	private ClienteService clienteService;
	private EmpresaService empresaService;
	private MedidaService medidaService;
	private ModeloService modeloService;
	private EncargoService encargoService;
	private PagoService pagoService;
	private ValorDominioService valorDominioService;
	private UsuarioRolService usuarioRolService;

	public BaseBean() {
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

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessageWarning(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
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
	 * @return the clienteService
	 */
	public ClienteService getClienteService() {
		if (clienteService == null) {
			clienteService = (ClienteService) SpringUtil.obtenerBeanSpring("clienteService");
		}
		return clienteService;
	}

	/**
	 * @param clienteService
	 *           the clienteService to set
	 */
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	/**
	 * @return the empresaService
	 */
	public EmpresaService getEmpresaService() {
		if (empresaService == null) {
			empresaService = (EmpresaService) SpringUtil.obtenerBeanSpring("empresaService");
		}
		return empresaService;
	}

	/**
	 * @param empresaService
	 *           the empresaService to set
	 */
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	/**
	 * @return the medidaService
	 */
	public MedidaService getMedidaService() {
		if (medidaService == null) {
			medidaService = (MedidaService) SpringUtil.obtenerBeanSpring("medidaService");
		}
		return medidaService;
	}

	/**
	 * @param medidaService
	 *           the medidaService to set
	 */
	public void setMedidaService(MedidaService medidaService) {
		this.medidaService = medidaService;
	}

	/**
	 * @return the modeloService
	 */
	public ModeloService getModeloService() {
		if (modeloService == null) {
			modeloService = (ModeloService) SpringUtil.obtenerBeanSpring("modeloService");
		}
		return modeloService;
	}

	/**
	 * @param modeloService
	 *           the modeloService to set
	 */
	public void setModeloService(ModeloService modeloService) {
		this.modeloService = modeloService;
	}

	/**
	 * @return the encargoService
	 */
	public EncargoService getEncargoService() {
		if (encargoService == null) {
			encargoService = (EncargoService) SpringUtil.obtenerBeanSpring("encargoService");
		}
		return encargoService;
	}

	/**
	 * @param encargoService
	 *           the encargoService to set
	 */
	public void setEncargoService(EncargoService encargoService) {
		this.encargoService = encargoService;
	}

	/**
	 * @return the pagoService
	 */
	public PagoService getPagoService() {
		if (pagoService == null) {
			pagoService = (PagoService) SpringUtil.obtenerBeanSpring("pagoService");
		}
		return pagoService;
	}

	/**
	 * @param pagoService
	 *           the pagoService to set
	 */
	public void setPagoService(PagoService pagoService) {
		this.pagoService = pagoService;
	}

	/**
	 * @return the valorDominioService
	 */
	public ValorDominioService getValorDominioService() {
		if (valorDominioService == null) {
			valorDominioService = (ValorDominioService) SpringUtil.obtenerBeanSpring("valorDominioService");
		}
		return valorDominioService;
	}

	/**
	 * @param valorDominioService
	 *           the valorDominioService to set
	 */
	public void setValorDominioService(ValorDominioService valorDominioService) {
		this.valorDominioService = valorDominioService;
	}

	public UsuarioRolService getUsuarioRolService() {
		if (usuarioRolService == null) {
			usuarioRolService = (UsuarioRolService) SpringUtil.obtenerBeanSpring("usuarioRolService");
		}
		return usuarioRolService;
	}

	public void setUsuarioRolService(UsuarioRolService usuarioRolService) {
		this.usuarioRolService = usuarioRolService;
	}

}
