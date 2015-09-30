package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.TipoPersona;

public interface TipoPersonaDao extends DAOBase<TipoPersona, Long> {

	List<TipoPersona> listar(Long idVenta);

	List<TipoPersona> obtenerExcluyendo(Long idVenta, List<Long> ids);

}
