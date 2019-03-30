package edu.neu.eece4520.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name="user")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @NotNull
    @Column(name="name")
    private String name;
    @NotNull
    @Column(name="screen_name")
    private String screenName;
    @Column(name="statuses_count")
    private Integer statusesCount;
    @Column(name="followers_count")
    private Integer followersCount;
    @Column(name="friends_count")
    private Integer friendsCount;
    @Column(name="favourites_count")
    private Integer favouritesCount;
    @Column(name="url")
    private String url;
    @Column(name="location")
    private String location;
    @Column(name="geo_enabled")
    private boolean geoEnabled;
    @Column(name="profile_image_url")
    private String profileImageUrl;
    @Column(name="profile_background_image_url")
    private String profileBackgroundImageUrl;
    @Column(name="description")
    private String description;
//    @NotNull
//    @Column(name="timestamp")
//    private Date timestamp;
//    @NotNull
//    @Column(name="updated")
//    private Date updated;

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

//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public Date getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(Date updated) {
//        this.updated = updated;
//    }
}
