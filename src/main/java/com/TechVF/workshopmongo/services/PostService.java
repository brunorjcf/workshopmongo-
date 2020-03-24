package com.TechVF.workshopmongo.services;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechVF.workshopmongo.domain.Post;
import com.TechVF.workshopmongo.repository.PostRepository;
import com.TechVF.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;	
	
	public Post findById(String id) {
		Post user = repo.findOne(id);
		if ( user == null) {
		throw new ObjectNotFoundException("Objeto não encontrado");
	}
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, java.util.Date min, java.util.Date max){
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, min, max);
	}
}
