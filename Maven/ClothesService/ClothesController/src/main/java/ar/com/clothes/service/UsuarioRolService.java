package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Usuario;
import ar.com.clothes.model.UsuarioRol;

/**
 * 
 * @author MostroBook
 *
 */
public interface UsuarioRolService {
	List<UsuarioRol> findByUsuario(Usuario usuario);
}
