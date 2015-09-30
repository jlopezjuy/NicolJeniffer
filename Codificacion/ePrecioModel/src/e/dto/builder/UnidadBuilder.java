package e.dto.builder;

import e.base.dto.builder.BaseNombreBuilder;
import e.dominio.Unidad;
import e.dto.dominio.UnidadDto;

public class UnidadBuilder extends BaseNombreBuilder {

	public Unidad buildDominio(UnidadDto dtoBase, Unidad dominioBase) {
		dominioBase = (Unidad) super.buildDominio(dtoBase, dominioBase);
		dominioBase.setFactorDenominador(dtoBase.getFactorDenominador());
		dominioBase.setFactorNumerador(dtoBase.getFactorNumerador());
		dominioBase.setIdDimension(dtoBase.getIdDimension());
		dominioBase.setSimbolo(dtoBase.getSimbolo());
		return dominioBase;
	}

	public UnidadDto buildDTO(Unidad dominioBase, UnidadDto dtoBase) {
		dtoBase = (UnidadDto) super.buildDTO(dominioBase, dtoBase);
		dtoBase.setFactorDenominador(dominioBase.getFactorDenominador());
		dtoBase.setFactorNumerador(dominioBase.getFactorNumerador());
		dtoBase.setIdDimension(dominioBase.getIdDimension());
		dtoBase.setSimbolo(dominioBase.getSimbolo());
		return dtoBase;
	}

}
