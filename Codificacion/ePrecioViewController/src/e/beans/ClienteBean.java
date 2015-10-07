package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;

public class ClienteBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);

	private Clientes cliente;
	private int idClientes;
	private String nombre;
	private String apellido;
	private String celular;
	private String telefono;
	private String email;
	private String domicilio;
	private List<Clientes> listaClientes = new ArrayList<Clientes>();

	public ClienteBean() {
		super();
	}

	public void guardarNuevoCliente(ActionEvent ev) {
		LOG.debug("Entro en guardarNuevoCliente");

	}
	
	/**
	 * Metodo para guardar un cliente nuevo
	 * @return 
	 * @author jlopez
	 * @since 07/10/2015
	 * @version 1.0
	 */
	public String gurdarCliente() {
		try {
			cliente = new Clientes();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setCelular(celular);
			cliente.setTelefono(telefono);
			cliente.setEmail(email);
			cliente.setDomicilio(domicilio);

			getServicioCliente().guardarCliente(cliente);
			limpiarFormulario();
		} catch (ExcepcionServicio e) {
			LOG.error(e);
			return null;

		}
		return "listaClientesView";
	}
	
	/**
	 * Metodo para limpiar el formulario 
	 * luego de un alta exitosa
	 * @author jlopez
	 * @since 07/10/2015
	 * @version 1.0
	 */
	private void limpiarFormulario(){
		nombre = "";
		apellido = "";
		celular = "";
		telefono = "";
		email = "";
		domicilio = "";
	}
	
	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Clientes> getListaClientes() {
		try {
			listaClientes = getServicioCliente().listAll();
			LOG.debug("cantidad de datos: " + listaClientes.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaClientes;
	}

	public void setListaClientes(List<Clientes> listaClientes) {
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

}
