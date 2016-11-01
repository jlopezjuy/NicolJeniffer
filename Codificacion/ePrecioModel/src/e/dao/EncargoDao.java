package e.dao;

import java.util.Date;
import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.entity.Clientes;
import e.dominio.entity.Encargos;

public interface EncargoDao extends DAOBase<Encargos, Long>{
	List<Encargos> buscarEncargos(Date fechaEncargo, Clientes clientes);
	List<Encargos> listarEncargos();
	void guardarEncargo(Encargos cliente);
	void editarEncargo(Encargos cliente);
	void eliminarEncargo(Encargos cliente);
}
