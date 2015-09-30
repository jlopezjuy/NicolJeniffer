package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.Marca;
import e.dto.busqueda.BusquedaMarcaDto;

public interface MarcaDao extends DAOBase<Marca,Long> {

	List<Marca> buscar(BusquedaMarcaDto busquedaMarca);

}
