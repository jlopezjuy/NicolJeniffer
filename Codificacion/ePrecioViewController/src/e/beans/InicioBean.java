package e.beans;

import org.apache.log4j.Logger;

import e.base.dto.contexto.UsuarioWebDto;

public class InicioBean extends BaseBean {

	private Logger LOG = Logger.getLogger(InicioBean.class);
	private String usuario = "sergio";// FIXME
	private String clave = "clabe";// FIXME

	public InicioBean() {		
		super();
	}

	public String iniciar() {

		String accion = null;
		try {
			UsuarioWebDto usuarioWeb = getServicioPrecio().iniciarSesion(usuario, clave);
			LOG.debug(usuario + ", " + clave + ", " + usuarioWeb);
			LOG.debug(usuarioWeb);
			if (usuarioWeb != null) {
				super.guardarUsuarioWeb(usuarioWeb);
				// accion = "ventaLista";
				accion = "bienvenida";
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return accion;
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
