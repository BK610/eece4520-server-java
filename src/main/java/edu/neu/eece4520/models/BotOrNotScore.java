package edu.neu.eece4520.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class BotOrNotScore {
    @JsonIgnore
    private Double statusesCountCoef = -0.00002558;
    @JsonIgnore
    private Double friendsCountCoef = 0.0005;
    @JsonIgnore
    private Double favouritesCountCoef = -0.00002616;
    @JsonIgnore
    private Double locationIsEmptyCoef = 1.5694;
    @JsonIgnore
    private Double bioIsEmptyCoef = 3.6716;
    @JsonIgnore
    private Double countScreenNameNumbersCoef = 0.6040;
    @JsonIgnore
    private Double averageNumUrlsCoef = 1.0601;
    @JsonIgnore
    private Double averageNumBadSourceCoef = -0.7432;

    private Double overallScore = 0.0;
    private Double statusesCountScore = 0.0;
    private Double friendsCountScore = 0.0;
    private Double favouritesCountScore = 0.0;
    private Double locationScore = 0.0;
    private Double descriptionScore = 0.0;
    private Double screenNameNumbersScore = 0.0;
    private Double averageNumUrlsScore = 0.0;
    private Double averageNumBadSource = 0.0;

    private Integer numUrls = 0;
    private Integer numSources = 0;
    private Integer numTweets = 0;

    public BotOrNotScore calculate(User user, List<Tweet> tweets) {
        // Set number of URLS, Sources, and Tweets
        this.countUrlsSourcesTweets(tweets);

        // Set each individual score component
        this.setScores(user);

        // Set overall score
        this.setOverallScore(this.getStatusesCountScore()
                + this.getFriendsCountScore()
                + this.getFavouritesCountScore()
                + this.getLocationScore()
                + this.getDescriptionScore()
                + this.getScreenNameNumbersScore()
                + this.getAverageNumUrlsScore()
                + this.getAverageNumBadSource());

        return this;
    }

    private void countUrlsSourcesTweets(List<Tweet> tweets) {
        for (Tweet tweet: tweets) {
            this.setNumUrls(this.getNumUrls() + tweet.getNumUrls());
            if(tweet.getSource() == "web") {
                this.setNumSources(this.getNumSources() + 1);
            }
            this.setNumTweets(this.getNumTweets() + 1);
        }
    }

    private void setScores(User user) {
        this.setStatusesCountScore(user.getStatusesCount()
                * this.getStatusesCountCoef());
        this.setFriendsCountScore(user.getFriendsCount()
                * this.getFriendsCountCoef());
        this.setFavouritesCountScore(user.getFavouritesCount()
                * this.getFavouritesCountCoef());
        this.setLocationScore((
                (user.getLocation().equals(""))
                        ? 1
                        : 0)
                * this.getLocationIsEmptyCoef());
        this.setDescriptionScore((
                (user.getDescription().equals(""))
                        ? 1
                        : 0)
                * this.getBioIsEmptyCoef());
        this.setScreenNameNumbersScore(this.countDigitsInString(user.getScreenName())
                * this.getCountScreenNameNumbersCoef());
        this.setAverageNumUrlsScore((this.getNumUrls().doubleValue() / this.getNumTweets().doubleValue())
                * this.getAverageNumUrlsCoef());
        this.setAverageNumBadSource((this.getNumSources() / this.getNumTweets())
                * this.getAverageNumBadSourceCoef());
    }

    private Integer countDigitsInString(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    public Double getStatusesCountCoef() {
        return statusesCountCoef;
    }
    public Double getFriendsCountCoef() {
        return friendsCountCoef;
    }
    public Double getFavouritesCountCoef() {
        return favouritesCountCoef;
    }
    public Double getLocationIsEmptyCoef() {
        return locationIsEmptyCoef;
    }
    public Double getBioIsEmptyCoef() {
        return bioIsEmptyCoef;
    }
    public Double getCountScreenNameNumbersCoef() {
        return countScreenNameNumbersCoef;
    }
    public Double getAverageNumUrlsCoef() {
        return averageNumUrlsCoef;
    }
    public Double getAverageNumBadSourceCoef() {
        return averageNumBadSourceCoef;
    }
    public Double getOverallScore() {
        return overallScore;
    }
    public void setOverallScore(Double overallScore) {
        this.overallScore = overallScore;
    }
    public Double getStatusesCountScore() {
        return statusesCountScore;
    }
    public void setStatusesCountScore(Double statusesCountScore) {
        this.statusesCountScore = statusesCountScore;
    }
    public Double getFriendsCountScore() {
        return friendsCountScore;
    }
    public void setFriendsCountScore(Double friendsCountScore) {
        this.friendsCountScore = friendsCountScore;
    }
    public Double getFavouritesCountScore() {
        return favouritesCountScore;
    }
    public void setFavouritesCountScore(Double favouritesCountScore) {
        this.favouritesCountScore = favouritesCountScore;
    }
    public Double getLocationScore() {
        return locationScore;
    }
    public void setLocationScore(Double locationScore) {
        this.locationScore = locationScore;
    }
    public Double getDescriptionScore() {
        return descriptionScore;
    }
    public void setDescriptionScore(Double descriptionScore) {
        this.descriptionScore = descriptionScore;
    }
    public Double getScreenNameNumbersScore() {
        return screenNameNumbersScore;
    }
    public void setScreenNameNumbersScore(Double screenNameNumbersScore) {
        this.screenNameNumbersScore = screenNameNumbersScore;
    }
    public Integer getNumUrls() {
        return numUrls;
    }
    public void setNumUrls(Integer numUrls) {
        this.numUrls = numUrls;
    }
    public Integer getNumSources() {
        return numSources;
    }
    public void setNumSources(Integer numSources) {
        this.numSources = numSources;
    }
    public Integer getNumTweets() {
        return numTweets;
    }
    public void setNumTweets(Integer numTweets) {
        this.numTweets = numTweets;
    }
    public Double getAverageNumUrlsScore() {
        return averageNumUrlsScore;
    }
    public void setAverageNumUrlsScore(Double averageNumUrlsScore) {
        this.averageNumUrlsScore = averageNumUrlsScore;
    }
    public Double getAverageNumBadSource() {
        return averageNumBadSource;
    }
    public void setAverageNumBadSource(Double averageNumBadSource) {
        this.averageNumBadSource = averageNumBadSource;
    }
}
