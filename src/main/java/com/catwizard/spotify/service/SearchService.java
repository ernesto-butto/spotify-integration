package com.catwizard.spotify.service;

import com.catwizard.spotify.domain.SpotifyUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.methods.PlaylistRequest;
import com.wrapper.spotify.methods.TrackRequest;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.models.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by poolebu on 8/10/16.
 */
@Service
public class SearchService {

    // Create an API instance. The default instance connects to https://api.spotify.com/.
    //Api defaultApi = Api.DEFAULT_API;



    /* Application details necessary to get an access token */
    final String clientId = "9b51944ea2f84876acef2373701057fa";
    final String clientSecret = "82a1463bfbee4d438d5637fbce169faa";
    final String code = "code";
    final String redirectUri = "http://localhost:8080";

    Api defaultApi = Api.builder()
            .clientId(clientId)
            .clientSecret(clientSecret)
            .redirectURI(redirectUri)
            .build();




    /* Create a default API instance that will be used to make requests to Spotify */


    // final SettableFuture<AuthorizationCodeCredentials> authorizationCodeCredentialsFuture = api.authorizationCodeGrant(code).build().getAsync();


    public String authExample(){

        Api api = Api.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectURI(redirectUri)
                .build();
        try {

             /* Retrieve an access token */
            final AuthorizationCodeCredentials authorizationCodeCredentials = api.authorizationCodeGrant(code).build().get();

             /* The token response contains a refresh token, an accesstoken, and some other things.
              * We only need the access token to retrieve the user's information.
              */
            final String accessToken = authorizationCodeCredentials.getAccessToken();

             /* Retrieve information about the user.
             * The amount of information that is set on the User object depends on the scopes that
             * the user has allowed the application to read.
             * Read about which scopes that are available on
             * https://developer.spotify.com/spotify-web-api/get-users-profile/
             */
            final User currentUser = api.getMe().accessToken(accessToken).build().get();

             /* Use the information about the user */
            System.out.println("URI to currently logged in user is: " + currentUser.getUri());
            System.out.println("The currently logged in user comes from: " + currentUser.getCountry());
            System.out.println("You can reach this user at: " + currentUser.getEmail());

        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }



        return null;

    }

    public Album searchAblumById(String albumNameRequest){

        String result ="";

        // Create a request object for the type of request you want to make
        AlbumRequest request = defaultApi.getAlbum(albumNameRequest).build();

        Album album = null;
        // Retrieve an album
        try {
            album = request.get();

        } catch (Exception e) {
            result = e.getMessage();
        }


        return  album ;

    }

    public Track searchTrackById(String trackId) {

        String result ="";

        TrackRequest  request = defaultApi.getTrack(trackId).build();

        Track track = null;

        try{

            track = request.get();


        }catch (Exception e) {
            result = e.getMessage();
        }


        return track;
    }

    public String getAudioFeatures(){

        return null;

    }


    public String searchTrackByName(String trackName){

        // api.searchTracks();

        return null;

    }

    public String searchTopTracksByArtist(String artistName){

        // api.getTopTracksForArtist()

        return null;

    }

    public String searchAudioById(String trackId) {

        // todo-ernesto seguir aqui

        return null;
    }

    public List<SimplePlaylist> searchPlalistOfUser(SpotifyUser spotifyUser){

        UserPlaylistsRequest userPlaylistsRequest = defaultApi.getPlaylistsForUser(spotifyUser.getId()).accessToken(spotifyUser.getAccessToken()).build();

        List<SimplePlaylist> simplePlaylists =new ArrayList<SimplePlaylist>();

        try {
            final Page<SimplePlaylist> playlistsPage = userPlaylistsRequest.get();

            System.out.println("Adding playlists to playlist list");

            for (SimplePlaylist playlist : playlistsPage.getItems()) {

                System.out.println(playlist.getName());

                simplePlaylists.add(playlist);

              }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WebApiException e) {
            e.printStackTrace();
        }

        System.out.println("Added "+ simplePlaylists.size()+" playlists");
        return simplePlaylists;
    }

    public String searchPlaylistSongs(String userId, String playlistId){

        PlaylistRequest playlistRequest = defaultApi.getPlaylist(userId,playlistId).build();



        Playlist playlist = null;

        try{
            playlist = playlistRequest.get();

        }catch (Exception e){
            int a=1;
        }

        return null;

    }


    public Map<String, Object> getAudioObject(String apikey, String password, String shopName){

        apikey="https://api.spotify.com/v1/audio-features";

        String trackId="1vpwWCCXYYMAaRMTfsnDpk";

        String url = "https://api.spotify.com/v1/audio-features/"+trackId;

        //String url = "https://"+apikey+":"+password+"@"+shopName+".myshopify.com/admin/products.json";

        return sendGetRequest(url);

    }


    private Map<String, Object> sendGetRequest(String url) {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        Map<String, Object> jsonResponse = null;

        ObjectMapper mapper = new ObjectMapper();


        try {

            HttpGet request = new HttpGet(url);

            request.addHeader("content-type", "application/json");

            HttpResponse result = httpClient.execute(request);

            String resultString = EntityUtils.toString(result.getEntity(), "UTF-8");

            jsonResponse = mapper.readValue(resultString,Map.class);

            return jsonResponse;

        } catch (IOException ex) {

            System.out.print(ex.getMessage());

        }

        return jsonResponse;
    }



}
