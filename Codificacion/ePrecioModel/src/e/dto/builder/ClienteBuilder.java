package e.dto.builder;

import e.base.dto.builder.BaseBuilder;
import e.dominio.entity.Clientes;
import e.dto.dominio.ClienteDto;

public class ClienteBuilder extends BaseBuilder {
	
	public Clientes buildDominio(ClienteDto clienteDto, Clientes cliente) {
		cliente = (Clientes) super.buildDominio(clienteDto, cliente);
		cliente.setId(clienteDto.getId());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setApellido(clienteDto.getApellido());
		cliente.setCelular(clienteDto.getCelular());
		cliente.setEmail(clienteDto.getEmail());
		return cliente;
	}

	public ClienteDto buildDTO(Clientes cliente, ClienteDto clienteDto) {
		clienteDto = (ClienteDto) super.buildDTO(cliente, clienteDto);
		clienteDto.setId(cliente.getId());
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setApellido(cliente.getApellido());
		clienteDto.setCelular(cliente.getCelular());
		clienteDto.setEmail(cliente.getEmail());
		return clienteDto;
	}
}
