package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.Producto;
import e.dto.busqueda.BusquedaProductoDto;

public interface ProductoDao extends DAOBase<Producto, Long> {

	List<Producto> buscar(BusquedaProductoDto busquedaProductoDto);
}
