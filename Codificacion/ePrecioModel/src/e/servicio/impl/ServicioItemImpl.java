package e.servicio.impl;

import java.util.List;

import e.base.dto.DTOSeleccionable;
import e.dao.DimensionDao;
import e.dao.PersonaDao;
import e.servicio.ServicioItem;

public class ServicioItemImpl implements ServicioItem {
	private ServicioDtoImpl servicioDto;
	private PersonaDao personaDao;
	private DimensionDao dimensionDao;

	@Override
	public List<DTOSeleccionable> getDimensiones() {
		try {
			return servicioDto.getDimensionDTOItem(dimensionDao.listar());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setServicioDto(ServicioDtoImpl servicioDto) {
		this.servicioDto = servicioDto;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public void setDimensionDao(DimensionDao dimensionDao) {
		this.dimensionDao = dimensionDao;
	}

}
