package e.servicio;

import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;
import e.dto.dominio.ClienteDto;
import e.dto.dominio.PersonaDto;

public interface ServicioCliente {
	// Clientes
	void editarCliente(Clientes cliente) throws ExcepcionServicio;

	void guardarCliente(Clientes cliente) throws ExcepcionServicio;
	List<Clientes> listAll();
}
