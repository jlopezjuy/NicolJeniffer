package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.ValorDominio;

/**
 * 
 * @author MostroBook
 *
 */
public interface ValorDominioService {

	void saveValorDominio(ValorDominio valorDominio);

	List<ValorDominio> findAll();

	void deleteValorDominioById(Integer idValorDominio);

	ValorDominio findById(Integer idValorDominio);

	void updateValorDominio(ValorDominio valorDominio);
}
