package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.PagoDao;
import ar.com.clothes.model.Encargo;
import ar.com.clothes.model.Pago;
import ar.com.clothes.service.PagoService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("pagoService")
@Transactional
public class PagoServiceImpl implements PagoService {

	@Autowired
	PagoDao pagoDao;

	@Override
	public void savePago(Pago pago) {
		pagoDao.savePago(pago);
	}

	@Override
	public List<Pago> findAll() {
		return pagoDao.findAll();
	}

	@Override
	public void deletePagoById(Integer idPagos) {
		pagoDao.deletePagoById(idPagos);
	}

	@Override
	public Pago findById(Integer idPagos) {
		return pagoDao.findById(idPagos);
	}

	@Override
	public void updatePago(Pago pago) {
		pagoDao.updatePago(pago);
	}

	@Override
	public List<Pago> listarPagosEncargo(Encargo encargo) {
		return pagoDao.listarPagosEncargo(encargo);
	}

}
