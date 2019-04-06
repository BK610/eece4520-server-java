package edu.neu.eece4520.services;

import edu.neu.eece4520.models.Tweet;
import edu.neu.eece4520.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/tweet/{tweetId}")
    public Tweet findTweetById(
            @PathVariable("tweetId") Long id) {
        return tweetRepository.findTweetById(id);
    }

    @PostMapping("/api/tweet")
    public Tweet createTweet(
            @RequestBody Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @PutMapping("api/tweet/{tweetId}")
    public Tweet updateTweet(
            @PathVariable("tweetId") Long id,
            @RequestBody Tweet tweetUpdates) {
        Tweet tweet = tweetRepository.findTweetById(id);
        //TODO: update all fields
        //tweet.setField(tweetUpdates.getField());
        return tweetRepository.save(tweet);
    }

    @DeleteMapping("/api/tweet/{tweetId}")
    public void deleteTweet(
            @PathVariable("tweetId") Integer id) {
        tweetRepository.deleteById(id);
    }

    @GetMapping("/api/tweet/user/{userId}")
    public List<Tweet> findTweetsByUser(
            @PathVariable("userId") Integer id) {
        return tweetRepository.findAllTweetsByUser(id);
    }
}
