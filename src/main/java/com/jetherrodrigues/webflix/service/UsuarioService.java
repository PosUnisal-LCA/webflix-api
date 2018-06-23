package com.jetherrodrigues.webflix.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetherrodrigues.webflix.domain.Usuario;
import com.jetherrodrigues.webflix.repository.UsuarioRepository;
import com.jetherrodrigues.webflix.repository.UsuarioRepository;

@Service
public class UsuarioService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9044441985294788487L;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public Usuario findById(String id) {
		return this.usuarioRepository.findOne(id);
	}
	
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}
}
