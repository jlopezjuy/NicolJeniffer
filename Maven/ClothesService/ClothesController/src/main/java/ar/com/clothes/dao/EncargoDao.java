package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.model.Encargo;

public interface EncargoDao {

	void saveEncargo(Encargo encargo);

	List<Encargo> findAllEncargos();

	void deleteEncargoById(Integer idEncargo);

	Encargo findById(Integer idEncargo);

	void updateEncargo(Encargo encargo);

	List<Encargo> listarEncargosByCliente(Cliente cliente);

	List<Encargo> listarEncargosByEmpresa(Empresa empresa);
}
