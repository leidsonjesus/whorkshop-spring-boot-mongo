package com.leidsonjesus.whorkshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leidsonjesus.whorkshopmongo.domain.Post;
import com.leidsonjesus.whorkshopmongo.domain.User;
import com.leidsonjesus.whorkshopmongo.dto.AuthorDTO;
import com.leidsonjesus.whorkshopmongo.dto.CommentDTO;
import com.leidsonjesus.whorkshopmongo.repository.PostRepository;
import com.leidsonjesus.whorkshopmongo.repository.UserRepository;

@Configuration	
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository	userReposiroty;
	
	@Autowired
	private PostRepository postRepository;
	
		
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")	);
		
		userReposiroty.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "Vou viajar para São Paulo !", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia ", " Acordei feliz hoje :) !", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa Viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha Otimo dia !!", sdf.parse("23/03/2018"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userReposiroty.save(maria);
	}

}
