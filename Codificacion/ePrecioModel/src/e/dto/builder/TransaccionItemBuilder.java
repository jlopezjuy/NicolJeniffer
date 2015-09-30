package e.dto.builder;

import e.base.dto.builder.BaseBuilder;
import e.dominio.TransaccionItem;
import e.dto.dominio.TransaccionItemDto;

public class TransaccionItemBuilder extends BaseBuilder {

	public TransaccionItem buildDominio(TransaccionItemDto transaccionItemDto, TransaccionItem transaccionItem) {
		transaccionItem = (TransaccionItem) super.buildDominio(transaccionItemDto, transaccionItem);
		transaccionItem.setCantidad(transaccionItemDto.getCantidad());
		transaccionItem.setIdMarca(transaccionItemDto.getIdMarca());
		transaccionItem.setIdProducto(transaccionItemDto.getIdProducto());
		transaccionItem.setIdTransaccion(transaccionItemDto.getIdTransaccion());
		transaccionItem.setIdUnidad(transaccionItemDto.getIdUnidad());
		transaccionItem.setPrecioUnitario(transaccionItemDto.getPrecioUnitario());
		return transaccionItem;
	}

	public TransaccionItemDto buildDTO(TransaccionItem transaccionItem, TransaccionItemDto transaccionItemDto) {
		transaccionItemDto = (TransaccionItemDto) super.buildDTO(transaccionItem, transaccionItemDto);
		transaccionItemDto.setCantidad(transaccionItem.getCantidad());
		transaccionItemDto.setIdMarca(transaccionItem.getIdMarca());
		transaccionItemDto.setIdProducto(transaccionItem.getIdProducto());
		transaccionItemDto.setIdTransaccion(transaccionItem.getIdTransaccion());
		transaccionItemDto.setIdUnidad(transaccionItem.getIdUnidad());
		transaccionItemDto.setPrecioUnitario(transaccionItem.getPrecioUnitario());
		return transaccionItemDto;
	}

}
