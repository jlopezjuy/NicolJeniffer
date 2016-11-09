package e.servicio;

import java.util.List;

import e.base.excepcion.ExcepcionServicio;
import e.dominio.entity.Encargos;
import e.dominio.entity.Pagos;

public interface ServicioPago {
	void editarPago(Pagos pago) throws ExcepcionServicio;

	void guardarPago(Pagos pago) throws ExcepcionServicio;
	List<Pagos> listAll(Encargos encargo);
	
	Pagos findById(int idPago);
}
