package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Modelo;

public interface ModeloService {
	void saveModelo(Modelo modelo);

	List<Modelo> findAllModelo();

	void deleteModeloById(Integer idModelos);

	Modelo findById(Integer idModelos);

	void updateModelo(Modelo modelo);

	List<Modelo> listarModelo(Cliente cliente);
}
