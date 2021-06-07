	package com.leidsonjesus.whorkshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leidsonjesus.whorkshopmongo.domain.Post;
import com.leidsonjesus.whorkshopmongo.repository.PostRepository;
import com.leidsonjesus.whorkshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repro;
	
	public Post findById(String id) {
		Optional<Post> obj = repro.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Post> findByTitle(String text){
		return repro.searchTitle(text);
	}
 	
	public 	List <Post> fullSearch(String text, Date minDate, Date maxDate){
			maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 *1000);
			return repro.fullSearch(text, minDate, maxDate);
	}
}
