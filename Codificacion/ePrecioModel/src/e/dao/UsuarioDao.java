package e.dao;

import e.base.dao.DAOBase;
import e.dominio.entity.Usuario;

public interface UsuarioDao extends DAOBase<Usuario, Long> {

	Usuario verificar(String usuario, String clave);

}
