package e.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.MedidaDao;
import e.dominio.entity.Clientes;
import e.dominio.entity.Medidas;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class MedidaDaoImpl extends DAOHibernateImpl<Medidas, Long> implements MedidaDao {

	@Override
	public List<Medidas> buscarMedida(String medida) {
		// TODO Auto-generated method stub  medidas
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("clientes.nombre", medida));
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public List<Medidas> listarMedidas(Clientes cliente) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("clientes", cliente));
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public void guardarMedida(Medidas medida) {
		super.guardar(medida);
	}

}
