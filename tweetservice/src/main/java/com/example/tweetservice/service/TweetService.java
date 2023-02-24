package com.example.tweetservice.service;

import com.example.tweetservice.model.User;
import com.example.tweetservice.model.UserTweet;

import java.util.List;

public interface TweetService {
    List<UserTweet> AllTweets();
    User saveUser(User user);

    Boolean validate(User user);
    UserTweet createTweet(UserTweet userTweet);
    String deleteTweet(String tweetId,String userId);
}
