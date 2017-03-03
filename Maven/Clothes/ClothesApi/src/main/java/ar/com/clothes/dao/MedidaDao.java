package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Medida;

public interface MedidaDao {
	void saveMedida(Medida medida);

	List<Medida> findAllMedida();

	void deleteMedidaById(Integer idMedidas);

	Medida findById(Integer idMedidas);

	void updateMedida(Medida medida);

	List<Medida> listarMedidas(Cliente cliente);
}
