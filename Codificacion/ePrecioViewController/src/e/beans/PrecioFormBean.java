package e.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import e.base.dto.busqueda.typematch.StringEnum;
import e.base.dto.validacion.MensajeDto;
import e.base.excepcion.ExcepcionServicio;
import e.base.util.NumberUtil;
import e.dto.busqueda.BusquedaMarcaDto;
import e.dto.busqueda.BusquedaProductoDto;
import e.dto.busqueda.BusquedaUnidadDto;
import e.dto.dominio.MarcaDto;
import e.dto.dominio.PrecioDto;
import e.dto.dominio.ProductoDto;
import e.dto.dominio.UnidadDto;
import e.servicio.constantes.ConstantesAction;

public class PrecioFormBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(PrecioFormBean.class);
	private PrecioDto precio;
	//
	private BusquedaProductoDto busquedaProducto = new BusquedaProductoDto();
	private ProductoDto producto;
	//
	private BusquedaUnidadDto busquedaUnidad = new BusquedaUnidadDto();
	private UnidadDto unidad;
	//
	private BusquedaMarcaDto busquedaMarca = new BusquedaMarcaDto();
	private MarcaDto marca;

	//
	public PrecioFormBean() {
		super();
	}

	public String agregarPrecio() {
		LOG.debug("");
		this.precio = new PrecioDto();
		this.precio.setFechaInicio(new Date());
		return ConstantesAction.EDITAR_PRECIO;
	}

	public String editarPrecio() {
		return ConstantesAction.EDITAR_PRECIO;
	}

	public String listaPrecio() {
		return ConstantesAction.LISTA_PRECIO;
	}

	private void establecerValoresAutocompletados() {
		if (this.producto != null) {
			getPrecio().setIdProducto(this.producto.getId());
		} else {
			getPrecio().setIdProducto(null);
		}
		if (this.unidad != null) {
			getPrecio().setIdUnidad(this.unidad.getId());
		} else {
			getPrecio().setIdUnidad(null);
		}
		if (this.marca != null) {
			getPrecio().setIdMarca(this.marca.getId());
		} else {
			getPrecio().setIdMarca(null);
		}
	}

	private void inicializarValoresAutocompletados() {
		if (this.precio != null) {
			this.producto = getServicioPrecio().obtenerProducto(this.precio.getIdProducto());
			this.unidad = getServicioPrecio().obtenerUnidad(this.precio.getIdUnidad());
			this.marca = getServicioPrecio().obtenerMarca(this.precio.getIdMarca());
		}
	}

	public String guardarNuevoPrecio() {
		LOG.debug("");
		this.establecerValoresAutocompletados();
		MensajeDto mensajeDto = getServicioPrecio().guardarPrecio(precio);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public String guardarEdicionPrecio() {
		LOG.debug("");
		this.establecerValoresAutocompletados();
		MensajeDto mensajeDto = getServicioPrecio().editarPrecio(precio);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public List<ProductoDto> buscarProductos(String consulta) {
		LOG.debug("");
		List<ProductoDto> listaProductos = null;
		try {
			busquedaProducto.setNombre(consulta);
			busquedaProducto.setTypeMatchNombre(StringEnum.CONTENIDO);
			listaProductos = getServicioPrecio().buscarProductos(busquedaProducto);
		} catch (ExcepcionServicio e) {
			listaProductos = new ArrayList<ProductoDto>();
		}
		if (listaProductos == null || listaProductos.isEmpty()) {
			this.producto = new ProductoDto();
			this.producto.setNombre("No encontrado");
			listaProductos = Arrays.asList(this.producto);
		}
		return listaProductos;
	}

	public List<UnidadDto> buscarUnidades(String consulta) {
		LOG.debug("");
		List<UnidadDto> listaUnidades = null;
		try {
			busquedaUnidad.setNombre(consulta);
			busquedaUnidad.setTypeMatchNombre(StringEnum.CONTENIDO);
			listaUnidades = getServicioPrecio().buscarUnidades(busquedaUnidad);
		} catch (ExcepcionServicio e) {
			listaUnidades = new ArrayList<UnidadDto>();
		}
		if (listaUnidades == null || listaUnidades.isEmpty()) {
			this.unidad = new UnidadDto();
			this.unidad.setNombre("No encontrada");
			listaUnidades = Arrays.asList(this.unidad);
		}
		return listaUnidades;
	}

	public List<MarcaDto> buscarMarcas(String consulta) {
		LOG.debug("");
		List<MarcaDto> listaMarcas = null;
		try {
			busquedaMarca.setNombre(consulta);
			busquedaMarca.setTypeMatchNombre(StringEnum.CONTENIDO);
			listaMarcas = getServicioPrecio().buscarMarcas(busquedaMarca);
		} catch (ExcepcionServicio e) {
			listaMarcas = new ArrayList<MarcaDto>();
		}
		if (listaMarcas == null || listaMarcas.isEmpty()) {
			this.marca = new MarcaDto();
			this.marca.setNombre("No encontrada");
			listaMarcas = Arrays.asList(this.marca);
		}
		return listaMarcas;
	}

	public PrecioDto getPrecio() {
		if (this.precio == null) {
			this.precio = new PrecioDto();
		}
		return precio;
	}

	public void setPrecio(PrecioDto precio) {
		LOG.debug("");
		this.precio = precio;
		inicializarValoresAutocompletados();
	}

	public boolean isEditando() {
		return !NumberUtil.esNuloOMenorQueUno(this.getPrecio().getId());
	}

	public ProductoDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

	public UnidadDto getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadDto unidad) {
		this.unidad = unidad;
	}

	public MarcaDto getMarca() {
		return marca;
	}

	public void setMarca(MarcaDto marca) {
		this.marca = marca;
	}

}
