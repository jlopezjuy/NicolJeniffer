package ar.com.clothes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.clothes.dao.ValorDominioDao;
import ar.com.clothes.model.ValorDominio;
import ar.com.clothes.service.ValorDominioService;

/**
 * 
 * @author MostroBook
 *
 */
@Service("valorDominioService")
@Transactional
public class ValorDominioServiceImpl implements ValorDominioService {

	@Autowired
	ValorDominioDao valorDominioDao;

	@Override
	public void saveValorDominio(ValorDominio valorDominio) {
		valorDominioDao.saveValorDominio(valorDominio);
	}

	@Override
	public List<ValorDominio> findAll() {
		return valorDominioDao.findAll();
	}

	@Override
	public void deleteValorDominioById(Integer idValorDominio) {
		valorDominioDao.deleteValorDominioById(idValorDominio);
	}

	@Override
	public ValorDominio findById(Integer idValorDominio) {
		return valorDominioDao.findById(idValorDominio);
	}

	@Override
	public void updateValorDominio(ValorDominio valorDominio) {
		valorDominioDao.updateValorDominio(valorDominio);
	}

}
