package edu.neu.eece4520.services;

import edu.neu.eece4520.models.BotOrNotScore;
import edu.neu.eece4520.models.Tweet;
import edu.neu.eece4520.models.User;
import edu.neu.eece4520.repositories.TweetRepository;
import edu.neu.eece4520.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BotOrNotScoreService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/api/botornot")
    public BotOrNotScore testGet() {
        return new BotOrNotScore();
    }

    @GetMapping("/api/botornot/{userId}")
    public BotOrNotScore calculateBotOrNotScoreByUser(
            @PathVariable("userId") Integer id) {
        User user = userRepository.findUserById(id);
        List<Tweet> tweets = tweetRepository.findAllTweetsByUser(id);
        BotOrNotScore botOrNotScore = new BotOrNotScore();

        return botOrNotScore.calculate(user, tweets);
    }
}
