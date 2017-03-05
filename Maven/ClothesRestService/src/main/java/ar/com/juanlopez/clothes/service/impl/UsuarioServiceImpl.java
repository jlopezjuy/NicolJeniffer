package ar.com.juanlopez.clothes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ar.com.juanlopez.clothes.model.Usuario;
import ar.com.juanlopez.clothes.repository.EmpresaRepository;
import ar.com.juanlopez.clothes.repository.UsuarioRepository;
import ar.com.juanlopez.clothes.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	public List<Usuario> findAll() {
		logger.info("> findAll");

		List<Usuario> usuarios = usuarioRepository.findAll();

		logger.info("< findAll");
		return usuarios;
	}

	/**
	 * Persistiendo el usuario
	 */
	@Override
	public Usuario create(Usuario usuario) {
		logger.info("> create");
		Usuario usu = null;
		try {
			usuario.setEmpresa(empresaRepository.findOne(usuario.getEmpresaId()));
			usu = usuarioRepository.save(usuario);
			logger.info("< create");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return usu;
	}

	@Override
	public Usuario find(Long id) {
		logger.info("> Find");

		Usuario usu = usuarioRepository.findOne(id);

		logger.info("< Find");
		return usu;
	}

	@Override
	public Usuario update(Usuario usuario) {
		logger.info("> Update");

		Usuario usu = usuarioRepository.save(usuario);

		logger.info("< Update");
		return usu;
	}

	@Override
	public void delete(Long id) {
		logger.info("> Delete");

		usuarioRepository.delete(id);

		logger.info("< Delete");

	}

}
