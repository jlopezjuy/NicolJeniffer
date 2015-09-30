package e.dao.impl;

import org.apache.log4j.Logger;

import e.dao.TransaccionItemDao;
import e.dominio.TransaccionItem;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class TransaccionItemDaoImpl extends DAOHibernateImpl<TransaccionItem, Long> implements TransaccionItemDao {
	private final static Logger LOG = Logger.getLogger(TransaccionItemDaoImpl.class);

}
