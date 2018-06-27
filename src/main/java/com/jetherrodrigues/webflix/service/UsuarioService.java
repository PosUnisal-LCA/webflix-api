package com.jetherrodrigues.webflix.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
	@Autowired
    MongoTemplate mongoTemplate;

	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public Usuario findById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return (Usuario) this.mongoTemplate.findOne(query, Usuario.class);
		//return this.usuarioRepository.findOne(id);
	}
	public Usuario findByLogin(String login,String senha ) {
		Query query = new Query();
		query.addCriteria(Criteria.where("login").is(login).and("senha").is(senha));
		return (Usuario) this.mongoTemplate.findOne(query, Usuario.class);

	}
	public boolean delete(String id) {
		this.usuarioRepository.delete(id);
		return true;
	}
	
	public Usuario update(Usuario usuario) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(usuario.getId()));

		Update update = new Update();
		update.set("name", usuario.getName());
		update.set("senha", usuario.getSenha());
		update.set("login", usuario.getLogin());

		this.mongoTemplate.updateFirst(query, update, Usuario.class);

		return usuario;
	}
	
	
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}
}
