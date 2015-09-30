package e.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import e.base.dto.DTOBaseNombre;

public class DTOBaseNombreConverter implements Converter {
	private final static Logger LOG = Logger.getLogger(DTOBaseNombreConverter.class);
	private final String BASE_NOMBRE = "_BASE_NOMBRE";

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String uiIdId) {
		DTOBaseNombre baseNombreDto = (DTOBaseNombre) facesContext.getExternalContext().getSessionMap().get(uiComponent.getId() + BASE_NOMBRE);
		if (baseNombreDto != null) {
			LOG.debug("uiId: " + uiComponent.getId() + ", id: " + baseNombreDto.getId() + ", nombre: " + baseNombreDto.getNombre());
		} else {
			LOG.debug("No se encontro el objeto con id: " + uiIdId);
		}
		return baseNombreDto;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object dto) {
		DTOBaseNombre baseNombreDto = (DTOBaseNombre) dto;
		String uiIdId = uiComponent.getId() + BASE_NOMBRE;
		String nombre = "";
		if (baseNombreDto != null) {
			nombre = baseNombreDto.getNombre();
			LOG.debug("uiId: " + uiComponent.getId() + ", id: " + baseNombreDto.getId() + ", nombre: " + baseNombreDto.getNombre());

		}
		facesContext.getExternalContext().getSessionMap().put(uiIdId, baseNombreDto);
		return nombre;
	}

}
