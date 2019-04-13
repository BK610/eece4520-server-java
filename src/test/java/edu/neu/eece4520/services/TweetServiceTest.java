package edu.neu.eece4520.services;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class TweetServiceTest {
    private User alice;
    private Tweet tweet1;
    private Tweet tweet2;
    private Tweet tweet3;
    private Tweet tweet4;

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

        tweet1 = new Tweet();
        tweet1.setId(1L);

        tweet2 = new Tweet();
        tweet2.setId(2L);

        tweet3 = new Tweet();
        tweet3.setId(3L);

        tweet4 = new Tweet();
        tweet4.setId(4L);

        List<Tweet> allTweets = Arrays.asList(tweet1, tweet2, tweet3);

        alice.setTweets(allTweets);

        Mockito.when(tweetRepository.findTweetById(tweet1.getId())).thenReturn(tweet1);
        Mockito.when(tweetRepository.findAllTweets()).thenReturn(allTweets);
        Mockito.when(tweetRepository.save(tweet4)).thenReturn(tweet4);
        Mockito.when(tweetRepository.save(tweet1)).thenReturn(tweet1);
        Mockito.when(tweetRepository.findAllTweetsByUser(alice.getId())).thenReturn(allTweets);
    }

    @Test
    public void testFindTweetById() {
        Tweet found = tweetService.findTweetById(tweet1.getId());

        assertEquals(found.getId(), tweet1.getId());
    }

    @Test
    public void testFindAllTweets() {
        List<Tweet> foundTweets = tweetService.findAllTweets();
        assertEquals(foundTweets.size(), 3);
        assertTrue("Contains L1", foundTweets.contains(tweet1));
        assertTrue("Contains L2", foundTweets.contains(tweet2));
        assertTrue("Contains L3", foundTweets.contains(tweet3));
    }

    @Test
    public void testCreateTweet() {
        Tweet created = tweetService.createTweet(tweet4);

        assertEquals(created.getId(), tweet4.getId());
    }

    @Test
    public void testFindTweetsByUser() {
        List<Tweet> foundTweets = tweetService.findTweetsByUser(alice.getId());

        assertEquals(foundTweets.size(), 3);
        assertTrue("Contains L1", foundTweets.contains(tweet1));
        assertTrue("Contains L2", foundTweets.contains(tweet2));
        assertTrue("Contains L3", foundTweets.contains(tweet3));
    }
}
