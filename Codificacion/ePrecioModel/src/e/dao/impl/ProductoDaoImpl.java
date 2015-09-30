package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;

import e.dao.ProductoDao;
import e.dominio.Producto;
import e.dto.busqueda.BusquedaProductoDto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class ProductoDaoImpl extends DAOHibernateImpl<Producto, Long> implements ProductoDao {
	private final static Logger LOG = Logger.getLogger(ProductoDaoImpl.class);

	@Override
	public List<Producto> buscar(BusquedaProductoDto busquedaProductoDto) {
		LOG.debug("");
		Criteria criteria = obtenerCriteriaBaseNombre(busquedaProductoDto);
		return ejecutarCriteria(criteria);
	}

}
