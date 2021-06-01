package com.leidsonjesus.whorkshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leidsonjesus.whorkshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	
	//@RequestMapping(method=RequestMethod.GET) mesma coisa que @GetMapping
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown" , "Maria@gmail.com");
		User alex = new User("1", "Alex Green" , "Alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
		
	}

}
