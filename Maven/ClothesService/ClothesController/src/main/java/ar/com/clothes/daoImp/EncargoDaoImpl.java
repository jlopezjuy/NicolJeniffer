package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.EncargoDao;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Encargo;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("encargoDao")
public class EncargoDaoImpl extends AbstractDao implements EncargoDao {

	@Override
	public void saveEncargo(Encargo encargo) {
		persist(encargo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Encargo> findAllEncargos() {
		Criteria criteria = getSession().createCriteria(Encargo.class);
		return (List<Encargo>) criteria.list();
	}

	@Override
	public void deleteEncargoById(Integer idEncargo) {
		Query query = getSession().createSQLQuery("delete from Encargos where idEncargo = :idEncargo");
		query.setInteger("idEncargo", idEncargo);
		query.executeUpdate();
	}

	@Override
	public Encargo findById(Integer idEncargo) {
		Criteria criteria = getSession().createCriteria(Encargo.class);
		criteria.add(Restrictions.eq("idEncargo", idEncargo));
		return (Encargo) criteria.uniqueResult();
	}

	@Override
	public void updateEncargo(Encargo encargo) {
		getSession().update(encargo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Encargo> listarEncargosByCliente(Cliente cliente) {
		Criteria criteria = getSession().createCriteria(Encargo.class);
		criteria.add(Restrictions.eq("cliente.idClientes", cliente.getIdClientes()));
		return (List<Encargo>) criteria.list();
	}

}
