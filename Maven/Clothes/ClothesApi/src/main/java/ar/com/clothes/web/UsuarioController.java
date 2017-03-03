package ar.com.clothes.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.clothes.model.Usuario;
import ar.com.clothes.service.UsuarioService;

@RestController
public class UsuarioController {

	private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/getAllUsuarios", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Usuario> getAllUsuarios() {

		List<Usuario> listUsuarios = usuarioService.findAllUsuarios();
		return listUsuarios;
	}

	@RequestMapping(value = "/getUsuario/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Usuario getUsuarioById(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}

	@RequestMapping(value = "/addUsuario", method = { RequestMethod.POST }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

	// lukas

	@RequestMapping(path = "/listaUsuarios", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Usuario> listUsuario() {
		return this.usuarioService.findAllUsuarios();
	}

	@RequestMapping(value = "/addEntity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEntity(@RequestBody Usuario usuario) {

		System.out.println("guardado con name  :" + usuario.getNombreApellido() + "cuit  :" + usuario.getNombreUsuario());

		ResponseEntity<?> responseEntity;
		responseEntity = new ResponseEntity<>(HttpStatus.OK);

		LOGGER.info("paso " + usuario.getNombreApellido());

		return responseEntity;

	}

}
