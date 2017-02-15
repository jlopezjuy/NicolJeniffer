package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.MedidaDao;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.model.Medida;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("medidaDao")
public class MedidaDaoImpl extends AbstractDao implements MedidaDao {

	@Override
	public void saveMedida(Medida medida) {
		persist(medida);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medida> findAllMedida() {
		Criteria criteria = getSession().createCriteria(Medida.class);
        return (List<Medida>) criteria.list();
	}

	@Override
	public void deleteMedidaById(Integer idMedidas) {
		Query query = getSession().createSQLQuery("delete from Medidas where idMedidas = :idMedidas");
        query.setInteger("idMedidas", idMedidas);
        query.executeUpdate();
	}

	@Override
	public Medida findById(Integer idMedidas) {
		Criteria criteria = getSession().createCriteria(Medida.class);
        criteria.add(Restrictions.eq("idMedidas",idMedidas));
        return (Medida) criteria.uniqueResult();
	}

	@Override
	public void updateMedida(Medida medida) {
		getSession().update(medida);
	}

}
