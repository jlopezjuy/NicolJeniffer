package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Medida;

public interface MedidaService {
	void saveMedida(Medida medida);
	
	List<Medida> findAllMedida();
	
	void deleteMedidaById(Integer idMedidas);
	
	Medida findById(Integer idMedidas);
	
	void updateMedida(Medida medida);
}
