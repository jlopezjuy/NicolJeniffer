package e.dao.impl;

import org.apache.log4j.Logger;

import e.dao.TipoTransaccionDao;
import e.dominio.TipoTransaccion;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class TipoTransaccionDaoImpl extends DAOHibernateImpl<TipoTransaccion, Long> implements TipoTransaccionDao {
	private final static Logger LOG = Logger.getLogger(TipoTransaccionDaoImpl.class);

}
