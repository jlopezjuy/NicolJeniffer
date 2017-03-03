package ar.com.clothes.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.com.clothes.dao.AbstractDao;
import ar.com.clothes.dao.UsuarioDao;
import ar.com.clothes.model.Usuario;

/**
 * 
 * @author MostroBook
 *
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl extends AbstractDao implements UsuarioDao {
	
	/**
	 * Metodo para guardar el usuario
	 */
	public void saveUsuario(Usuario usuario) {
		persist(usuario);
	}
	
	/**
	 * Metodo para obtener la lista de Usuarios
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {
		Criteria criteria = getSession().createCriteria(Usuario.class);
        return (List<Usuario>) criteria.list();
	}
	
	/**
	 * 
	 */
	public void deleteUsuarioById(Integer usuarioId) {
		Query query = getSession().createSQLQuery("delete from Usuario where idUsuario = :idUsuario");
        query.setInteger("idUsuario", usuarioId);
        query.executeUpdate();
	}
	
	/**
	 * 
	 */
	public Usuario findById(Integer usuarioId) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("idUsuario",usuarioId));
        return (Usuario) criteria.uniqueResult();
	}
	
	/**
	 * 
	 */
	public void updateUsuario(Usuario usuario) {
		getSession().update(usuario);
	}

	@Override
	public Usuario findByUsuarioPassword(String nombreUsuario, String password) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("nombreUsuario",nombreUsuario));
        criteria.add(Restrictions.eq("password",password));
        return (Usuario) criteria.uniqueResult();
	}
}