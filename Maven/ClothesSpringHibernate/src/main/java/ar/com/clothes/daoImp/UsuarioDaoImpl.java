package ar.com.clothes.daoImp;

import java.util.List;

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

	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	public List<Usuario> findAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUsuarioById(Integer usuarioId) {
		// TODO Auto-generated method stub

	}

	public Usuario findById(Integer usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

}
