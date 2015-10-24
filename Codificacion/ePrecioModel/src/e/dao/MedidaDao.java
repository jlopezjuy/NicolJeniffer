package e.dao;

import java.util.List;

import e.base.dao.DAOBase;
import e.dominio.entity.Clientes;
import e.dominio.entity.Medidas;

public interface MedidaDao extends DAOBase<Medidas, Long>{
	List<Medidas> buscarMedida(String medida);
	List<Medidas> listarMedidas(Clientes cliente);
	void guardarMedida(Medidas medida);
}
