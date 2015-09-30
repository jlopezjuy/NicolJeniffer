package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;

import e.dao.EstadoTransaccionDao;
import e.dominio.EstadoTransaccion;
import e.dto.busqueda.BusquedaEstadoTransaccionDto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class EstadoTransaccionDaoImpl extends DAOHibernateImpl<EstadoTransaccion, Long> implements EstadoTransaccionDao {
	private Logger LOG = Logger.getLogger(EstadoTransaccionDaoImpl.class);

	@Override
	public List<EstadoTransaccion> buscar(BusquedaEstadoTransaccionDto busquedaEstadoTransaccionDto) {
		LOG.debug("");
		Criteria criteria = obtenerCriteriaBaseNombre(busquedaEstadoTransaccionDto);
		return ejecutarCriteria(criteria);
	}

}
