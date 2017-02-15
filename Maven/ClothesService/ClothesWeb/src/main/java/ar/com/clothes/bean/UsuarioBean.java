package ar.com.clothes.bean;

import org.apache.log4j.Logger;

public class UsuarioBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(UsuarioBean.class);

	private String nombreUsuario;
	private String password;

	public UsuarioBean() {
		super();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
