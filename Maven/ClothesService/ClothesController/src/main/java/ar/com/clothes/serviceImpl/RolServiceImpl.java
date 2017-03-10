package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.RolDao;
import ar.com.clothes.model.Rol;
import ar.com.clothes.service.RolService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("rolService")
@Transactional
public class RolServiceImpl implements RolService {
	@Autowired
	RolDao rolDao;

	@Override
	public List<Rol> findAll() {
		return rolDao.findAll();
	}

	@Override
	public Rol findById(Integer idRol) {
		return rolDao.findById(idRol);
	}

	@Override
	public void save(Rol rol) {
		rolDao.save(rol);
	}

	@Override
	public void deleteById(Integer idRol) {
		rolDao.deleteById(idRol);
	}

	@Override
	public void update(Rol rol) {
		rolDao.update(rol);
	}

}
