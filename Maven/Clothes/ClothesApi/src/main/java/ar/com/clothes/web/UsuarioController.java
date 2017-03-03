package ar.com.clothes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.clothes.model.Usuario;
import ar.com.clothes.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/getAllUsuarios", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Usuario> getAllUsuarios() {

		List<Usuario> listOfCountries = usuarioService.findAllUsuarios();
		return listOfCountries;
	}

	@RequestMapping(value = "/getUsuario/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Usuario getUsuarioById(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}

	@RequestMapping(value = "/addUsuario", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUsuario(@RequestBody Usuario usuario) {
		usuarioService.saveUsuario(usuario);

	}

	@RequestMapping(value = "/updateUsuario", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateUsuario(@RequestBody Usuario usuario) {
		usuarioService.updateUsuario(usuario);
	}

	@RequestMapping(value = "/deleteUsuario/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUsuario(@PathVariable("id") int usuarioId) {
		usuarioService.deleteUsuarioById(usuarioId);
	}

}
