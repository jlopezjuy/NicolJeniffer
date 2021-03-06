package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.ClienteDao;
import e.dominio.entity.Clientes;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class ClienteDaoImpl extends DAOHibernateImpl<Clientes, Long> implements ClienteDao {
	private static final Logger LOG = Logger.getLogger(ClienteDaoImpl.class);

	@Override
	public List<Clientes> buscarNombreCliente(String nombreCliente) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("nombre", nombreCliente));
		LOG.info("buscando clientes con nombre similares:"+nombreCliente);
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

	@Override
	public void editarCiente(Clientes cliente) {
		super.editar(cliente);
	}

	@Override
	public void eliminarCliente(Clientes cliente) {
		super.eliminar(cliente);
	}



	@Override
	public Clientes findById(int idCliente) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("idClientes", idCliente));
		LOG.info("buscando clientes con nombre similares:"+idCliente);
		return super.ejecutarCriteriaUnica(criteria);
	}

}
