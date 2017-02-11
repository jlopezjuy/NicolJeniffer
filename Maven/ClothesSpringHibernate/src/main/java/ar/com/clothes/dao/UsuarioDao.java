package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.Usuario;

/**
 * 
 * @author MostroBook
 *
 */
public interface UsuarioDao {
	void saveUsuario(Usuario usuario);
    
    List<Usuario> findAllUsuarios();
     
    void deleteUsuarioById(Integer usuarioId);
     
    Usuario findById(Integer usuarioId);
     
    void updateUsuario(Usuario usuario);
}
