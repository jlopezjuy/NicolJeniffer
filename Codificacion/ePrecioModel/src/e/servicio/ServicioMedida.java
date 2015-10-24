package e.servicio;

import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.*;

public interface ServicioMedida {
	
	void editarMedida(Medidas medida) throws ExcepcionServicio;

	void guardarMedida(Medidas medida) throws ExcepcionServicio;

	List<Medidas> listAll(Clientes cliente);
}
