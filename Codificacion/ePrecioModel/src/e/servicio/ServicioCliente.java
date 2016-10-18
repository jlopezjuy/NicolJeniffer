package e.servicio;

import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;

public interface ServicioCliente {

	void guardarCliente(Clientes cliente) throws ExcepcionServicio;
	List<Clientes> listAll();
	void editarCiente(Clientes cliente)throws ExcepcionServicio;
	void eliminarCliente(Clientes cliente)throws ExcepcionServicio;
}
