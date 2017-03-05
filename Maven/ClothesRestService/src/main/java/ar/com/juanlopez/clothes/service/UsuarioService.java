package ar.com.juanlopez.clothes.service;

import java.util.List;

import ar.com.juanlopez.clothes.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();

	Usuario create(Usuario usuario);

	Usuario find(Long id);

	Usuario update(Usuario usuario);

	void delete(Long id);
}
