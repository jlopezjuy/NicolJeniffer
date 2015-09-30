package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.EstadoTransaccion;
import e.dto.busqueda.BusquedaEstadoTransaccionDto;

public interface EstadoTransaccionDao extends DAOBase<EstadoTransaccion, Long> {

	List<EstadoTransaccion> buscar(BusquedaEstadoTransaccionDto busquedaEstadoTransaccionDto);

}
