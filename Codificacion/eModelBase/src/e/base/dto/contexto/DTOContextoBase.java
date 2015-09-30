package e.base.dto.contexto;

import e.base.dto.DTOBase;

public class DTOContextoBase {
	private String operacion;
	private String siguiente;
	private String retorno;
	private boolean editando;
	private DTOBase dtoBase;

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(String siguiente) {
		this.siguiente = siguiente;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public boolean isEditando() {
		return editando;
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
	}

	public DTOBase getDtoBase() {
		return dtoBase;
	}

	public void setDtoBase(DTOBase dtoBase) {
		this.dtoBase = dtoBase;
	}

}
