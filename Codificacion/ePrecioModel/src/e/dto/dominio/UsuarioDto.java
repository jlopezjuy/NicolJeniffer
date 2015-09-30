package e.dto.dominio;

import e.base.dto.DTOBase;

public class UsuarioDto extends DTOBase {
	private String usuario;
	private String clave;

	public UsuarioDto() {

	}

	public String toString() {
		return this.getClass() + " usuario: " + usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
