package e.dto.builder;

import e.base.dto.builder.BaseBuilder;
import e.dominio.Persona;
import e.dto.dominio.PersonaDto;

public class PersonaBuilder extends BaseBuilder {

	public PersonaDto buildDTO(Persona persona, PersonaDto personaDto) {
		personaDto = (PersonaDto) super.buildDTO(persona, personaDto);
		personaDto.setApellido(persona.getApellido());
		personaDto.setApellido2(persona.getApellido2());
		personaDto.setCorreoElectronico(persona.getCorreoElectronico());
		personaDto.setDocumento(persona.getDocumento());
		personaDto.setIdTipoPersona(persona.getIdTipoPersona());
		personaDto.setNombres(persona.getNombres());
		return personaDto;
	}

	public Persona buildDominio(PersonaDto personaDto, Persona persona) {
		persona = (Persona) super.buildDominio(personaDto, persona);
		persona.setApellido(personaDto.getApellido());
		persona.setApellido2(personaDto.getApellido2());
		persona.setCorreoElectronico(personaDto.getCorreoElectronico());
		persona.setDocumento(personaDto.getDocumento());
		persona.setIdTipoPersona(personaDto.getIdTipoPersona());
		persona.setNombres(personaDto.getNombres());
		return persona;
	}

}
