package e.dao.impl;

import org.apache.log4j.Logger;

import e.dao.TipoProductoDao;
import e.dominio.TipoProducto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class TipoProductoDaoImpl extends DAOHibernateImpl<TipoProducto, Long> implements TipoProductoDao {
	private final static Logger LOG = Logger.getLogger(TipoProductoDaoImpl.class);

}
