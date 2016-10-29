package e.servicio;

import e.dominio.entity.Usuario;

public interface ServicioUsuario {
	public Usuario getUsuario(String nombreUsuario, String password);
}
