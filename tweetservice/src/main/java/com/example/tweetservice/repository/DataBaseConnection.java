package com.example.tweetservice.repository;

import com.example.tweetservice.model.UserTweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseConnection extends MongoRepository<UserTweet,String> {

}
