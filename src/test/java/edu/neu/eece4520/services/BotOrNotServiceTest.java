package edu.neu.eece4520.services;

import edu.neu.eece4520.models.BotOrNotScore;
import edu.neu.eece4520.models.Tweet;
import edu.neu.eece4520.models.User;
import edu.neu.eece4520.repositories.TweetRepository;
import edu.neu.eece4520.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
    private UserRepository userRepository;

    @MockBean
    private TweetRepository tweetRepository;

    @Before
    public void setUp() {
        alice = new User();
        alice.setName("Alice");
        alice.setLocation("earth");
        alice.setDescription("nice fun account");
        alice.setScreenName("Alice123456");
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
        tweet2.setNumUrls(0);
        tweet2.setSource("web");
        tweet2.setText("Tweet tweet tweeeeet");

        tweet3 = new Tweet();
        tweet3.setId(3L);
        tweet3.setNumUrls(2);
        tweet3.setSource("tweetdeck");
        tweet3.setText("Tweet tweet twitter tweet");

        tweet4 = new Tweet();
        tweet4.setId(4L);
        tweet4.setNumUrls(0);
        tweet4.setSource("web");
        tweet4.setText("Tweet tweety tweet");

        List<Tweet> allTweets = Arrays.asList(tweet1, tweet2, tweet3);

        alice.setTweets(allTweets);

        for (Tweet tweet :
                alice.getTweets()) {
            System.out.println("id: " + tweet.getId());
            System.out.println(tweet.getNumUrls());
        }

        botOrNotScore = new BotOrNotScore();
    }

    @Test
    public void test() {
        BotOrNotScore calculatedScore = botOrNotScore.calculate(alice, alice.getTweets());

        DecimalFormat df = new DecimalFormat("0.00");

        assertEquals("4.69", df.format(calculatedScore.getOverallScore()));
    }
}
