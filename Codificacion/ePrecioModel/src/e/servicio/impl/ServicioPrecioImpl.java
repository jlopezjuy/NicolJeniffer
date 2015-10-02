package e.servicio.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import e.base.Constantes;
import e.base.dto.contexto.UsuarioWebDto;
import e.base.dto.validacion.MensajeDto;
import e.base.excepcion.ExcepcionBaseDeDato;
import e.base.excepcion.ExcepcionServicio;
import e.dao.ClienteDao;
import e.dao.DimensionDao;
import e.dao.EstadoTransaccionDao;
import e.dao.MarcaDao;
import e.dao.PersonaDao;
import e.dao.PrecioDao;
import e.dao.ProductoDao;
import e.dao.TipoPersonaDao;
import e.dao.TipoProductoDao;
import e.dao.TipoTransaccionDao;
import e.dao.TransaccionDao;
import e.dao.TransaccionItemDao;
import e.dao.UnidadDao;
import e.dao.UsuarioDao;
import e.dominio.Dimension;
import e.dominio.Marca;
import e.dominio.Precio;
import e.dominio.Producto;
import e.dominio.Unidad;
import e.dominio.Usuario;
import e.dominio.entity.Clientes;
import e.dto.busqueda.BusquedaDimensionDto;
import e.dto.busqueda.BusquedaMarcaDto;
import e.dto.busqueda.BusquedaPersonaDto;
import e.dto.busqueda.BusquedaPrecioDto;
import e.dto.busqueda.BusquedaProductoDto;
import e.dto.busqueda.BusquedaUnidadDto;
import e.dto.dominio.ClienteDto;
import e.dto.dominio.DimensionDto;
import e.dto.dominio.MarcaDto;
import e.dto.dominio.PersonaDto;
import e.dto.dominio.PrecioDto;
import e.dto.dominio.ProductoDto;
import e.dto.dominio.UnidadDto;
import e.servicio.ServicioPrecio;
import e.servicio.constantes.ConstantesAction;

public class ServicioPrecioImpl implements ServicioPrecio {
	private final static Logger LOG = Logger.getLogger(ServicioPrecioImpl.class);
	private SessionFactory sessionFactory;

	private ServicioDtoImpl servicioDto;
	private ServicioValidacionImpl servicioValidacion = new ServicioValidacionImpl();
	//
	private DimensionDao dimensionDao;
	private EstadoTransaccionDao estadoTransaccionDao;
	private MarcaDao marcaDao;
	private PersonaDao personaDao;
	private PrecioDao precioDao;
	private ProductoDao productoDao;
	private TipoPersonaDao tipoPersonaDao;
	private TipoProductoDao tipoProductoDao;
	private TipoTransaccionDao tipoTransaccionDao;
	private TransaccionDao transaccionDao;
	private TransaccionItemDao transaccionItemDao;
	private UnidadDao unidadDao;
	private UsuarioDao usuarioDao;
	private ClienteDao clienteDao;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setServicioDto(ServicioDtoImpl servicioDto) {
		this.servicioDto = servicioDto;
	}

	public void setDimensionDao(DimensionDao dimensionDao) {
		this.dimensionDao = dimensionDao;
	}

	public void setEstadoTransaccionDao(EstadoTransaccionDao estadoTransaccionDao) {
		this.estadoTransaccionDao = estadoTransaccionDao;
	}

	public void setMarcaDao(MarcaDao marcaDao) {
		this.marcaDao = marcaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public void setPrecioDao(PrecioDao precioDao) {
		this.precioDao = precioDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	public void setTipoPersonaDao(TipoPersonaDao tipoPersonaDao) {
		this.tipoPersonaDao = tipoPersonaDao;
	}

	public void setTipoProductoDao(TipoProductoDao tipoProductoDao) {
		this.tipoProductoDao = tipoProductoDao;
	}

	public void setTipoTransaccionDao(TipoTransaccionDao tipoTransaccionDao) {
		this.tipoTransaccionDao = tipoTransaccionDao;
	}

	public void setTransaccionDao(TransaccionDao transaccionDao) {
		this.transaccionDao = transaccionDao;
	}

	public void setTransaccionItemDao(TransaccionItemDao transaccionItemDao) {
		this.transaccionItemDao = transaccionItemDao;
	}

	public void setUnidadDao(UnidadDao unidadDao) {
		this.unidadDao = unidadDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	

	// Usuarios

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public UsuarioWebDto iniciarSesion(String usuario, String clave) throws ExcepcionServicio {
		UsuarioWebDto usuarioWeb = null;
		try {
			Usuario usuarioVerificado = usuarioDao.verificar(usuario, clave);
			LOG.debug(usuarioVerificado);
			if (usuarioVerificado != null) {
				usuarioWeb = servicioDto.getUsuarioWebDto(usuarioVerificado);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		LOG.debug(usuarioWeb);
		return usuarioWeb;
	}

	private void editar(Object dominio) throws Exception {
		Session sesion = null;
		Transaction transaccion = null;
		try {
			LOG.debug("");
			sesion = sessionFactory.openSession();
			transaccion = sesion.beginTransaction();
			sesion.update(dominio);
			transaccion.commit();
			sesion.flush();
		} catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	@Override
	public void editarPersona(PersonaDto persona) throws ExcepcionServicio {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarPersona(PersonaDto persona) throws ExcepcionServicio {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PersonaDto> buscarPersonas(BusquedaPersonaDto busquedaPersonaDto) throws ExcepcionServicio {
		// TODO Auto-generated method stub
		return null;
	}

	// Productos

	@Override
	public MensajeDto guardarProducto(ProductoDto productoDto) {
		MensajeDto mensajeDto = new MensajeDto("Nuevo Producto", ConstantesAction.EDITAR_PRODUCTO, ConstantesAction.LISTA_PRODUCTO);
		try {
			LOG.debug("");
			Producto producto = servicioDto.getProducto(productoDto);
			mensajeDto = servicioValidacion.validarNuevo(producto, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				productoDao.guardar(producto);
				mensajeDto.getMensajes().add("Nuevo de producto guardado.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public MensajeDto editarProducto(ProductoDto productoDto) {
		MensajeDto mensajeDto = new MensajeDto("Edicion Producto", ConstantesAction.EDITAR_PRODUCTO, ConstantesAction.LISTA_PRODUCTO);
		try {
			LOG.debug("");
			Producto producto = servicioDto.getProducto(productoDto);
			mensajeDto = servicioValidacion.validarEdicion(producto, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				this.editar(producto);
				mensajeDto.getMensajes().add("Edicion de producto guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public List<ProductoDto> buscarProductos(BusquedaProductoDto busquedaProducto) throws ExcepcionServicio {
		LOG.debug("");
		List<Producto> lista = productoDao.buscar(busquedaProducto);
		return servicioDto.getProductoDTO(lista);
	}

	@Override
	public ProductoDto obtenerProducto(Long idProducto) {
		ProductoDto productoDto = null;
		try {
			Producto producto = productoDao.obtener(idProducto);
			productoDto = servicioDto.getProductoDTO(producto);
		} catch (ExcepcionBaseDeDato e) {
			LOG.error("Error", e);
		}
		return productoDto;
	}

	// Marcas

	@Override
	public List<MarcaDto> buscarMarcas(BusquedaMarcaDto busquedaMarcaDto) throws ExcepcionServicio {
		LOG.debug("");
		List<Marca> lista = marcaDao.buscar(busquedaMarcaDto);
		return servicioDto.getMarcaDTO(lista);
	}

	@Override
	public MensajeDto guardarMarca(MarcaDto marcaDto) {
		MensajeDto mensajeDto = new MensajeDto("Nueva Marca", ConstantesAction.EDITAR_MARCA, ConstantesAction.LISTA_MARCA);
		try {
			LOG.debug("");
			Marca marca = servicioDto.getMarca(marcaDto);
			mensajeDto = servicioValidacion.validarNuevo(marca, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				marcaDao.guardar(marca);
				mensajeDto.getMensajes().add("Nueva Marca guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public MensajeDto editarMarca(MarcaDto marcaDto) {
		MensajeDto mensajeDto = new MensajeDto("Edicion Marca", ConstantesAction.EDITAR_MARCA, ConstantesAction.LISTA_MARCA);
		try {
			LOG.debug("");
			Marca marca = servicioDto.getMarca(marcaDto);
			mensajeDto = servicioValidacion.validarEdicion(marca, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				this.editar(marca);
				mensajeDto.getMensajes().add("Edicion de Marca guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public MarcaDto obtenerMarca(Long idMarca) {
		MarcaDto marcaDto = null;
		try {
			Marca marca = marcaDao.obtener(idMarca);
			marcaDto = servicioDto.getMarcaDTO(marca);
		} catch (ExcepcionBaseDeDato e) {
			LOG.error("Error", e);
		}
		return marcaDto;
	}

	// Dimensiones

	@Override
	public List<DimensionDto> buscarDimensiones(BusquedaDimensionDto busquedaDimensionDto) throws ExcepcionServicio {
		LOG.debug("");
		List<Dimension> lista = dimensionDao.buscar(busquedaDimensionDto);
		return servicioDto.getDimensionDTO(lista);
	}

	@Override
	public MensajeDto guardarDimension(DimensionDto dimensionDto) {
		MensajeDto mensajeDto = new MensajeDto("Nueva Dimension", ConstantesAction.EDITAR_DIMENSION, ConstantesAction.LISTA_DIMENSION);
		try {
			LOG.debug("");
			Dimension dimension = servicioDto.getDimension(dimensionDto);
			mensajeDto = servicioValidacion.validarNuevo(dimension, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				dimensionDao.guardar(dimension);
				mensajeDto.getMensajes().add("Nueva Dimension guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public MensajeDto editarDimension(DimensionDto dimensionDto) {
		MensajeDto mensajeDto = new MensajeDto("Edicion Dimension", ConstantesAction.EDITAR_DIMENSION, ConstantesAction.LISTA_DIMENSION);
		try {
			LOG.debug("");
			Dimension dimension = servicioDto.getDimension(dimensionDto);
			mensajeDto = servicioValidacion.validarEdicion(dimension, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				this.editar(dimension);
				mensajeDto.getMensajes().add("Edicion de Dimension guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	// Unidades

	@Override
	public List<UnidadDto> buscarUnidades(BusquedaUnidadDto busquedaUnidadDto) throws ExcepcionServicio {
		LOG.debug("");
		List<Unidad> lista = unidadDao.buscar(busquedaUnidadDto);
		return servicioDto.getUnidadDTO(lista);
	}

	@Override
	public MensajeDto guardarUnidad(UnidadDto unidadDto) {
		MensajeDto mensajeDto = new MensajeDto("Nueva Unidad", ConstantesAction.EDITAR_UNIDAD, ConstantesAction.LISTA_DIMENSION);
		try {
			LOG.debug("");
			Unidad unidad = servicioDto.getUnidad(unidadDto);
			mensajeDto = servicioValidacion.validarNuevaUnidad(unidad, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				unidadDao.guardar(unidad);
				mensajeDto.getMensajes().add("Nueva Unidad guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public MensajeDto editarUnidad(UnidadDto unidadDto) {
		MensajeDto mensajeDto = new MensajeDto("Edicion de Unidad", ConstantesAction.EDITAR_UNIDAD, ConstantesAction.LISTA_DIMENSION);
		try {
			LOG.debug("");
			Unidad unidad = servicioDto.getUnidad(unidadDto);
			mensajeDto = servicioValidacion.validarEdicionUnidad(unidad, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				this.editar(unidad);
				mensajeDto.getMensajes().add("Edicion de Unidad guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public UnidadDto obtenerUnidad(Long idUnidad) {
		UnidadDto unidadDto = null;
		try {
			Unidad unidad = unidadDao.obtener(idUnidad);
			unidadDto = servicioDto.getUnidadDTO(unidad);
		} catch (ExcepcionBaseDeDato e) {
			LOG.error("Error", e);
		}
		return unidadDto;
	}

	// Precios

	@Override
	public List<PrecioDto> buscarPrecios(BusquedaPrecioDto busquedaPrecioDto) throws ExcepcionServicio {
		LOG.debug("");
		List<Precio> lista = precioDao.buscar(busquedaPrecioDto);
		return servicioDto.getPrecioDTO(lista);
	}

	@Override
	public MensajeDto guardarPrecio(PrecioDto precioDto) {
		MensajeDto mensajeDto = new MensajeDto("Nueva Precio", ConstantesAction.EDITAR_PRECIO, ConstantesAction.LISTA_PRECIO);
		try {
			LOG.debug("");
			Precio precio = servicioDto.getPrecio(precioDto);
			mensajeDto = servicioValidacion.validarNuevoPrecio(precio, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				precioDao.guardar(precio);
				mensajeDto.getMensajes().add("Nueva Precio guardado.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public MensajeDto editarPrecio(PrecioDto precioDto) {
		MensajeDto mensajeDto = new MensajeDto("Edicion de Precio", ConstantesAction.EDITAR_PRECIO, ConstantesAction.LISTA_PRECIO);
		try {
			LOG.debug("");
			Precio precio = servicioDto.getPrecio(precioDto);
			mensajeDto = servicioValidacion.validarEdicionPrecio(precio, mensajeDto);
			if (Constantes.MENSAJE_OK.equals(mensajeDto.getId())) {
				this.editar(precio);
				mensajeDto.getMensajes().add("Edicion de Precio guardada.");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
			mensajeDto.getMensajes().add("Error General" + e.getMessage());
		}
		return mensajeDto;
	}

	@Override
	public List<ClienteDto> listAll() {
		List<Clientes> list;
		try {
			list = clienteDao.listar();
			LOG.debug("ENCONTRO DATOS....: "+ list.size());
			return servicioDto.getClienteDTO(list);
		} catch (ExcepcionBaseDeDato e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
