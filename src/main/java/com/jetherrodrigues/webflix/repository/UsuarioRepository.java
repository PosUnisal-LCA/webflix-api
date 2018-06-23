package com.jetherrodrigues.webflix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jetherrodrigues.webflix.domain.Category;
import com.jetherrodrigues.webflix.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
