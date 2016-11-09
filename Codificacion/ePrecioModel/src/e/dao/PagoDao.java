package e.dao;

import java.util.Date;
import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.entity.*;

public interface PagoDao extends DAOBase<Pagos, Long> {
	List<Pagos> buscarFechaPago(Date fechaPago);
	List<Pagos> listarPagos(Encargos encargo);
	void guardarPago(Pagos pago);
	Pagos findById(int idModelo);
}
