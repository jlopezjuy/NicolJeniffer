package ar.com.clothes.dao;

import java.util.List;

import ar.com.clothes.model.Encargo;
import ar.com.clothes.model.Pago;

public interface PagoDao {
	void savePago(Pago pago);

	List<Pago> findAll();

	void deletePagoById(Integer idPagos);

	Pago findById(Integer idPagos);

	void updatePago(Pago pago);

	List<Pago> listarPagosEncargo(Encargo encargo);
}
