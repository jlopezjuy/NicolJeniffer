package ar.com.clothes.service;

import java.util.List;

import ar.com.clothes.model.Encargo;
import ar.com.clothes.model.Pago;

/**
 * 
 * @author MostroBook
 *
 */
public interface PagoService {

	void savePago(Pago pago);

	List<Pago> findAll();

	void deletePagoById(Integer idPagos);

	Pago findById(Integer idPagos);

	void updatePago(Pago pago);

	List<Pago> listarPagosEncargo(Encargo encargo);
}
