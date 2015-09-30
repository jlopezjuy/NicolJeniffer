package e.base.dto.builder;

import e.base.dominio.DominioBaseNombre;
import e.base.dto.DTOBaseNombre;

public class BaseNombreBuilder extends BaseBuilder {

	public DTOBaseNombre buildDTO(DominioBaseNombre dominioBaseNombre, DTOBaseNombre dtoBaseNombre) {
		dtoBaseNombre = (DTOBaseNombre) super.buildDTO(dominioBaseNombre, dtoBaseNombre);
		dtoBaseNombre.setNombre(dominioBaseNombre.getNombre());
		return dtoBaseNombre;
	}

	public DominioBaseNombre buildDominio(DTOBaseNombre dtoBaseNombre, DominioBaseNombre dominioBaseNombre) {
		dominioBaseNombre = (DominioBaseNombre) super.buildDominio(dtoBaseNombre, dominioBaseNombre);
		dominioBaseNombre.setNombre(dtoBaseNombre.getNombre());
		return dominioBaseNombre;
	}

}
