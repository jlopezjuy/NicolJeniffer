package e.dto.builder;

import e.base.dto.builder.BaseBuilder;
import e.dominio.Transaccion;
import e.dto.dominio.TransaccionDto;

public class TransaccionBuilder extends BaseBuilder {

	public Transaccion buildDominio(TransaccionDto transaccionDto, Transaccion transaccion) {
		transaccion = (Transaccion) super.buildDominio(transaccionDto, transaccion);
		transaccion.setAjuste(transaccionDto.getAjuste());
		transaccion.setDescuento(transaccionDto.getDescuento());
		transaccion.setFechaTransaccion(transaccionDto.getFechaTransaccion());
		transaccion.setIdEstadoTransaccion(transaccionDto.getIdEstadoTransaccion());
		transaccion.setIdPersonaEmisor(transaccionDto.getIdPersonaEmisor());
		transaccion.setIdPersonaReceptor(transaccionDto.getIdPersonaReceptor());
		transaccion.setIdTipoTransaccion(transaccionDto.getIdTipoTransaccion());
		transaccion.setInteres(transaccionDto.getInteres());
		return transaccion;
	}

	public TransaccionDto buildDTO(Transaccion transaccion, TransaccionDto transaccionDto) {
		transaccionDto = (TransaccionDto) super.buildDTO(transaccion, transaccionDto);
		transaccionDto.setAjuste(transaccion.getAjuste());
		transaccionDto.setDescuento(transaccion.getDescuento());
		transaccionDto.setFechaTransaccion(transaccion.getFechaTransaccion());
		transaccionDto.setIdEstadoTransaccion(transaccion.getIdEstadoTransaccion());
		transaccionDto.setIdPersonaEmisor(transaccion.getIdPersonaEmisor());
		transaccionDto.setIdPersonaReceptor(transaccion.getIdPersonaReceptor());
		transaccionDto.setIdTipoTransaccion(transaccion.getIdTipoTransaccion());
		transaccionDto.setInteres(transaccion.getInteres());
		return transaccionDto;
	}

}
