package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.ModeloDao;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Modelo;
import ar.com.clothes.service.ModeloService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("modeloService")
@Transactional
public class ModeloServiceImpl implements ModeloService {
	@Autowired
	ModeloDao modeloDao;

	@Override
	public void saveModelo(Modelo modelo) {
		modeloDao.saveModelo(modelo);
	}

	@Override
	public List<Modelo> findAllModelo() {
		return modeloDao.findAllModelo();
	}

	@Override
	public void deleteModeloById(Integer idModelos) {
		modeloDao.deleteModeloById(idModelos);
	}

	@Override
	public Modelo findById(Integer idModelos) {
		return modeloDao.findById(idModelos);
	}

	@Override
	public void updateModelo(Modelo modelo) {
		modeloDao.updateModelo(modelo);
	}

	@Override
	public List<Modelo> listarModelo(Cliente cliente) {
		return modeloDao.listarModelo(cliente);
	}

}
