package e.servicio.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import e.base.dto.DTOSeleccionable;
import e.base.dto.builder.BaseNombreBuilder;
import e.base.dto.contexto.UsuarioWebDto;
import e.dominio.Dimension;
import e.dominio.Marca;
import e.dominio.Persona;
import e.dominio.Precio;
import e.dominio.Producto;
import e.dominio.Unidad;
import e.dominio.Usuario;
import e.dominio.entity.Clientes;
import e.dto.builder.ClienteBuilder;
import e.dto.builder.PersonaBuilder;
import e.dto.builder.PrecioBuilder;
import e.dto.builder.TransaccionBuilder;
import e.dto.builder.TransaccionItemBuilder;
import e.dto.builder.UnidadBuilder;
import e.dto.builder.UsuarioBuilder;
import e.dto.dominio.ClienteDto;
import e.dto.dominio.DimensionDto;
import e.dto.dominio.MarcaDto;
import e.dto.dominio.PrecioDto;
import e.dto.dominio.ProductoDto;
import e.dto.dominio.UnidadDto;
import e.dto.dominio.UsuarioDto;

public class ServicioDtoImpl {
	private final static Logger LOG = Logger.getLogger(ServicioDtoImpl.class);
	private BaseNombreBuilder baseNombreBuilder;
	private PersonaBuilder personaBuilder;
	private PrecioBuilder precioBuilder;
	private TransaccionBuilder transaccionBuilder;
	private TransaccionItemBuilder transaccionItemBuilder;
	private UnidadBuilder unidadBuilder;
	private UsuarioBuilder usuarioBuilder;
	private ClienteBuilder clienteBuilder;

	public void setBaseNombreBuilder(BaseNombreBuilder baseNombreBuilder) {
		this.baseNombreBuilder = baseNombreBuilder;
	}

	public void setPersonaBuilder(PersonaBuilder personaBuilder) {
		this.personaBuilder = personaBuilder;
	}

	public void setPrecioBuilder(PrecioBuilder precioBuilder) {
		this.precioBuilder = precioBuilder;
	}

	public void setTransaccionBuilder(TransaccionBuilder transaccionBuilder) {
		this.transaccionBuilder = transaccionBuilder;
	}

	public void setTransaccionItemBuilder(TransaccionItemBuilder transaccionItemBuilder) {
		this.transaccionItemBuilder = transaccionItemBuilder;
	}

	public void setUnidadBuilder(UnidadBuilder unidadBuilder) {
		this.unidadBuilder = unidadBuilder;
	}

	public void setUsuarioBuilder(UsuarioBuilder usuarioBuilder) {
		this.usuarioBuilder = usuarioBuilder;
	}
	
	

	public ClienteBuilder getClienteBuilder() {
		return clienteBuilder;
	}

	public void setClienteBuilder(ClienteBuilder clienteBuilder) {
		this.clienteBuilder = clienteBuilder;
	}

	private InputStream getInputStream(Blob blob) {
		InputStream inputStream = null;
		try {
			if (blob != null) {
				inputStream = blob.getBinaryStream();
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return inputStream;
	}

	public DTOSeleccionable getPersonaDTOItem(Persona dominio) {
		DTOSeleccionable dto = null;
		if (dominio != null) {
			dto = new DTOSeleccionable();
			dto.setId(dominio.getId());
			dto.setNombre(dominio.getNombres() + " " + dominio.getId());
		}
		return dto;
	}

	// Productos

	public Producto getProducto(ProductoDto dto) {
		LOG.debug("");
		return (Producto) baseNombreBuilder.buildDominio(dto, new Producto());
	}

	public ProductoDto getProductoDTO(Producto dominio) {
		LOG.debug("");
		return (ProductoDto) baseNombreBuilder.buildDTO(dominio, new ProductoDto());
	}

	public List<ProductoDto> getProductoDTO(List<Producto> listaDominio) {
		LOG.debug("");
		List<ProductoDto> listaDto = new ArrayList<ProductoDto>();
		if (listaDominio != null) {
			for (Producto producto : listaDominio) {
				listaDto.add((ProductoDto) baseNombreBuilder.buildDTO(producto, new ProductoDto()));
			}
		}
		return listaDto;
	}

	// Usuarios

	public Usuario getUsuario(UsuarioDto usuarioDto) {
		return usuarioBuilder.buildDominio(usuarioDto, new Usuario());
	}

	public UsuarioDto getUsuarioDto(Usuario usuario) {
		return usuarioBuilder.buildDTO(usuario, new UsuarioDto());
	}

	public UsuarioWebDto getUsuarioWebDto(Usuario usuario) {
		LOG.debug("");
		return usuarioBuilder.buildDTO(usuario, new UsuarioWebDto());
	}

	// Ventas

	// Marcas
	public List<MarcaDto> getMarcaDTO(List<Marca> listaDominio) {
		LOG.debug("");
		List<MarcaDto> listaDto = new ArrayList<MarcaDto>();
		if (listaDominio != null) {
			for (Marca marca : listaDominio) {
				listaDto.add((MarcaDto) baseNombreBuilder.buildDTO(marca, new MarcaDto()));
			}
		}
		return listaDto;
	}

	public Marca getMarca(MarcaDto marcaDto) {
		LOG.debug("");
		return (Marca) baseNombreBuilder.buildDominio(marcaDto, new Marca());
	}

	public MarcaDto getMarcaDTO(Marca marca) {
		LOG.debug("");
		return (MarcaDto) baseNombreBuilder.buildDTO(marca, new MarcaDto());
	}

	// Dimensiones
	public List<DimensionDto> getDimensionDTO(List<Dimension> listaDominio) {
		LOG.debug("");
		List<DimensionDto> listaDto = new ArrayList<DimensionDto>();
		if (listaDominio != null) {
			for (Dimension dimension : listaDominio) {
				listaDto.add((DimensionDto) baseNombreBuilder.buildDTO(dimension, new DimensionDto()));
			}
		}
		return listaDto;
	}

	public Dimension getDimension(DimensionDto dimensionDto) {
		LOG.debug("");
		return (Dimension) baseNombreBuilder.buildDominio(dimensionDto, new Dimension());
	}

	public List<DTOSeleccionable> getDimensionDTOItem(List<Dimension> listaDominio) {
		LOG.debug("");
		List<DTOSeleccionable> listaDto = new ArrayList<DTOSeleccionable>();
		if (listaDominio != null) {
			for (Dimension dimension : listaDominio) {
				listaDto.add(getDimensionDTOItem(dimension));
			}
		}
		return listaDto;
	}

	private DTOSeleccionable getDimensionDTOItem(Dimension dominio) {
		DTOSeleccionable dto = null;
		if (dominio != null) {
			dto = new DTOSeleccionable();
			dto.setId(dominio.getId());
			dto.setNombre(dominio.getNombre());
		}
		return dto;
	}

	// Unidades
	public List<UnidadDto> getUnidadDTO(List<Unidad> listaDominio) {
		LOG.debug("");
		List<UnidadDto> listaDto = new ArrayList<UnidadDto>();
		if (listaDominio != null) {
			for (Unidad unidad : listaDominio) {
				listaDto.add( unidadBuilder.buildDTO(unidad, new UnidadDto()));
			}
		}
		return listaDto;
	}

	public Unidad getUnidad(UnidadDto unidadDto) {
		LOG.debug("");
		return unidadBuilder.buildDominio(unidadDto, new Unidad());
	}

	public UnidadDto getUnidadDTO(Unidad unidad) {
		LOG.debug("");
		return (UnidadDto) baseNombreBuilder.buildDTO(unidad, new UnidadDto());
	}

	// Precios

	public List<PrecioDto> getPrecioDTO(List<Precio> listaDominio) {
		LOG.debug("");
		List<PrecioDto> listaDto = new ArrayList<PrecioDto>();
		if (listaDominio != null) {
			for (Precio precio : listaDominio) {
				listaDto.add(precioBuilder.buildDTO(precio, new PrecioDto()));
			}
		}
		return listaDto;
	}
	
	//Unidades
	
	public List<ClienteDto> getClienteDTO(List<Clientes> listaDominio) {
		LOG.debug("");
		List<ClienteDto> listaDto = new ArrayList<ClienteDto>();
		if (listaDominio != null) {
			for (Clientes precio : listaDominio) {
				listaDto.add(clienteBuilder.buildDTO(precio, new ClienteDto()));
			}
		}
		return listaDto;
	}

	public Precio getPrecio(PrecioDto precioDto) {
		LOG.debug("");
		return precioBuilder.buildDominio(precioDto, new Precio());
	}

}
