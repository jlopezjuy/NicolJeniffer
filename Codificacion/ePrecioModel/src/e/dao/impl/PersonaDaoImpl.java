package e.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import e.dao.PersonaDao;
import e.dominio.Persona;
import e.dto.busqueda.BusquedaPersonaDto;
import e.hibernate.dao.impl.DAOHibernateImpl;

public class PersonaDaoImpl extends DAOHibernateImpl<Persona, Long> implements PersonaDao {
	private Logger LOG = Logger.getLogger(PersonaDaoImpl.class);

	@Override
	public List<Persona> buscar(BusquedaPersonaDto busquedaPersonaDto) {
		Criteria criteria = obtenerCriteria();
		LOG.debug(busquedaPersonaDto.getPreferencia());
		if (busquedaPersonaDto.getPreferencia() != null) {
			criteria.setFirstResult(busquedaPersonaDto.getPreferencia().getNumeroDePagina());
			criteria.setMaxResults(busquedaPersonaDto.getPreferencia().getResultadoMaximo());
		}
		/*criteria.add(Restrictions.or(Restrictions.ilike("nombres", busquedaPersonaDto.getNombres(), MatchMode.ANYWHERE),
				Restrictions.ilike("apellidos", busquedaPersonaDto.getNombres(), MatchMode.ANYWHERE), Restrictions.ilike("contacto", busquedaPersonaDto.getNombres(), MatchMode.ANYWHERE),
				Restrictions.ilike("documento", busquedaPersonaDto.getNombres(), MatchMode.ANYWHERE)));*/
		return ejecutarCriteria(criteria);
	}

}
