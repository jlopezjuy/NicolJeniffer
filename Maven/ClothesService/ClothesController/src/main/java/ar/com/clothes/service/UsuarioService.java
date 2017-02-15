package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Usuario;

/**
 * 
 * @author MostroBook
 *
 */
public interface UsuarioService {
	void saveUsuario(Usuario usuario);
	 
    List<Usuario> findAllUsuarios();
 
    void deleteUsuarioById(Integer usuarioId);
 
    Usuario findById(Integer usuarioId);
 
    void updateUsuario(Usuario usuario);
    
    Usuario findByUsuarioPassword(String username, String password);
}
