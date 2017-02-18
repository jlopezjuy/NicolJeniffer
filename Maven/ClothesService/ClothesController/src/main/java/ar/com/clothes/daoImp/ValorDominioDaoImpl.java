package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.ValorDominioDao;
import ar.com.clothes.model.ValorDominio;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("valorDominioDao")
public class ValorDominioDaoImpl extends AbstractDao implements ValorDominioDao {

	@Override
	public void saveValorDominio(ValorDominio valorDominio) {
		persist(valorDominio);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ValorDominio> findAll() {
		Criteria criteria = getSession().createCriteria(ValorDominio.class);
		return (List<ValorDominio>) criteria.list();
	}

	@Override
	public void deleteValorDominioById(Integer idValorDominio) {
		Query query = getSession().createSQLQuery("delete from ValorDominio where idValorDominio = :idValorDominio");
		query.setInteger("idValorDominio", idValorDominio);
		query.executeUpdate();
	}

	@Override
	public ValorDominio findById(Integer idValorDominio) {
		Criteria criteria = getSession().createCriteria(ValorDominio.class);
		criteria.add(Restrictions.eqOrIsNull("idValorDominio", idValorDominio));
		return (ValorDominio) criteria.uniqueResult();
	}

	@Override
	public void updateValorDominio(ValorDominio valorDominio) {
		getSession().update(valorDominio);
	}

}
