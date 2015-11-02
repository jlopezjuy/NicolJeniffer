package e.servicio.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import e.base.excepcion.ExcepcionServicio;
import e.dao.impl.ModeloDaoImpl;
import e.dominio.entity.Clientes;
import e.dominio.entity.Modelos;
import e.servicio.ServicioModelo;

public class ServicioModeloImpl implements ServicioModelo {
	private final static Logger LOG = Logger.getLogger(ServicioModeloImpl.class);
	private SessionFactory sessionFactory;

	private ServicioDtoImpl servicioDto;
	private ServicioValidacionImpl servicioValidacion = new ServicioValidacionImpl();
	private ModeloDaoImpl modeloDao;
	@Override
	public void editarModelo(Modelos cliente) throws ExcepcionServicio {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarModelo(Modelos modelo) throws ExcepcionServicio {
		LOG.debug("Entro a guardar Modelo: "+modelo.toString());
		modeloDao.guardarModelo(modelo);
	}

	@Override
	public List<Modelos> listAll(Clientes cliente) {
		List<Modelos> list;
		try {
			list = modeloDao.listarModelos(cliente);
			LOG.debug("//////ENCONTRO DATOS....: "+ list.size());
			//return servicioDto.getClienteDTO(list);
			return list;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
			return null;
		}
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setServicioDto(ServicioDtoImpl servicioDto) {
		this.servicioDto = servicioDto;
	}

	public ModeloDaoImpl getModeloDao() {
		return modeloDao;
	}

	public void setModeloDao(ModeloDaoImpl modeloDao) {
		this.modeloDao = modeloDao;
	}

	@Override
	public Modelos findById(int idModelos) {
		return modeloDao.findById(idModelos);
	}
	
	

}
