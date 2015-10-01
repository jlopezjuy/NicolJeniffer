package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.entity.Clientes;

public interface ClienteDao extends DAOBase<Clientes, Long>{
	List<Clientes> buscarNombreCliente(String nombreCliente);
}