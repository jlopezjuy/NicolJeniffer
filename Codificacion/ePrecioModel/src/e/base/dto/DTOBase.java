package e.base.dto;

import e.base.dto.busqueda.PreferenciaBusquedaDto;

public class DTOBase {
	private Long id;
	private PreferenciaBusquedaDto preferencia;

	public DTOBase() {

	}

	public void iniciar() {
		this.id = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PreferenciaBusquedaDto getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(PreferenciaBusquedaDto preferencia) {
		this.preferencia = preferencia;
	}

}
