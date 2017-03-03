package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.UsuarioDao;
import ar.com.clothes.model.Usuario;
import ar.com.clothes.service.UsuarioService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioDao usuarioDao;

	public void saveUsuario(Usuario usuario) {
		usuarioDao.saveUsuario(usuario);
	}

	public List<Usuario> findAllUsuarios() {
		return usuarioDao.findAllUsuarios();
	}

	public void deleteUsuarioById(Integer usuarioId) {
		usuarioDao.deleteUsuarioById(usuarioId);
	}

	public Usuario findById(Integer usuarioId) {
		return usuarioDao.findById(usuarioId);
	}

	public void updateUsuario(Usuario usuario) {
		usuarioDao.updateUsuario(usuario);
	}

	@Override
	public Usuario findByUsuarioPassword(String username, String password) {
		return usuarioDao.findByUsuarioPassword(username, password);
	}
}