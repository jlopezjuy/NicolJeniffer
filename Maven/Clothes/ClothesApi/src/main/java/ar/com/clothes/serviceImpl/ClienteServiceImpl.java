package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.ClienteDao;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.service.ClienteService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDao clienteDao;

	@Override
	public void saveCliente(Cliente cliente) {
		clienteDao.saveCliente(cliente);
	}

	@Override
	public List<Cliente> findAllClientes() {
		return clienteDao.findAllClientes();
	}

	@Override
	public void deleteClienteById(Integer idClientes) {
		clienteDao.deleteClienteById(idClientes);
	}

	@Override
	public Cliente findById(Integer idClientes) {
		return clienteDao.findById(idClientes);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		clienteDao.updateCliente(cliente);
	}

	@Override
	public List<Cliente> findByEmpresa(Integer idEmpresa) {
		return clienteDao.findByEmpresa(idEmpresa);
	}

	@Override
	public List<Cliente> findByNombre(String nombre) {
		return clienteDao.findByNombre(nombre);
	}

}
