package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.base.util.NumberUtil;
import e.dao.UnidadDao;
import e.dominio.Unidad;
import e.dto.busqueda.BusquedaUnidadDto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class UnidadDaoImpl extends DAOHibernateImpl<Unidad, Long> implements UnidadDao {
	private final static Logger LOG = Logger.getLogger(UnidadDaoImpl.class);

	@Override
	public List<Unidad> buscar(BusquedaUnidadDto busquedaUnidadDto) {
		LOG.debug("");
		Criteria criteria = obtenerCriteriaBaseNombre(busquedaUnidadDto);
		if (!NumberUtil.esNuloOMenorQueUno(busquedaUnidadDto.getIdDimension())) {
			criteria.add(Restrictions.eq("idDimension", busquedaUnidadDto.getIdDimension()));
		}
		return ejecutarCriteria(criteria);
	}

}
