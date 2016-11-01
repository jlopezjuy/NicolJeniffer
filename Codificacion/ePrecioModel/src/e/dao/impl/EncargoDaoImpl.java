package e.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.EncargoDao;
import e.dominio.entity.Clientes;
import e.dominio.entity.Encargos;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class EncargoDaoImpl extends DAOHibernateImpl<Encargos, Long> implements EncargoDao {
	private static final Logger LOG = Logger.getLogger(EncargoDaoImpl.class);
	
	@Override
	public List<Encargos> buscarEncargos(Date fechaEncargo, Clientes clientes) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("clientes", clientes));
		criteria.add(Restrictions.eq("fechaEncargo", fechaEncargo));
		LOG.info("buscando clientes con nombre similares:"+clientes.getNombre());
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public List<Encargos> listarEncargos() {
		Criteria criteria = super.obtenerCriteria();
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public void guardarEncargo(Encargos encargo) {
		super.guardar(encargo);
	}

	@Override
	public void editarEncargo(Encargos encargo) {
		super.editar(encargo);
	}

	@Override
	public void eliminarEncargo(Encargos encargo) {
		super.eliminar(encargo);
	}

	

}
