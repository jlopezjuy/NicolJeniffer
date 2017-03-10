package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Rol;

/**
 * 
 * @author MostroBook
 *
 */
public interface RolService {
	List<Rol> findAll();

	Rol findById(Integer idRol);

	void save(Rol cliente);

	void deleteById(Integer idRol);

	void update(Rol rol);
}
