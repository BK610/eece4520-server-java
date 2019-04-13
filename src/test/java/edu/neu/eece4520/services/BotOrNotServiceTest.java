package edu.neu.eece4520.services;

import edu.neu.eece4520.models.BotOrNotScore;
import edu.neu.eece4520.models.Tweet;
import edu.neu.eece4520.models.User;
import edu.neu.eece4520.repositories.TweetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class BotOrNotServiceTest {
    private User alice;
    private Tweet tweet1;
    private Tweet tweet2;
    private Tweet tweet3;
    private Tweet tweet4;
    private BotOrNotScore botOrNotScore;

    @TestConfiguration
    static class TweetServiceTestContextConfiguration {

        @Bean
        public TweetService TweetService() {
            return new TweetService();
        }
    }

    @Autowired
    private TweetService tweetService;

    @MockBean
    private TweetRepository tweetRepository;

    @Before
    public void setUp() {
        alice = new User();
        alice.setName("Alice");
        alice.setDescription("");
        alice.setFavouritesCount(123);
        alice.setFollowersCount(3);
        alice.setFriendsCount(23);
        alice.setStatusesCount(33);

        tweet1 = new Tweet();
        tweet1.setId(1L);
        tweet1.setNumUrls(1);
        tweet1.setSource("web");
        tweet1.setText("Tweet tweet");

        tweet2 = new Tweet();
        tweet2.setId(2L);
        tweet1.setNumUrls(0);
        tweet1.setSource("web");
        tweet1.setText("Tweet tweet tweeeeet");

        tweet3 = new Tweet();
        tweet3.setId(3L);
        tweet1.setNumUrls(0);
        tweet1.setSource("tweetdeck");
        tweet1.setText("Tweet tweet twitter tweet");

        tweet4 = new Tweet();
        tweet4.setId(4L);

        List<Tweet> allTweets = Arrays.asList(tweet1, tweet2, tweet3);

        alice.setTweets(allTweets);

        botOrNotScore = new BotOrNotScore();

        Mockito.when(tweetRepository.findTweetById(tweet1.getId())).thenReturn(tweet1);
        Mockito.when(tweetRepository.findAllTweets()).thenReturn(allTweets);
        Mockito.when(tweetRepository.save(tweet4)).thenReturn(tweet4);
        Mockito.when(tweetRepository.save(tweet1)).thenReturn(tweet1);
        Mockito.when(tweetRepository.findAllTweetsByUser(alice.getId())).thenReturn(allTweets);
    }

    @Test
    public void test() {
        BotOrNotScore calculatedScore = botOrNotScore.calculate(alice, alice.getTweets());

        System.out.println(calculatedScore.getOverallScore());
    }
}
