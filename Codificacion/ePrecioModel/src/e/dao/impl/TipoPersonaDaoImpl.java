package e.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.TipoPersonaDao;
import e.dominio.TipoPersona;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class TipoPersonaDaoImpl extends DAOHibernateImpl<TipoPersona, Long> implements TipoPersonaDao {

	@Override
	public List<TipoPersona> listar(Long idVenta) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("idVenta", idVenta));
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public List<TipoPersona> obtenerExcluyendo(Long idVenta, List<Long> ids) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("idVenta", idVenta));
		criteria.add(Restrictions.not(Restrictions.in("id", ids)));
		return super.ejecutarCriteria(criteria);
	}

}
