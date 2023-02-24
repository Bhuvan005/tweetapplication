package com.example.tweetservice.service;

import com.example.tweetservice.model.User;
import com.example.tweetservice.model.UserTweet;
import com.example.tweetservice.repository.DataBaseConnection;
import com.example.tweetservice.repository.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserTweetService implements TweetService{


    @Autowired
    DataBaseConnection tweetDataBaseConnection;

    @Autowired
    UserRegistration userRegistration;

    @Override
    public List<UserTweet> AllTweets() {
        return tweetDataBaseConnection.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRegistration.save(user);
    }

    @Override
    public Boolean validate(User user) {
        Optional<User> optionalUser = userRegistration.findById(user.getUserId());
        if(optionalUser.isPresent()){
            if(optionalUser.get().getEmail().equals(user.getEmail()) && optionalUser.get().getPassword().equals(user.getPassword()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserTweet createTweet(UserTweet userTweet) {
        userTweet.setCreatedDate(new Date());
        return tweetDataBaseConnection.save(userTweet);
    }

    @Override
    public String deleteTweet(String tweetId, String userId) {
        Optional<UserTweet> optionalUserTweet = tweetDataBaseConnection.findById(tweetId);
        if(optionalUserTweet.isPresent()){
            Optional<User> optionalUser = userRegistration.findById(userId);
            if(optionalUser.isPresent()){
                tweetDataBaseConnection.delete(optionalUserTweet.get());
                return "Successfully deleted";
            }
        }
        return "Cannot delete";
    }


}
