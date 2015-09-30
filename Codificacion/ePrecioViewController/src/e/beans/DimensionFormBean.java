package e.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import e.base.dto.validacion.MensajeDto;
import e.base.util.NumberUtil;
import e.dto.busqueda.BusquedaUnidadDto;
import e.dto.dominio.DimensionDto;
import e.dto.dominio.UnidadDto;
import e.servicio.constantes.ConstantesAction;

public class DimensionFormBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(DimensionFormBean.class);
	private DimensionDto dimension;
	private BusquedaUnidadDto busquedaUnidad = new BusquedaUnidadDto();
	private List<UnidadDto> unidades;

	public DimensionFormBean() {
		super();
	}

	public String agregarDimension() {
		LOG.debug("");
		this.dimension = new DimensionDto();
		return ConstantesAction.EDITAR_DIMENSION;
	}

	public String editarDimension() {
		return ConstantesAction.EDITAR_DIMENSION;
	}

	public String listaDimension() {
		return ConstantesAction.LISTA_DIMENSION;
	}

	public String guardarNuevoDimension() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().guardarDimension(dimension);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public String guardarEdicionDimension() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().editarDimension(dimension);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public DimensionDto getDimension() {
		if (this.dimension == null) {
			this.dimension = new DimensionDto();
		}
		return dimension;
	}

	public void setDimension(DimensionDto dimension) {
		LOG.info(dimension);
		try {
			this.dimension = dimension;
			this.busquedaUnidad.iniciar();
			this.busquedaUnidad.setNombre(null);
			this.busquedaUnidad.setIdDimension(dimension.getId());
			this.unidades = getServicioPrecio().buscarUnidades(this.busquedaUnidad);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isEditando() {
		return !NumberUtil.esNuloOMenorQueUno(this.getDimension().getId());
	}

	public List<UnidadDto> getUnidades() {
		if (this.unidades == null) {
			this.unidades = new ArrayList<UnidadDto>();
		}
		return unidades;
	}
}
