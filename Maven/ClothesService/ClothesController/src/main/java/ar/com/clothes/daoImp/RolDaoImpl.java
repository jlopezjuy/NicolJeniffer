package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.RolDao;
import ar.com.clothes.model.Rol;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("rolDao")
public class RolDaoImpl extends AbstractDao implements RolDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> findAll() {
		Criteria criteria = getSession().createCriteria(Rol.class);
		return (List<Rol>) criteria.list();
	}

	@Override
	public Rol findById(Integer idRol) {
		Criteria criteria = getSession().createCriteria(Rol.class);
		criteria.add(Restrictions.eq("idRol", idRol));
		return (Rol) criteria.uniqueResult();
	}

	@Override
	public void save(Rol rol) {
		this.save(rol);
	}

	@Override
	public void deleteById(Integer idRol) {
		Query query = getSession().createSQLQuery("delete from Rol where idRol = :idRol");
		query.setInteger("idRol", idRol);
		query.executeUpdate();
	}

	@Override
	public void update(Rol rol) {
		this.update(rol);
	}

}
