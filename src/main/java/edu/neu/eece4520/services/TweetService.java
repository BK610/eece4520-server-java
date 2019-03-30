package edu.neu.eece4520.services;

import edu.neu.eece4520.models.Tweet;
import edu.neu.eece4520.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TweetService {
    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/api/tweet")
    List<Tweet> findAllTweets() {
        return tweetRepository.findAllTweets();
    }
}
