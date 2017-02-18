package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.EncargoDao;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Encargo;
import ar.com.clothes.service.EncargoService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("encargoService")
@Transactional
public class EncargoServiceImpl implements EncargoService {

	@Autowired
	EncargoDao encargoDao;

	@Override
	public void saveEncargo(Encargo encargo) {
		encargoDao.saveEncargo(encargo);
	}

	@Override
	public List<Encargo> findAllEncargos() {
		return encargoDao.findAllEncargos();
	}

	@Override
	public void deleteEncargoById(Integer idEncargo) {
		encargoDao.deleteEncargoById(idEncargo);
	}

	@Override
	public Encargo findById(Integer idEncargo) {
		return encargoDao.findById(idEncargo);
	}

	@Override
	public void updateEncargo(Encargo encargo) {
		encargoDao.updateEncargo(encargo);
	}

	@Override
	public List<Encargo> listarEncargosByCliente(Cliente cliente) {
		return encargoDao.listarEncargosByCliente(cliente);
	}

}
