package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.EmpresaDao;
import ar.com.clothes.model.Empresa;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("empresaDao")
public class EmpresaDaoImpl extends AbstractDao implements EmpresaDao {

	@Override
	public void saveEmpresa(Empresa empresa) {
		persist(empresa);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> findAllEmpresa() {
		Criteria criteria = getSession().createCriteria(Empresa.class);
		return (List<Empresa>) criteria.list();
	}

	@Override
	public void deleteEmpresaById(Integer idEmpresa) {
		Query query = getSession().createSQLQuery("delete from Empresa where idEmpresa = :idEmpresa");
		query.setInteger("idEmpresa", idEmpresa);
		query.executeUpdate();
	}

	@Override
	public Empresa findById(Integer idEmpresa) {
		Criteria criteria = getSession().createCriteria(Empresa.class);
		criteria.add(Restrictions.eq("idEmpresa", idEmpresa));
		return (Empresa) criteria.uniqueResult();
	}

	@Override
	public void updateEmpresa(Empresa empresa) {
		getSession().update(empresa);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> findByNombre(String nombre) {
		Criteria criteria = getSession().createCriteria(Empresa.class);
		criteria.add(Restrictions.ilike("nombreEmpresa", nombre, MatchMode.ANYWHERE));
		return (List<Empresa>) criteria.list();
	}

}
