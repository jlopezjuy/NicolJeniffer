package e.base.dto.builder;

import e.base.dominio.DominioBase;
import e.base.dto.DTOBase;

public class BaseBuilder {
	public DominioBase buildDominio(DTOBase dtoBase, DominioBase dominioBase) {
		dominioBase.setId(dtoBase.getId());
		return dominioBase;
	}

	public DTOBase buildDTO(DominioBase dominioBase, DTOBase dtoBase) {
		dtoBase.setId(dominioBase.getId());
		return dtoBase;
	}

}
