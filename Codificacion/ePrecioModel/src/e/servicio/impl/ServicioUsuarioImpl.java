package e.servicio.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import e.dao.impl.UsuarioDaoImpl;
import e.dominio.entity.Usuario;
import e.servicio.ServicioUsuario;

public class ServicioUsuarioImpl implements ServicioUsuario {
	private final static Logger LOG = Logger.getLogger(ServicioUsuarioImpl.class);
	private SessionFactory sessionFactory;
	private UsuarioDaoImpl usuarioDao;

	@Override
	public Usuario getUsuario(String nombreUsuario, String password) {
		LOG.info("Entro a buscar usuario");
		return usuarioDao.verificar(nombreUsuario, password);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UsuarioDaoImpl getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDaoImpl usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
