package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dto.dominio.ClienteDto;

public class ClienteBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);

	private ClienteDto cliente;
	private List<ClienteDto> listaClientes = new ArrayList<ClienteDto>();
	
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
	
	public ClienteDto getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
	public List<ClienteDto> getListaClientes() {
		try {
			listaClientes = getServicioCliente().listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	public void setListaClientes(List<ClienteDto> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
