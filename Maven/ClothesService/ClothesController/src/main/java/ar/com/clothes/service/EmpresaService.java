package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Empresa;

/**
 * 
 * @author MostroBook
 *
 */
public interface EmpresaService {
	void saveEmpresa(Empresa empresa);

	List<Empresa> findAllEmpresa();

	void deleteEmpresaById(Integer idEmpresa);

	Empresa findById(Integer idEmpresa);

	void updateEmpresa(Empresa empresa);

	List<Empresa> findByNombre(String nombre);
}
