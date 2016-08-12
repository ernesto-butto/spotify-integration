package com.catwizard.spotify.service;

/**
 * Created by poolebu on 8/10/16.
 */

public class Response {

     private final long id;
     private final String content;

     public Response(long id, String content) {
         this.id = id;
         this.content = content;
     }

     public long getId() {
         return id;
     }

     public String getContent() {
         return content;
     }
 }

