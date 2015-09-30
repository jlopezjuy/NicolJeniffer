package e.hibernate.dao.impl;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import e.base.dao.DAOBase;
import e.base.dao.impl.DAOBaseImpl;
import e.base.dominio.DominioBase;
import e.base.dto.DTOBase;
import e.base.dto.DTOBaseNombre;
import e.base.dto.busqueda.typematch.StringEnum;
import e.base.util.StringUtil;

public class DAOHibernateImpl<T extends DominioBase, ID extends Serializable> extends DAOBaseImpl<T, ID> implements DAOBase<T, ID> {

	private static final Logger LOG = Logger.getLogger(DAOBaseImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public DAOHibernateImpl() {
		super();
	}

	protected final Criteria obtenerCriteria() {
		return getSession().createCriteria(getClasePersistente());
	}

	protected Criteria obtenerCriteriaBaseId(DTOBase busquedaDto) {
		Criteria criteria = obtenerCriteria();
		LOG.debug(busquedaDto.getPreferencia());
		if (busquedaDto.getPreferencia() != null) {
			criteria.setFirstResult(busquedaDto.getPreferencia().getNumeroDePagina());
			criteria.setMaxResults(busquedaDto.getPreferencia().getResultadoMaximo());
		}
		return criteria;
	}

	protected Criteria obtenerCriteriaBaseNombre(DTOBaseNombre busquedaDto) {
		Criteria criteria = obtenerCriteriaBaseId(busquedaDto);
		if (!StringUtil.esVacio(busquedaDto.getNombre())) {
			if (StringEnum.CONTENIDO.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.ilike("nombre", busquedaDto.getNombre(), MatchMode.ANYWHERE));
			} else if (StringEnum.IGUAL.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.eq("nombre", busquedaDto.getNombre()));
			} else if (StringEnum.INICIA.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.ilike("nombre", busquedaDto.getNombre(), MatchMode.START));
			} else if (StringEnum.TERMINA.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.ilike("nombre", busquedaDto.getNombre(), MatchMode.END));
			} else if (StringEnum.NULO.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.isNull("nombre"));
			} else if (StringEnum.NO_NULO.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.isNotNull("nombre"));
			} else if (StringEnum.VACIO.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.isEmpty("nombre"));
			} else if (StringEnum.NO_VACIO.equals(busquedaDto.getTypeMatchNombre())) {
				criteria.add(Restrictions.isNotEmpty("nombre"));
			}
		}
		return criteria;
	}

	@SuppressWarnings("unchecked")
	protected final List<T> ejecutarCriteria(Criteria c) {
		return (List<T>) c.list();
	}

	@SuppressWarnings("unchecked")
	protected final T ejecutarCriteriaUnica(Criteria c) {
		return (T) c.uniqueResult();
	}

	protected final int contar(Criteria criteria) {
		try {
			return (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {
			LOG.error("Error", e);
			return -1;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T obtener(ID id) {
		try {
			return (T) getSession().get(getClasePersistente(), id);
		} catch (Exception e) {
			LOG.error("Error", e);
			return null;
		}
	}

	@Override
	public Object guardar(T objeto) {
		Object objetoId = null;
		try {
			objetoId = getSession().save(objeto);
		} catch (Exception e) {
			LOG.error("Error", e);
		}
		return objetoId;
	}

	@Override
	public void editar(T objeto) {
		try {
			getSession().update(objeto);
		} catch (Exception e) {
			LOG.error("Error", e);
		}
	}

	@Override
	public void eliminar(T objeto) {
		try {
			getSession().delete(objeto);
		} catch (Exception e) {
			LOG.error("Error", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		List<T> lista = null;
		try {
			lista = (List<T>) getSession().createCriteria(getClasePersistente()).list();
		} catch (Exception e) {
			LOG.error("Error", e);
			lista = new ArrayList<T>();
		}
		return lista;
	}

	protected void agregarRestriccionActivo(Criteria c, Boolean activo) {
		if (activo != null) {
			if (activo) {
				c.add(Restrictions.isNull("fechaBaja"));
			} else {
				c.add(Restrictions.isNotNull("fechaBaja"));
			}
		}
	}

	@Override
	public Long getNextVal() {
		Long nextVal = 0L;
		try {
			LOG.info("use autoincrement");
			LOG.info(nextVal);
		} catch (Exception e) {
			LOG.error("getNextVal", e);
		}
		return nextVal;
	}

	@Override
	public Blob getBlob(InputStream contenidoBinario) {
		Blob blob = null;
		try {
			if (contenidoBinario != null) {
				long tempval = 50;
				blob = Hibernate.getLobCreator(this.getSession()).createBlob(contenidoBinario, tempval);
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return blob;
	}

}
