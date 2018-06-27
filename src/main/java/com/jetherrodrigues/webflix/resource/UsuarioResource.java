package com.jetherrodrigues.webflix.resource;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jetherrodrigues.webflix.domain.Usuario;
import com.jetherrodrigues.webflix.exceptions.WebflixUsuarioNotFound;
import com.jetherrodrigues.webflix.service.UsuarioService;
import static com.jetherrodrigues.webflix.util.ApiVersionUtil.*;

@RestController
@RequestMapping(value={
		REST_APP + VERSION_V1 + USUARIO
})
public class UsuarioResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731366882357556547L;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(this.usuarioService.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(name="id") String id) throws WebflixUsuarioNotFound {
		Usuario usuario = this.usuarioService.findById(id);
		
		if(usuario == null) throw new WebflixUsuarioNotFound("There is no image with this id!");
		
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(usuario);
	}
	
	@GetMapping("{login}/{senha}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(name="login") String login,@PathVariable(name="senha") String senha ) throws WebflixUsuarioNotFound {
		Usuario usuario = this.usuarioService.findByLogin(login, senha);
		if(usuario == null) throw new WebflixUsuarioNotFound("There is no image with this id!");
		
		return ResponseEntity.status(HttpStatus.OK)
				.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
				.body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Void> saveUsuario(@Valid @RequestBody Usuario usuario) {
		usuario = this.usuarioService.save(usuario);
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuario.getId())
				.toUri()).build();
	}
}
