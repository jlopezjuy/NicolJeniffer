package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.PagoDao;
import ar.com.clothes.model.Encargo;
import ar.com.clothes.model.Pago;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("pagoDao")
public class PagoDaoImpl extends AbstractDao implements PagoDao {

	@Override
	public void savePago(Pago pago) {
		persist(pago);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> findAll() {
		Criteria criteria = getSession().createCriteria(Pago.class);
		return (List<Pago>) criteria.list();
	}

	@Override
	public void deletePagoById(Integer idPagos) {
		Query query = getSession().createSQLQuery("delete from Pagos where idPagos = :idPagos");
		query.setInteger("idPagos", idPagos);
		query.executeUpdate();
	}

	@Override
	public Pago findById(Integer idPagos) {
		Criteria criteria = getSession().createCriteria(Pago.class);
		criteria.add(Restrictions.eqOrIsNull("idPagos", idPagos));
		return (Pago) criteria.uniqueResult();
	}

	@Override
	public void updatePago(Pago pago) {
		getSession().update(pago);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> listarPagosEncargo(Encargo encargo) {
		Criteria criteria = getSession().createCriteria(Pago.class);
		criteria.add(Restrictions.eqOrIsNull("encargo.idEncargo", encargo.getIdEncargo()));
		return (List<Pago>) criteria.list();
	}
}
