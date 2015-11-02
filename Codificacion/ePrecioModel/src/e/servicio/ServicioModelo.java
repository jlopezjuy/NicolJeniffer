package e.servicio;

import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;
import e.dominio.entity.Modelos;

public interface ServicioModelo {
	void editarModelo(Modelos modelo) throws ExcepcionServicio;

	void guardarModelo(Modelos modelo) throws ExcepcionServicio;
	List<Modelos> listAll(Clientes cliente);
	
	Modelos findById(int idModelos);
}
