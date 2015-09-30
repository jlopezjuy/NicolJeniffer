package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.Persona;
import e.dto.busqueda.BusquedaPersonaDto;

public interface PersonaDao extends DAOBase<Persona, Long> {

	List<Persona> buscar(BusquedaPersonaDto busquedaPersonaDto);

}
