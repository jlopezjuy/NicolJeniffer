package e.dao;

import java.util.Date;
import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.Precio;
import e.dto.busqueda.BusquedaPrecioDto;

public interface PrecioDao extends DAOBase<Precio, Long> {

	List<Precio> buscar(Date fechaInicial, Date fechaFinal);

	List<Precio> buscar(BusquedaPrecioDto busquedaPrecioDto);

}
