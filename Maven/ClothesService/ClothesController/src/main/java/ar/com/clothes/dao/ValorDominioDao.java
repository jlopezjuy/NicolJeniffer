package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.ValorDominio;

public interface ValorDominioDao {
	void saveValorDominio(ValorDominio valorDominio);

	List<ValorDominio> findAll();

	void deleteValorDominioById(Integer idValorDominio);

	ValorDominio findById(Integer idValorDominio);

	void updateValorDominio(ValorDominio valorDominio);

}
