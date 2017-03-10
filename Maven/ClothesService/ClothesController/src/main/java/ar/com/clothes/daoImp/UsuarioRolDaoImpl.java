package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.UsuarioRolDao;
import ar.com.clothes.model.Usuario;
import ar.com.clothes.model.UsuarioRol;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("usuarioRolDao")
public class UsuarioRolDaoImpl extends AbstractDao implements UsuarioRolDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioRol> findByUsuario(Usuario usuario) {
		Criteria criteria = getSession().createCriteria(UsuarioRol.class);
		criteria.add(Restrictions.eq("usuario.idUsuario", usuario.getIdUsuario()));
		return (List<UsuarioRol>) criteria.list();
	}

}
