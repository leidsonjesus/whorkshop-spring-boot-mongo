package com.leidsonjesus.whorkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leidsonjesus.whorkshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
