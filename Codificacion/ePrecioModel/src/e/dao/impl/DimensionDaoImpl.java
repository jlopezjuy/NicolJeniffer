package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;

import e.dao.DimensionDao;
import e.dominio.Dimension;
import e.dto.busqueda.BusquedaDimensionDto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class DimensionDaoImpl extends DAOHibernateImpl<Dimension, Long> implements DimensionDao {
	private final static Logger LOG = Logger.getLogger(DimensionDaoImpl.class);

	@Override
	public List<Dimension> buscar(BusquedaDimensionDto busquedaDimensionDto) {
		LOG.debug("");
		Criteria criteria = obtenerCriteriaBaseNombre(busquedaDimensionDto);		
		return ejecutarCriteria(criteria);
	}

}
