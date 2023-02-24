package com.example.tweetservice.controller;

import com.example.tweetservice.model.User;
import com.example.tweetservice.model.UserTweet;
import com.example.tweetservice.service.TweetService;
import com.example.tweetservice.service.UserTweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class TweetController {
    @Autowired
    TweetService tweetService;

    @GetMapping(value = "/get-tweet")
    public List<UserTweet> getTweet(){
        return tweetService.AllTweets();
    }

    @PostMapping(value = "/register")
    public User userRegistration(@RequestBody User user){
        return tweetService.saveUser(user);
    }

    @PostMapping(value = "/validate")
    public Boolean validateUser(@RequestBody User user){
        return tweetService.validate(user);
    }

    @PostMapping(value = "/create-tweet")
    public UserTweet createTweet(@RequestBody UserTweet userTweet) {
        return tweetService.createTweet(userTweet);
    }

    @DeleteMapping(value = "/tweet/delete")
    public String delete(@RequestHeader("tweetId") String tweetId, @RequestHeader("userId") String userId)
    {
        return tweetService.deleteTweet(tweetId, userId);
    }
}
