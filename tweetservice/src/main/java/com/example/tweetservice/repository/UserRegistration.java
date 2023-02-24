package com.example.tweetservice.repository;

import com.example.tweetservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistration extends MongoRepository<User, String> {
}
