package e.servicio.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import e.base.excepcion.ExcepcionServicio;
import e.dao.impl.MedidaDaoImpl;
import e.dominio.entity.Clientes;
import e.dominio.entity.Medidas;
import e.servicio.ServicioMedida;

public class ServicioMedidaImpl implements ServicioMedida {
	private final static Logger LOG = Logger.getLogger(ServicioClienteImpl.class);
	private SessionFactory sessionFactory;

	
	private MedidaDaoImpl medidaDao;
	
	@Override
	public void editarMedida(Medidas medida) throws ExcepcionServicio {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarMedida(Medidas medida) throws ExcepcionServicio {
		// TODO Auto-generated method stub
		LOG.debug("Entro a guardarMedida: "+medida.toString());
		medidaDao.guardarMedida(medida);
	}

	@Override
	public List<Medidas> listAll(Clientes cliente) {
		List<Medidas> list;
		try {
			list = medidaDao.listarMedidas(cliente);
			LOG.debug("//////ENCONTRO DATOS....: "+ list.size());
			return list;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
			return null;
		}
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MedidaDaoImpl getMedidaDao() {
		return medidaDao;
	}

	public void setMedidaDao(MedidaDaoImpl medidaDao) {
		this.medidaDao = medidaDao;
	}
	
	
}
