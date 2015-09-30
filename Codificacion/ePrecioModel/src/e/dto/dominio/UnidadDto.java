package e.dto.dominio;

import e.base.dto.DTOBaseNombre;

public class UnidadDto extends DTOBaseNombre {
	private Long idDimension;
	private String simbolo;
	private Integer factorNumerador;
	private Integer factorDenominador;

	public Long getIdDimension() {
		return idDimension;
	}

	public void setIdDimension(Long idDimension) {
		this.idDimension = idDimension;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Integer getFactorNumerador() {
		return factorNumerador;
	}

	public void setFactorNumerador(Integer factorNumerador) {
		this.factorNumerador = factorNumerador;
	}

	public Integer getFactorDenominador() {
		return factorDenominador;
	}

	public void setFactorDenominador(Integer factorDenominador) {
		this.factorDenominador = factorDenominador;
	}
}
