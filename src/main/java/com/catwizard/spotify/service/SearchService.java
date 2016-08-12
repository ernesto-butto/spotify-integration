package com.catwizard.spotify.service;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.methods.TrackRequest;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Track;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by poolebu on 8/10/16.
 */
@Service
public class SearchService {

    // Create an API instance. The default instance connects to https://api.spotify.com/.
    Api api = Api.DEFAULT_API;

    public Album searchAblumById(String albumNameRequest){

        String result ="";

        // Create a request object for the type of request you want to make
        AlbumRequest request = api.getAlbum(albumNameRequest).build();

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

        TrackRequest  request = api.getTrack(trackId).build();

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





}
