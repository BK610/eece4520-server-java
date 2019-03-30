package edu.neu.eece4520.repositories;

import edu.neu.eece4520.models.Tweet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TweetRepository extends CrudRepository<Tweet, Integer> {
    @Query(value="SELECT tweet FROM Tweet tweet")
    public List<Tweet> findAllTweets();
    @Query(value="SELECT tweet FROM Tweet tweet WHERE tweet.id=:id")
    public Tweet findTweetById(@Param("id") Integer id);
    @Query(value="SELECT tweet FROM Tweet tweet WHERE tweet.user=:userId")
    public Tweet findAllTweetsByUser(@Param("userId") Integer userId);
}
