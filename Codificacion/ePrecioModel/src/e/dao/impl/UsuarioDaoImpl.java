package e.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import e.dao.UsuarioDao;
import e.dominio.Usuario;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class UsuarioDaoImpl extends DAOHibernateImpl<Usuario, Long> implements UsuarioDao {
	private final static Logger LOG = Logger.getLogger(UsuarioDaoImpl.class);

	@Override
	public Usuario verificar(String usuario, String clave) {
		Criteria criteria = obtenerCriteria();
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("clave", clave));
		Usuario usuarioVerificado = ejecutarCriteriaUnica(criteria);
		LOG.debug("usuario: " + usuario + ", clave: " + clave + ", resultado: " + usuarioVerificado);
		return usuarioVerificado;
	}

}
