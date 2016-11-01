package e.servicio;

import java.util.Date;
import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Clientes;
import e.dominio.entity.Encargos;

public interface ServicioEncargo {
	void editarEncargo(Encargos encargo) throws ExcepcionServicio;
	void eliminarEncargo(Encargos encargo) throws ExcepcionServicio;
	void guardarEncargo(Encargos encargo) throws ExcepcionServicio;
	List<Encargos> listAll();
	List<Encargos> findEncargo(Date fechaEncargo, Clientes clientes);
}
