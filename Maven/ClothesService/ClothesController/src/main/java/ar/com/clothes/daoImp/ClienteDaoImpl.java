package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.ClienteDao;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Empresa;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("clienteDao")
public class ClienteDaoImpl extends AbstractDao implements ClienteDao {

	@Override
	public void saveCliente(Cliente cliente) {
		persist(cliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAllClientes() {
		Criteria criteria = getSession().createCriteria(Cliente.class);
		return (List<Cliente>) criteria.list();
	}

	@Override
	public void deleteClienteById(Integer idClientes) {
		Query query = getSession().createSQLQuery("delete from Clientes where idClientes = :idClientes");
		query.setInteger("idClientes", idClientes);
		query.executeUpdate();
	}

	@Override
	public Cliente findById(Integer idClientes) {
		Criteria criteria = getSession().createCriteria(Empresa.class);
		criteria.add(Restrictions.eq("idClientes", idClientes));
		return (Cliente) criteria.uniqueResult();
	}

	@Override
	public void updateCliente(Cliente cliente) {
		getSession().update(cliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findByEmpresa(Integer idEmpresa) {
		Criteria criteria = getSession().createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("empresa.idEmpresa", idEmpresa));
		return (List<Cliente>) criteria.list();
	}

}
