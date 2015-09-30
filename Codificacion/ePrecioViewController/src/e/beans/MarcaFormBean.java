package e.beans;

import org.apache.log4j.Logger;

import e.base.dto.validacion.MensajeDto;
import e.base.util.NumberUtil;
import e.dto.dominio.MarcaDto;
import e.servicio.constantes.ConstantesAction;

public class MarcaFormBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(MarcaFormBean.class);
	private MarcaDto marca;

	public MarcaFormBean() {
		super();
	}

	public String agregarMarca() {
		LOG.debug("");
		this.marca = new MarcaDto();
		return ConstantesAction.EDITAR_MARCA;
	}

	public String editarMarca() {
		return ConstantesAction.EDITAR_MARCA;
	}

	public String listaMarca() {
		return ConstantesAction.LISTA_MARCA;
	}

	public String guardarNuevoMarca() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().guardarMarca(marca);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public String guardarEdicionMarca() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().editarMarca(marca);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public MarcaDto getMarca() {
		if (this.marca == null) {
			this.marca = new MarcaDto();
		}
		return marca;
	}

	public void setMarca(MarcaDto marca) {
		LOG.info(marca);
		this.marca = marca;
	}

	public boolean isEditando() {
		return !NumberUtil.esNuloOMenorQueUno(this.getMarca().getId());
	}

}
