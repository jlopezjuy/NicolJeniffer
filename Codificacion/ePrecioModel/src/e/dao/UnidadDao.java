package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.Unidad;
import e.dto.busqueda.BusquedaUnidadDto;

public interface UnidadDao extends DAOBase<Unidad, Long> {

	List<Unidad> buscar(BusquedaUnidadDto busquedaUnidadDto);

	

}
