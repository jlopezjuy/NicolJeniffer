package e.servicio;

import java.util.List;

import e.base.dto.contexto.UsuarioWebDto;
import e.base.dto.validacion.MensajeDto;
import e.base.excepcion.ExcepcionServicio;

public interface ServicioPrecio {

//	// Usuarios
//
//	UsuarioWebDto iniciarSesion(String usuario, String clave) throws ExcepcionServicio;
//
//	void editarPersona(PersonaDto persona) throws ExcepcionServicio;
//
//	void guardarPersona(PersonaDto persona) throws ExcepcionServicio;
//
//	List<PersonaDto> buscarPersonas(BusquedaPersonaDto busquedaPersona) throws ExcepcionServicio;
//
//	// Productos
//
//	MensajeDto guardarProducto(ProductoDto productoDto);
//
//	MensajeDto editarProducto(ProductoDto productoDto);
//
//	List<ProductoDto> buscarProductos(BusquedaProductoDto busquedaProducto) throws ExcepcionServicio;
//
//	ProductoDto obtenerProducto(Long idProducto);
//
//	// Marcas
//
//	List<MarcaDto> buscarMarcas(BusquedaMarcaDto busquedaMarca) throws ExcepcionServicio;
//
//	MensajeDto guardarMarca(MarcaDto marcaDto);
//
//	MensajeDto editarMarca(MarcaDto marcaDto);
//
//	MarcaDto obtenerMarca(Long idMarca);
//
//	// Dimensiones
//
//	List<DimensionDto> buscarDimensiones(BusquedaDimensionDto busquedaDimension) throws ExcepcionServicio;
//
//	MensajeDto guardarDimension(DimensionDto dimensionDto);
//
//	MensajeDto editarDimension(DimensionDto dimensionDto);
//
//	// Unidades
//
//	List<UnidadDto> buscarUnidades(BusquedaUnidadDto busquedaUnidadDto) throws ExcepcionServicio;
//
//	MensajeDto guardarUnidad(UnidadDto unidadDto);
//
//	MensajeDto editarUnidad(UnidadDto unidadDto);
//
//	UnidadDto obtenerUnidad(Long idUnidad);
//
//	// Precios
//
//	List<PrecioDto> buscarPrecios(BusquedaPrecioDto busquedaPrecioDto) throws ExcepcionServicio;
//
//	MensajeDto guardarPrecio(PrecioDto precioDto);
//
//	MensajeDto editarPrecio(PrecioDto precioDto);
//	
//	// Clientes
//	
//	List<ClienteDto> listAll();
}
