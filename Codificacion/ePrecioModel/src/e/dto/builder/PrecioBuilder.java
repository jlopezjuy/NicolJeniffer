package e.dto.builder;

import e.base.dto.builder.BaseBuilder;
import e.dominio.Precio;
import e.dto.dominio.PrecioDto;

public class PrecioBuilder extends BaseBuilder {

	public Precio buildDominio(PrecioDto precioDto, Precio precio) {
		precio = (Precio) super.buildDominio(precioDto, precio);
		precio.setFechaInicio(precioDto.getFechaInicio());
		precio.setIdMarca(precioDto.getIdMarca());
		precio.setIdProducto(precioDto.getIdProducto());
		precio.setIdUnidad(precioDto.getIdUnidad());
		precio.setPrecio(precioDto.getPrecio());
		return precio;
	}

	public PrecioDto buildDTO(Precio precio, PrecioDto precioDto) {
		precioDto = (PrecioDto) super.buildDTO(precio, precioDto);
		precioDto.setFechaInicio(precio.getFechaInicio());
		precioDto.setIdMarca(precio.getIdMarca());
		precioDto.setIdProducto(precio.getIdProducto());
		precioDto.setIdUnidad(precio.getIdUnidad());
		precioDto.setPrecio(precio.getPrecio());
		return precioDto;
	}

}
