package e.base.dao.impl;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;

import e.base.dao.DAOBase;
import e.base.dominio.DominioBase;
import e.base.excepcion.ExcepcionBaseDeDato;

public class DAOBaseImpl<T extends DominioBase, ID extends Serializable> implements DAOBase<T, ID> {

	private static final Logger LOG = Logger.getLogger(DAOBaseImpl.class);

	private Class<T> clasePersistente;

	@SuppressWarnings("unchecked")
	public DAOBaseImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			clasePersistente = (Class<T>) types[0];
			LOG.debug("DAO para la clase " + getClasePersistente().getSimpleName());
		} else {
			LOG.debug("DAO no parametrizado!");
		}
	}

	@Override
	public T obtener(ID id) throws ExcepcionBaseDeDato {
		throw new ExcepcionBaseDeDato("Falta sobre-escribir");
	}

	@Override
	public Object guardar(T objeto) throws ExcepcionBaseDeDato {
		throw new ExcepcionBaseDeDato("Falta sobre-escribir");
	}

	@Override
	public void editar(T objeto) throws ExcepcionBaseDeDato {
		throw new ExcepcionBaseDeDato("Falta sobre-escribir");
	}

	@Override
	public void eliminar(T objeto) throws ExcepcionBaseDeDato {
		throw new ExcepcionBaseDeDato("Falta sobre-escribir");
	}

	@Override
	public List<T> listar() throws ExcepcionBaseDeDato {
		throw new ExcepcionBaseDeDato("Falta sobre-escribir");
	}

	@Override
	public Long getNextVal() throws ExcepcionBaseDeDato {
		throw new ExcepcionBaseDeDato("Falta sobre-escribir");
	}

	@Override
	public Blob getBlob(InputStream contenidoBinario) throws ExcepcionBaseDeDato {
		throw new ExcepcionBaseDeDato("Falta sobre-escribir");
	}

	protected Class<T> getClasePersistente() {
		return clasePersistente;
	}

}
