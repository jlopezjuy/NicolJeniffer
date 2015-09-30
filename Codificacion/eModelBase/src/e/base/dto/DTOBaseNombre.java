package e.base.dto;

import e.base.dto.busqueda.typematch.StringEnum;

public class DTOBaseNombre extends DTOBase {
	private String nombre;
	private StringEnum typeMatchNombre = StringEnum.IGUAL;

	public void iniciar() {
		super.iniciar();
		this.nombre = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public StringEnum getTypeMatchNombre() {
		return typeMatchNombre;
	}

	public void setTypeMatchNombre(StringEnum typeMatchNombre) {
		this.typeMatchNombre = typeMatchNombre;
	}
}
