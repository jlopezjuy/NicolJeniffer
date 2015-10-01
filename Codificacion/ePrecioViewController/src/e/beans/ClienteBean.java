package e.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import e.dominio.entity.Clientes;

public class ClienteBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);
	private Clientes cliente;
	private List<Clientes> listaClientes = new ArrayList<Clientes>();
	
	
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public List<Clientes> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
