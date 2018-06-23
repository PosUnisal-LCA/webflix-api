package com.jetherrodrigues.webflix.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "usuario") 
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8641803422312063514L;
	@Id 
	private String id;
	@JsonInclude(Include.NON_NULL)
	private String name;
	@JsonInclude(Include.NON_NULL)
	private String login;
	@JsonInclude(Include.NON_NULL)
	private String senha;
	@JsonInclude(Include.NON_NULL)
	private LocalDateTime created;

	
	public Usuario() {
		this.id = UUID.randomUUID().toString();
		this.created = LocalDateTime.now();
	}
	
	public Usuario(String name, String login, String senha) {
		this.id = UUID.randomUUID().toString();
		this.created = LocalDateTime.now();
		
		this.name = name;
		this.login = login;
		this.senha = senha;

	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override  
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
