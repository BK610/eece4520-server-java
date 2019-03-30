package edu.neu.eece4520.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String screenName;
    private Integer statusesCount;
    private Integer followersCount;
    private Integer friendsCount;
    private Integer favouritesCount;
    private String url;
    private String location;
    private boolean geoEnabled;
    private String profileImageUrl;
    private String profileBackgroundImageUrl;
    private String description;
    @NotNull
    private String createdAt;
    @NotNull
    private Date timestamp;
    @NotNull
    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Integer getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
