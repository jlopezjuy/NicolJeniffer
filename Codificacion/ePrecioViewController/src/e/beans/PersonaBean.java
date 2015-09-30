package e.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import e.base.excepcion.ExcepcionServicio;
import e.dto.busqueda.BusquedaPersonaDto;
import e.dto.dominio.PersonaDto;

public class PersonaBean extends BaseBean {
	private static final Logger LOG = Logger.getLogger(PersonaBean.class);
	private BusquedaPersonaDto busquedaPersona = new BusquedaPersonaDto();
	private PersonaDto persona;
	private List<PersonaDto> personas = new ArrayList<PersonaDto>();

	public PersonaBean() {
		super();
	}

	public void buscarPersona(ActionEvent ev) {
		LOG.debug("");
		try {
			personas = getServicioPrecio().buscarPersonas(busquedaPersona);
		} catch (ExcepcionServicio e) {
			LOG.error(e);
			// super.mostrarMensaje("Error", e.getMessage(),null);
		}
	}

	public void guardarNuevaPersona(ActionEvent ev) {
		LOG.info("");
		try {
			getServicioPrecio().guardarPersona(persona);

		} catch (ExcepcionServicio e) {
			LOG.error(e);

		}
	}

	public void guardarEdicionPersona(ActionEvent ev) {
		LOG.info("");
		try {
			getServicioPrecio().editarPersona(persona);
			// super.mostrarMensaje("Edicion Persona", "Exito",null);
		} catch (ExcepcionServicio e) {
			LOG.error(e);
			// super.mostrarMensaje("Error", e.getMessage(),null,true);

		}

	}

	public BusquedaPersonaDto getBusquedaPersona() {
		return busquedaPersona;
	}

	public void setBusquedaPersona(BusquedaPersonaDto busquedaPersona) {
		this.busquedaPersona = busquedaPersona;
	}

	public PersonaDto getPersona() {
		return persona;
	}

	public void setPersona(PersonaDto persona) {
		this.persona = persona;
	}

	public List<PersonaDto> getPersonas() {
		return personas;
	}

	public void setPersonas(List<PersonaDto> personas) {
		this.personas = personas;
	}

}
