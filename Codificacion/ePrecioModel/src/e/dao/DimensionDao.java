package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.Dimension;
import e.dto.busqueda.BusquedaDimensionDto;

public interface DimensionDao extends DAOBase<Dimension, Long> {

	List<Dimension> buscar(BusquedaDimensionDto busquedaDimension);

}
