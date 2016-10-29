package e.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.UsuarioDao;
import e.dominio.entity.Usuario;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class UsuarioDaoImpl extends DAOHibernateImpl<Usuario, Long> implements UsuarioDao {
	private final static Logger LOG = Logger.getLogger(UsuarioDaoImpl.class);

	@Override
	public Usuario verificar(String nombreUsuario, String password) {
		Criteria criteria = obtenerCriteria();
		criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
		criteria.add(Restrictions.eq("password", password));
		Usuario usuarioVerificado = ejecutarCriteriaUnica(criteria);
		LOG.debug("usuario: " + nombreUsuario + ", clave: " + password + ", resultado: " + usuarioVerificado);
		return usuarioVerificado;
	}

}
