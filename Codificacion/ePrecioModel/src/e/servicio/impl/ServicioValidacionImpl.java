package e.servicio.impl;

import e.base.Constantes;
import e.base.dominio.DominioBaseNombre;
import e.base.dto.validacion.MensajeDto;
import e.base.util.NumberUtil;
import e.base.util.StringUtil;
import e.dominio.Precio;
import e.dominio.Unidad;

public class ServicioValidacionImpl {

	public MensajeDto validarNuevo(DominioBaseNombre dominioBaseNombre, MensajeDto mensajeDto) {
		if (StringUtil.esVacio(dominioBaseNombre.getNombre())) {
			mensajeDto.getMensajes().add("Ingrese Nombre");
		}
		if (!mensajeDto.getMensajes().isEmpty()) {
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
		}
		return mensajeDto;
	}

	public MensajeDto validarEdicion(DominioBaseNombre dominioBaseNombre, MensajeDto mensajeDto) {
		if (NumberUtil.esNuloOMenorQueUno(dominioBaseNombre.getId())) {
			mensajeDto.getMensajes().add("No existe el Identificador para su edicion.");
		}
		if (StringUtil.esVacio(dominioBaseNombre.getNombre())) {
			mensajeDto.getMensajes().add("Ingrese Nombre");
		}
		if (!mensajeDto.getMensajes().isEmpty()) {
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
		}
		return mensajeDto;
	}

	public MensajeDto validarNuevaUnidad(Unidad unidad, MensajeDto mensajeDto) {
		mensajeDto = validarNuevo(unidad, mensajeDto);
		return validarUnidad(unidad, mensajeDto);
	}

	public MensajeDto validarEdicionUnidad(Unidad unidad, MensajeDto mensajeDto) {
		mensajeDto = validarEdicion(unidad, mensajeDto);
		return validarUnidad(unidad, mensajeDto);
	}

	private MensajeDto validarUnidad(Unidad unidad, MensajeDto mensajeDto) {
		int cont = mensajeDto.getMensajes().size();
		if (NumberUtil.esNuloOMenorQueUno(unidad.getIdDimension())) {
			mensajeDto.getMensajes().add("No se encuentra sociada a una Dimension.");
		}
		if (NumberUtil.esNuloOMenorQueUno(unidad.getFactorDenominador())) {
			mensajeDto.getMensajes().add("Denominador debe ser como minimo uno.");
		}
		if (cont < mensajeDto.getMensajes().size()) {
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
		}
		return mensajeDto;
	}

	public MensajeDto validarNuevoPrecio(Precio precio, MensajeDto mensajeDto) {
		int cont = mensajeDto.getMensajes().size();
		if (NumberUtil.esNuloOMenorQueUno(precio.getIdProducto())) {
			mensajeDto.getMensajes().add("No posee Producto asociado.");
		}
		if (NumberUtil.esNuloOMenorQueUno(precio.getIdUnidad())) {
			mensajeDto.getMensajes().add("No posee Unidad asociada.");
		}
		if (!NumberUtil.esMayorACero(precio.getPrecio())) {
			mensajeDto.getMensajes().add("Ingrese Precio.");
		}
		if (precio.getFechaInicio() == null) {
			mensajeDto.getMensajes().add("Ingrese Fecha de inicio.");
		}
		if (cont < mensajeDto.getMensajes().size()) {
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
		}
		return mensajeDto;
	}

	public MensajeDto validarEdicionPrecio(Precio precio, MensajeDto mensajeDto) {
		mensajeDto = validarNuevoPrecio(precio, mensajeDto);
		int cont = mensajeDto.getMensajes().size();
		if (NumberUtil.esNuloOMenorQueUno(precio.getId())) {
			mensajeDto.getMensajes().add("No existe el Identificador para su edicion.");
		}
		if (cont < mensajeDto.getMensajes().size()) {
			mensajeDto.setId(Constantes.MENSAJE_ERROR);
			mensajeDto.setMostrarRetorno(true);
		}
		return mensajeDto;
	}
}
