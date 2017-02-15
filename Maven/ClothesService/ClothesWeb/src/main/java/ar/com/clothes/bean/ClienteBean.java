package ar.com.clothes.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.util.StringUtil;

@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);

	private Cliente cliente;
	private Cliente clienteSeleccionado;
	private int idClientes;
	private String nombre;
	private String apellido;
	private String celular;
	private String telefono;
	private String email;
	private String domicilio;
	private String colegio;
	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	private String nombreBusqueda;

	public ClienteBean() {
		super();
		try {
			listaClientes = getClienteService().findAllClientes();
			LOG.debug("ClienteBean cantidad de datos: " + listaClientes.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guardarNuevoCliente(ActionEvent ev) {
		LOG.debug("Entro en guardarNuevoCliente");
	}

	/**
	 * Metodo para guardar un cliente nuevo
	 * 
	 * @return
	 * @author jlopez
	 * @since 07/10/2015
	 * @version 1.0
	 */
	public String gurdarCliente() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Empresa empresa = (Empresa) context.getExternalContext().getSessionMap().get("empresa");
			cliente = new Cliente();
			cliente.setEmpresa(empresa);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setCelular(celular);
			cliente.setTelefono(telefono);
			cliente.setEmail(email);
			cliente.setDomicilio(domicilio);
			cliente.setColegio(colegio);
			getClienteService().saveCliente(cliente);
			LOG.info("guardo datos !!!!!!!!!!!!!");
			limpiarFormulario();
			busquedaCliente();
		} catch (Exception e) {
			LOG.error(e);
			return null;
		}
		return "listaClientesView";
	}

	/**
	 * Metodo para guardar un cliente nuevo
	 * 
	 * @return
	 * @author jlopez
	 * @since 07/10/2015
	 * @version 1.0
	 */
	public String gurdarClienteEncargo() {
		try {
			cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setCelular(celular);
			cliente.setTelefono(telefono);
			cliente.setEmail(email);
			cliente.setDomicilio(domicilio);
			cliente.setColegio(colegio);
			getClienteService().saveCliente(cliente);
			limpiarFormulario();
			busquedaCliente();
		} catch (Exception e) {
			LOG.error(e);
			return null;
		}
		return "altaEncargoView";
	}

	/**
	 * 
	 * @return
	 */
	public String editarCliente() {
		try {
			LOG.info("Colegio cambiado: " + clienteSeleccionado.getColegio());
			getClienteService().updateCliente(clienteSeleccionado);
			limpiarFormulario();
			busquedaCliente();
		} catch (Exception e) {
			LOG.error(e);
			return null;
		}
		return "listaClientesView";
	}

	/**
	 * Metodo para guardar un cliente nuevo
	 * 
	 * @return
	 * @author jlopez
	 * @since 07/10/2015
	 * @version 1.0
	 */
	public String cancelarCliente() {
		limpiarFormulario();
		return "listaClientesView";
	}

	/**
	 * Metodo para guardar un cliente nuevo
	 * 
	 * @return
	 * @author jlopez
	 * @since 07/10/2015
	 * @version 1.0
	 */
	public String cancelarClienteEncargo() {
		limpiarFormulario();
		return "altaEncargoView";
	}

	/**
	 * Metodo para limpiar el formulario luego de un alta exitosa
	 * 
	 * @author jlopez
	 * @since 07/10/2015
	 * @version 1.0
	 */
	private void limpiarFormulario() {
		nombre = "";
		apellido = "";
		celular = "";
		telefono = "";
		email = "";
		domicilio = "";
		colegio = "";
	}

	/**
	 * Metodo que se ejecuta cuando seleccionamos una fila
	 * 
	 * @param event
	 * @author jlopez
	 * @since 08/10/2015
	 * @version 1.0
	 */
	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Cliente Seleccionado: ", ((Cliente) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * Metodo que se ejecuta cuando des seleccionamos una fila
	 * 
	 * @param event
	 * @author jlopez
	 * @since 08/10/2015
	 * @version 1.0
	 */
	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected", ((Cliente) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void showPopUp() {
		LOG.debug("*****************entro a intentar mostrar el PopUp");
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", false);
		options.put("resizable", false);
		options.put("contentHeight", 320);

		RequestContext.getCurrentInstance().openDialog("altaClienteView", options, null);
	}

	public String busquedaCliente() {
		LOG.info("cliente a buscar: " + nombreBusqueda);
		if (StringUtil.esVacio(nombreBusqueda)) {
			setListaClientes(getClienteService().findAllClientes());
		} else {
			// TODO: implementar busqueda por nombre de cliente
			// setListaClientes(getClienteService().findClientes(nombreBusqueda));
		}
		return null;
	}

	public void destroyWorld() {
		addMessage("System Error", "Please try again later.");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public int getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	public Cliente getClienteSeleccionado() {
		LOG.debug("entro a obtener cliente seleccionado");
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		LOG.debug("entro a guardar cliente seleccionado");
		this.clienteSeleccionado = clienteSeleccionado;
	}

	public String getNombreBusqueda() {
		return nombreBusqueda;
	}

	public void setNombreBusqueda(String nombreBusqueda) {
		this.nombreBusqueda = nombreBusqueda;
	}
}
