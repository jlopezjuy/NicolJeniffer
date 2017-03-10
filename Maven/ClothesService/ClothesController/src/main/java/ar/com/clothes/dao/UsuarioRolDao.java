package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.Usuario;
import ar.com.clothes.model.UsuarioRol;

/**
 * 
 * @author MostroBook
 *
 */
public interface UsuarioRolDao {
	List<UsuarioRol> findByUsuario(Usuario usuario);
}
