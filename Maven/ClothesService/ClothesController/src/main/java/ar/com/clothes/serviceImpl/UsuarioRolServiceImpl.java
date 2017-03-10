package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.UsuarioRolDao;
import ar.com.clothes.model.Usuario;
import ar.com.clothes.model.UsuarioRol;
import ar.com.clothes.service.UsuarioRolService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("usuarioRolService")
@Transactional
public class UsuarioRolServiceImpl implements UsuarioRolService {
	@Autowired
	UsuarioRolDao usuarioRolDao;

	@Override
	public List<UsuarioRol> findByUsuario(Usuario usuario) {
		return usuarioRolDao.findByUsuario(usuario);
	}

}
