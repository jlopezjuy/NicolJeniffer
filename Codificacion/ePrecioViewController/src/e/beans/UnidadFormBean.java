package e.beans;

import org.apache.log4j.Logger;

import e.base.dto.validacion.MensajeDto;
import e.base.util.NumberUtil;
import e.dto.dominio.UnidadDto;
import e.servicio.constantes.ConstantesAction;

public class UnidadFormBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(UnidadFormBean.class);
	private UnidadDto unidad;

	public UnidadFormBean() {
		super();
	}

	public String agregarUnidad() {
		LOG.debug("");
		this.unidad = new UnidadDto();
		return ConstantesAction.EDITAR_UNIDAD;
	}

	public String editarUnidad() {
		return ConstantesAction.EDITAR_UNIDAD;
	}

	public String guardarNuevoUnidad() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().guardarUnidad(unidad);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public String guardarEdicionUnidad() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().editarUnidad(unidad);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public UnidadDto getUnidad() {
		if (this.unidad == null) {
			this.unidad = new UnidadDto();
		}
		return unidad;
	}

	public void setUnidad(UnidadDto unidad) {
		LOG.info(unidad);
		this.unidad = unidad;
	}

	public boolean isEditando() {
		return !NumberUtil.esNuloOMenorQueUno(this.getUnidad().getId());
	}

}
