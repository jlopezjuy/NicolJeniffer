package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.ModeloDao;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Modelo;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("modeloDao")
public class ModeloDaoImpl extends AbstractDao implements ModeloDao {

	@Override
	public void saveModelo(Modelo modelo) {
		persist(modelo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modelo> findAllModelo() {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		return (List<Modelo>) criteria.list();
	}

	@Override
	public void deleteModeloById(Integer idModelos) {
		Query query = getSession().createSQLQuery("delete from Modelos where idModelos = :idModelos");
		query.setInteger("idModelos", idModelos);
		query.executeUpdate();
	}

	@Override
	public Modelo findById(Integer idModelos) {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.add(Restrictions.eq("idModelos", idModelos));
		return (Modelo) criteria.uniqueResult();
	}

	@Override
	public void updateModelo(Modelo modelo) {
		getSession().update(modelo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modelo> listarModelo(Cliente cliente) {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.add(Restrictions.eq("cliente.idClientes", cliente.getIdClientes()));
		return (List<Modelo>) criteria.list();
	}

}
