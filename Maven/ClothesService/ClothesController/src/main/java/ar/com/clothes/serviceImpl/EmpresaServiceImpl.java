package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.EmpresaDao;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.service.EmpresaService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("empresaService")
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	EmpresaDao empresaDao;

	@Override
	public void saveEmpresa(Empresa empresa) {
		empresaDao.saveEmpresa(empresa);
	}

	@Override
	public List<Empresa> findAllEmpresa() {
		return empresaDao.findAllEmpresa();
	}

	@Override
	public void deleteEmpresaById(Integer idEmpresa) {
		empresaDao.deleteEmpresaById(idEmpresa);
	}

	@Override
	public Empresa findById(Integer idEmpresa) {
		return empresaDao.findById(idEmpresa);
	}

	@Override
	public void updateEmpresa(Empresa empresa) {
		empresaDao.updateEmpresa(empresa);
	}

	@Override
	public List<Empresa> findByNombre(String nombre) {
		return empresaDao.findByNombre(nombre);
	}

}
