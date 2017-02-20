package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.model.Encargo;

/**
 * 
 * @author MostroBook
 *
 */
public interface EncargoService {

	void saveEncargo(Encargo encargo);

	List<Encargo> findAllEncargos();

	void deleteEncargoById(Integer idEncargo);

	Encargo findById(Integer idEncargo);

	void updateEncargo(Encargo encargo);

	List<Encargo> listarEncargosByCliente(Cliente cliente);

	List<Encargo> listarEncargosByEmpresa(Empresa empresa);
}
