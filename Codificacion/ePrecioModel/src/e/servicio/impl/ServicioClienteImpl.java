package e.servicio.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import e.base.excepcion.ExcepcionBaseDeDato;
import e.base.excepcion.ExcepcionServicio;
import e.dao.ClienteDao;
import e.dao.impl.ClienteDaoImpl;
import e.dominio.entity.Clientes;
import e.dto.dominio.ClienteDto;
import e.servicio.ServicioCliente;

public class ServicioClienteImpl implements ServicioCliente {
	private final static Logger LOG = Logger.getLogger(ServicioClienteImpl.class);
	private SessionFactory sessionFactory;

	private ServicioDtoImpl servicioDto;
	private ServicioValidacionImpl servicioValidacion = new ServicioValidacionImpl();
	
	private ClienteDaoImpl clienteDao;
	
	
	
	@Override
	public List<Clientes> listAll() {
		List<Clientes> list;
		try {
			list = clienteDao.listarClientes();
			LOG.debug("//////ENCONTRO DATOS....: "+ list.size());
			//return servicioDto.getClienteDTO(list);
			return list;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
			return null;
		}
	}

	public ClienteDaoImpl getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDaoImpl clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setServicioDto(ServicioDtoImpl servicioDto) {
		this.servicioDto = servicioDto;
	}

	@Override
	public void editarCliente(Clientes cliente) throws ExcepcionServicio {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCliente(Clientes cliente) throws ExcepcionServicio {
		// TODO Auto-generated method stub
		LOG.debug("Entro a guardarCliente: "+cliente.toString());
		clienteDao.guardarCliente(cliente);
	}

}
