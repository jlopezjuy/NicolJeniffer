package ar.com.juanlopez.clothes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.juanlopez.clothes.model.Usuario;
import ar.com.juanlopez.clothes.service.impl.UsuarioServiceImpl;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	/**
	 * Metodo para obtener todos los usuarios
	 * @return
	 */
	@RequestMapping(value="/usuarios", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		List<Usuario> usuarios = null;
		try {
			 usuarios= usuarioServiceImpl.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); 
	}
	
	/**
	 * Metodo para dar de alta un nuevo usuario
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/usuario/add",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
		Usuario usu = null;
		try {
			usu = usuarioServiceImpl.create(usuario);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(usu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Usuario>(usu, HttpStatus.OK); 
	}
}
