package e.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import e.dto.dominio.ClienteDto;

public class ClienteBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);

	private ClienteDto cliente;
	private List<ClienteDto> listaClientes = new ArrayList<ClienteDto>();
	
	public ClienteBean(){
		super();
	}
	
	public ClienteDto getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
	public List<ClienteDto> getListaClientes() {
		try {
			listaClientes = getServicioPrecio().listAll();
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
