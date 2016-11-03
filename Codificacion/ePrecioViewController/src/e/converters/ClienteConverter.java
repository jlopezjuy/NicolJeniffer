package e.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import e.base.excepcion.ExcepcionBaseDeDato;
import e.dao.ClienteDao;
import e.dao.impl.ClienteDaoImpl;
import e.dominio.entity.Clientes;

public class ClienteConverter implements Converter {
	private ClienteDao clienteDao = new ClienteDaoImpl();;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// TODO Auto-generated method stub
		try {
			return clienteDao.obtener(Long.valueOf(value));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionBaseDeDato e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		System.out.println("Valor seleccionado: "+ value.toString());
		if(null == value)
			return null;
		Clientes cliente = (Clientes)value;
		int id = cliente.getIdClientes();
		return String.valueOf(id);
	}

}
