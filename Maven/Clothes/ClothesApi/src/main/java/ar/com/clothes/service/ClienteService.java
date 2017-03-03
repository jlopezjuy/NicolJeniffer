package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Cliente;

/**
 * 
 * @author MostroBook
 *
 */
public interface ClienteService {

	void saveCliente(Cliente cliente);

	List<Cliente> findAllClientes();

	void deleteClienteById(Integer idClientes);

	Cliente findById(Integer idClientes);

	void updateCliente(Cliente cliente);

	List<Cliente> findByEmpresa(Integer idEmpresa);

	List<Cliente> findByNombre(String nombre);
}
