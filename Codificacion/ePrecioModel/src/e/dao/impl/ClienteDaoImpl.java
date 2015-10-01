package e.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionBaseDeDato;
import e.dao.ClienteDao;
import e.dominio.Persona;
import e.dominio.entity.Clientes;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class ClienteDaoImpl extends DAOHibernateImpl<Clientes, Long> implements ClienteDao {
	private Logger LOG = Logger.getLogger(ClienteDaoImpl.class);

	@Override
	public List<Clientes> buscarNombreCliente(String nombreCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
