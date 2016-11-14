package com.catwizard.spotify.domain;

/**
 * Created by poolebu on 11/14/16.
 */

public class SpotifyUser {
    // var toServer = {"accessToken":"", "display_name":"" , "id":"", "country":""};

    String accessToken;
    String display_name;
    String id;
    String country;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
