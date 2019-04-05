package edu.neu.eece4520.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class BotOrNotScore {
    @JsonIgnore
    User user;
    @JsonIgnore
    List<Tweet> tweets;
    Integer overallScore = 1;

    public BotOrNotScore calculate() {
        //TODO: Do the calculations
        // Including...
        // - Overall overallScore
        // - All parameters as determined by @Gwen
        // - ?

        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Integer getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
    }
}
