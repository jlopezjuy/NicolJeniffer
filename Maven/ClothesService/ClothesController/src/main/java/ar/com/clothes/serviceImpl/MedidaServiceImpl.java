package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.MedidaDao;
import ar.com.clothes.model.Medida;
import ar.com.clothes.service.MedidaService;
/**
 * 
 * @author MostroBook
 *
 */
@Service("medidaService")
@Transactional
public class MedidaServiceImpl implements MedidaService {
	
	@Autowired
	MedidaDao medidaDao;
	
	@Override
	public void saveMedida(Medida medida) {
		medidaDao.saveMedida(medida);
	}

	@Override
	public List<Medida> findAllMedida() {
		return medidaDao.findAllMedida();
	}

	@Override
	public void deleteMedidaById(Integer idMedidas) {
		medidaDao.deleteMedidaById(idMedidas);
	}

	@Override
	public Medida findById(Integer idMedidas) {
		return medidaDao.findById(idMedidas);
	}

	@Override
	public void updateMedida(Medida medida) {
		medidaDao.updateMedida(medida);
	}

}
