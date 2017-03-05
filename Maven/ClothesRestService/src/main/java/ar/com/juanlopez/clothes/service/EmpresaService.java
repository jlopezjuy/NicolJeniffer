package ar.com.juanlopez.clothes.service;

import java.util.List;

import ar.com.juanlopez.clothes.model.Empresa;

public interface EmpresaService {
	List<Empresa> findAll();

	Empresa create(Empresa empresa);

	Empresa find(Integer id);

	Empresa update(Empresa empresa);

	void delete(Integer id);
}
