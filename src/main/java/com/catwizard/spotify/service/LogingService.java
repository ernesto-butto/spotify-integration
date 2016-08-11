package com.catwizard.spotify.service;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.models.Album;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by poolebu on 8/10/16.
 */
@Service
public class LogingService {

    public String searchById(String albumNameRequest){

        String result ="";

      // Create an API instance. The default instance connects to https://api.spotify.com/.
      Api api = Api.DEFAULT_API;

      // Create a request object for the type of request you want to make
      AlbumRequest request = api.getAlbum(albumNameRequest).build();

      // Retrieve an album
      try {
        Album album = request.get();

          result=" \n";
          result+= album.getName()+"\n";


        // Print the genres of the album
        List<String> genres = album.getGenres();
        for (String genre : genres) {
            result+=genre;
        };

      } catch (Exception e) {
        result = e.getMessage();
      }


        return  result ;

    }

}
