package e.dto.builder;

import e.base.dto.builder.BaseBuilder;
import e.base.dto.contexto.UsuarioWebDto;
import e.dominio.Usuario;
import e.dto.dominio.UsuarioDto;

public class UsuarioBuilder extends BaseBuilder {

	public Usuario buildDominio(UsuarioDto usuarioDto, Usuario usuario) {
		usuario = (Usuario) super.buildDominio(usuarioDto, usuario);
		usuario.setClave(usuarioDto.getClave());
		usuario.setUsuario(usuarioDto.getUsuario());
		return usuario;
	}

	public UsuarioDto buildDTO(Usuario usuario, UsuarioDto usuarioDto) {
		usuarioDto = (UsuarioDto) super.buildDTO(usuario, usuarioDto);
		usuarioDto.setClave(usuario.getClave());
		usuarioDto.setUsuario(usuario.getUsuario());
		return usuarioDto;
	}

	public UsuarioWebDto buildDTO(Usuario usuario, UsuarioWebDto usuarioDto) {
		usuarioDto = (UsuarioWebDto) super.buildDTO(usuario, usuarioDto);
		usuarioDto.setUsuario(usuario.getUsuario());
		return usuarioDto;
	}

}
