package com.leidsonjesus.whorkshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leidsonjesus.whorkshopmongo.domain.User;
import com.leidsonjesus.whorkshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repro;
	
	public List<User> findAll(){
		return repro.findAll();
	}

}
