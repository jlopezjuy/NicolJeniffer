package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;

import e.dao.MarcaDao;
import e.dominio.Marca;
import e.dto.busqueda.BusquedaMarcaDto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class MarcaDaoImpl extends DAOHibernateImpl<Marca, Long> implements MarcaDao {
	private final static Logger LOG = Logger.getLogger(MarcaDaoImpl.class);

	@Override
	public List<Marca> buscar(BusquedaMarcaDto busquedaMarcaDto) {
		LOG.debug("");
		Criteria criteria = super.obtenerCriteriaBaseNombre(busquedaMarcaDto);
		return ejecutarCriteria(criteria);
	}
}
