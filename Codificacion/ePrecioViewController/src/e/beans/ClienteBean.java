package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;
import e.dto.dominio.ClienteDto;

public class ClienteBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);

	private Clientes cliente;
	private List<Clientes> listaClientes = new ArrayList<Clientes>();
	
	public ClienteBean(){
		super();
	}
	
	public void guardarNuevoCliente(ActionEvent ev) {
		LOG.info("");
		try {
			getServicioCliente().guardarCliente(cliente);

		} catch (ExcepcionServicio e) {
			LOG.error(e);

		}
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
			LOG.debug("cantidad de datos: "+listaClientes.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	public void setListaClientes(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
