package edu.neu.eece4520.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tweets")
public class Tweet {
    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "text")
    private String text;
    @Column(name = "source")
    private String source;
    @NotNull
    @ManyToOne
    @JsonIgnore
    @Column(name = "user_id")
    private User user;
    @Column(name = "in_reply_to_status_id")
    private Integer inReplyToStatusId;
    @Column(name = "in_reply_to_user_id")
    private Integer inReplyToUserId;
    @Column(name = "in_reply_to_screen_name")
    private String inReplyToScreenName;
    @Column(name = "retweeted_status_id")
    private Integer retweetedStatusId;
    @Column(name = "reply_count")
    private Integer replyCount;
    @Column(name = "favorite_count")
    private Integer favoriteCount;
    @Column(name = "num_hashtags")
    private Integer numHashtags;
    @Column(name = "num_urls")
    private Integer numUrls;
    @Column(name = "num_mentions")
    private Integer numMentions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Integer inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public Integer getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Integer inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public Integer getRetweetedStatusId() {
        return retweetedStatusId;
    }

    public void setRetweetedStatusId(Integer retweetedStatusId) {
        this.retweetedStatusId = retweetedStatusId;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Integer getNumHashtags() {
        return numHashtags;
    }

    public void setNumHashtags(Integer numHashtags) {
        this.numHashtags = numHashtags;
    }

    public Integer getNumUrls() {
        return numUrls;
    }

    public void setNumUrls(Integer numUrls) {
        this.numUrls = numUrls;
    }

    public Integer getNumMentions() {
        return numMentions;
    }

    public void setNumMentions(Integer numMentions) {
        this.numMentions = numMentions;
    }
}