package e.dao.impl;

import org.apache.log4j.Logger;

import e.dao.TransaccionDao;
import e.dominio.Transaccion;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class TransaccionDaoImpl extends DAOHibernateImpl<Transaccion, Long> implements TransaccionDao {
	private final static Logger LOG = Logger.getLogger(TransaccionDaoImpl.class);

}
