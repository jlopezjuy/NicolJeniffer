package e.servicio.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import e.base.excepcion.ExcepcionServicio;
import e.dao.PagoDao;
import e.dominio.entity.Encargos;
import e.dominio.entity.Pagos;
import e.servicio.ServicioPago;

public class ServicioPagoImpl implements ServicioPago {
	private final static Logger LOG = Logger.getLogger(ServicioPagoImpl.class);
	private SessionFactory sessionFactory;
	
	private PagoDao pagoDao;
	@Override
	public void editarPago(Pagos pago) throws ExcepcionServicio {
		
	}

	@Override
	public void guardarPago(Pagos pago) throws ExcepcionServicio {
		pagoDao.guardarPago(pago);
	}

	@Override
	public List<Pagos> listAll(Encargos encargo) {
		List<Pagos> list;
		try {
			list = pagoDao.listarPagos(encargo);
			LOG.debug("//////CLIENTE ENCONTRO DATOS....: "+ list.size());
			//return servicioDto.getClienteDTO(list);
			return list;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Pagos findById(int idPago) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public PagoDao getPagoDao() {
		return pagoDao;
	}

	public void setPagoDao(PagoDao pagoDao) {
		this.pagoDao = pagoDao;
	}
	

}
