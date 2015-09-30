package e.beans;

import org.apache.log4j.Logger;

import e.base.dto.validacion.MensajeDto;
import e.base.util.NumberUtil;
import e.dto.dominio.ProductoDto;
import e.servicio.constantes.ConstantesAction;

public class ProductoFormBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(ProductoFormBean.class);
	private ProductoDto producto;

	public ProductoFormBean() {
		super();
	}

	public String agregarProducto() {
		LOG.debug("");
		this.producto = new ProductoDto();
		return ConstantesAction.EDITAR_PRODUCTO;
	}

	public String editarProducto() {
		return ConstantesAction.EDITAR_PRODUCTO;
	}

	public String listaProducto() {
		return ConstantesAction.LISTA_PRODUCTO;
	}

	public String guardarNuevoProducto() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().guardarProducto(producto);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public String guardarEdicionProducto() {
		LOG.info("");
		MensajeDto mensajeDto = getServicioPrecio().editarProducto(producto);
		super.setMensajeDto(mensajeDto);
		return ConstantesAction.MENSAJE;
	}

	public ProductoDto getProducto() {
		if (this.producto == null) {
			this.producto = new ProductoDto();
		}
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		LOG.info(producto);
		this.producto = producto;
	}

	public boolean isEditando() {
		return !NumberUtil.esNuloOMenorQueUno(this.getProducto().getId());
	}

}
