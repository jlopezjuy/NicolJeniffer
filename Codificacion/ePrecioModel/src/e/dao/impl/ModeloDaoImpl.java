package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.ModeloDao;
import e.dominio.entity.*;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class ModeloDaoImpl extends DAOHibernateImpl<Modelos, Long> implements ModeloDao {
	private static final Logger LOG = Logger.getLogger(ModeloDaoImpl.class);
	@Override
	public List<Modelos> buscarNombreImagen(String nombreImagen) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("nombreModelo", nombreImagen));
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public List<Modelos> listarModelos(Clientes cliente) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("clientes", cliente));
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public void guardarModelo(Modelos modelo) {
		super.guardar(modelo);
	}

	@Override
	public Modelos findById(int idModelos) {
		Criteria criteria = obtenerCriteria();
		criteria.add(Restrictions.eq("idModelos", idModelos));
		Modelos usuarioVerificado = ejecutarCriteriaUnica(criteria);
		LOG.debug("resultado: " + usuarioVerificado.toString());
		return usuarioVerificado;
	}

	

}
