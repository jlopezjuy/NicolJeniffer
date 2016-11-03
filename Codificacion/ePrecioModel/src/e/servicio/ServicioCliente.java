package e.servicio;

import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;

public interface ServicioCliente {
	// Clientes
	void editarCliente(Clientes cliente) throws ExcepcionServicio;

	void guardarCliente(Clientes cliente) throws ExcepcionServicio;
	List<Clientes> listAll();
	List<Clientes> findClientes(String nombreCliente);
	
	Clientes getClienteId(int idCliente);
}
