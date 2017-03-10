package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.Rol;

public interface RolDao {

	List<Rol> findAll();

	Rol findById(Integer idRol);

	void save(Rol cliente);

	void deleteById(Integer idRol);

	void update(Rol rol);

}
