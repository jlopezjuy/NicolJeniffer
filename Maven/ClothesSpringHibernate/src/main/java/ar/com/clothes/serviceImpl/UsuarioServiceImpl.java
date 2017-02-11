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
