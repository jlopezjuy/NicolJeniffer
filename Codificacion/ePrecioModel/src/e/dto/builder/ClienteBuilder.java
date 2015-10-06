package e.dto.builder;

import org.apache.log4j.Logger;

import e.base.dto.builder.BaseBuilder;
import e.dominio.entity.Clientes;
import e.dto.dominio.ClienteDto;
import e.servicio.impl.ServicioDtoImpl;

public class ClienteBuilder extends BaseBuilder {
	
	private final static Logger LOG = Logger.getLogger(ClienteBuilder.class);
	
	/**
	 * Metodo para convertir ClienteDto a Cliente
	 * @param clienteDto
	 * @param cliente
	 * @return cliente
	 * @author JLopez
	 * @since 05/10/2015
	 * @version 1.0
	 */
	public Clientes buildDominio(ClienteDto clienteDto, Clientes cliente) {
		cliente = (Clientes) super.buildDominio(clienteDto, cliente);
		cliente.setId(clienteDto.getId());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setApellido(clienteDto.getApellido());
		cliente.setCelular(clienteDto.getCelular());
		cliente.setEmail(clienteDto.getEmail());
		return cliente;
	}
	
	/**
	 * Metodo para convertir Cliente a ClienteDto
	 * @param cliente
	 * @param clienteDto
	 * @return clienteDto
	 * @author JLopez
	 * @since 05/10/2015
	 * @version 1.0
	 */
	public ClienteDto buildDTO(Clientes cliente, ClienteDto clienteDto) {
		LOG.debug("entro al metodo : buildDTO");
		clienteDto = (ClienteDto) super.buildDTO(cliente, clienteDto);
		clienteDto.setId(cliente.getId());
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setApellido(cliente.getApellido());
		clienteDto.setCelular(cliente.getCelular());
		clienteDto.setEmail(cliente.getEmail());
		return clienteDto;
	}
}
