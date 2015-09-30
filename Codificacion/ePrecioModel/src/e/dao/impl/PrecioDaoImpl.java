package e.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import e.dao.PrecioDao;
import e.dominio.Precio;
import e.dto.busqueda.BusquedaPrecioDto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class PrecioDaoImpl extends DAOHibernateImpl<Precio, Long> implements PrecioDao {
	private final static Logger LOG = Logger.getLogger(PrecioDaoImpl.class);

	@Override
	public List<Precio> buscar(Date fechaInicial, Date fechaFinal) {
		List<Precio> ventas = new ArrayList<Precio>();
		Criteria criteria = obtenerCriteria();
		boolean restriccionAgregada = false;
		if (fechaInicial != null) {
			LOG.info("fechaDesde: " + fechaInicial);
			criteria.add(Restrictions.ge("fechaVenta", fechaInicial));
			restriccionAgregada = true;
		}
		if (fechaFinal != null) {
			LOG.info("fechaHasta: " + fechaFinal);
			criteria.add(Restrictions.le("fechaVenta", fechaFinal));
			restriccionAgregada = true;
		}
		if (restriccionAgregada) {
			criteria.addOrder(Order.asc("fechaVenta"));
			ventas = ejecutarCriteria(criteria);
		}
		LOG.debug("ventas: " + ventas);
		return ventas;
	}

	@Override
	public List<Precio> buscar(BusquedaPrecioDto busquedaPrecioDto) {
		LOG.debug("");
		Criteria criteria = super.obtenerCriteriaBaseId(busquedaPrecioDto);
		return ejecutarCriteria(criteria);
	}

}
