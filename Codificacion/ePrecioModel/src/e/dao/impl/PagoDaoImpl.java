package e.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.PagoDao;
import e.dominio.entity.Encargos;
import e.dominio.entity.Pagos;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class PagoDaoImpl extends DAOHibernateImpl<Pagos, Long> implements PagoDao {

	@Override
	public List<Pagos> buscarFechaPago(Date fechaPago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagos> listarPagos(Encargos encargo) {
		Criteria criteria = super.obtenerCriteria();
		criteria.add(Restrictions.eq("encargos", encargo));
		return super.ejecutarCriteria(criteria);
	}

	@Override
	public void guardarPago(Pagos pago) {
		super.guardar(pago);
	}

	@Override
	public Pagos findById(int idModelo) {
		// TODO Auto-generated method stub
		return null;
	}



}
