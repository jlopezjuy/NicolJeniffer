package e.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionBaseDeDato;
import e.dao.ClienteDao;
import e.dao.impl.ClienteDaoImpl;
import e.dominio.entity.Clientes;

public class ClienteBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(ClienteBean.class);
	private static final ClienteDao clienteDao = new ClienteDaoImpl();
	private Clientes cliente;
	private List<Clientes> listaClientes = new ArrayList<Clientes>();
	
	public ClienteBean(){
		
	}
	
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public List<Clientes> getListaClientes() {
		try {
			listaClientes = clienteDao.listar();
		} catch (ExcepcionBaseDeDato e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	public void setListaClientes(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
