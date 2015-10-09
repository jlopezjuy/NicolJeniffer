package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.ClienteDao;
import e.dominio.entity.Clientes;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class ClienteDaoImpl extends DAOHibernateImpl<Clientes, Long> implements ClienteDao {
	private Logger LOG = Logger.getLogger(ClienteDaoImpl.class);

	@Override
	public List<Clientes> buscarNombreCliente(String nombreCliente) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("nombre", nombreCliente));
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public List<Clientes> listarClientes() {
		Criteria criteria = super.obtenerCriteria();
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public void guardarCliente(Clientes cliente) {
		super.guardar(cliente);
	}

}
