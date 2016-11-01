package e.servicio.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import e.base.excepcion.ExcepcionBaseDeDato;
import e.base.excepcion.ExcepcionServicio;
import e.dao.EncargoDao;
import e.dominio.entity.Clientes;
import e.dominio.entity.Encargos;
import e.servicio.ServicioEncargo;

public class ServicioEncargoImpl implements ServicioEncargo {
	private final static Logger LOG = Logger
			.getLogger(ServicioEncargoImpl.class);
	private SessionFactory sessionFactory;

	private EncargoDao encargoDao;

	@Override
	public void editarEncargo(Encargos encargo) throws ExcepcionServicio {
		encargoDao.editarEncargo(encargo);
	}

	@Override
	public void eliminarEncargo(Encargos encargo) throws ExcepcionServicio {
		encargoDao.eliminarEncargo(encargo);
	}

	@Override
	public void guardarEncargo(Encargos encargo) throws ExcepcionServicio {
		encargoDao.guardarEncargo(encargo);
	}

	@Override
	public List<Encargos> listAll() {
		List<Encargos> list;
		try {
			list = encargoDao.listarEncargos();
			LOG.debug("//////ENCONTRO DATOS....: "+ list.size());
			return list;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Encargos> findEncargo(Date fechaEncargo, Clientes clientes) {
		return encargoDao.buscarEncargos(fechaEncargo, clientes);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public EncargoDao getEncargoDao() {
		return encargoDao;
	}

	public void setEncargoDao(EncargoDao encargoDao) {
		this.encargoDao = encargoDao;
	}

}
