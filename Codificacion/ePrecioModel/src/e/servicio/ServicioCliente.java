package e.servicio;

import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dto.dominio.ClienteDto;
import e.dto.dominio.PersonaDto;

public interface ServicioCliente {
	// Clientes
	void editarCliente(ClienteDto cliente) throws ExcepcionServicio;

	void guardarCliente(ClienteDto cliente) throws ExcepcionServicio;
	List<ClienteDto> listAll();
}
