package com.catwizard.spotify.controller;

import com.catwizard.spotify.domain.SpotifyUser;
import com.catwizard.spotify.service.SearchService;
import com.wrapper.spotify.methods.UserPlaylistsRequest;
import com.wrapper.spotify.models.SimplePlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by poolebu on 11/13/16.
 */
@Controller
public class FrontController {

    @Autowired
    SearchService searchService;

    @RequestMapping("/greeting")
       public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
           model.addAttribute("name", name);
           return "greeting";
       }

    @RequestMapping(value = "userinfo",consumes="application/json")
    public String userinfo(@RequestBody SpotifyUser spotifyUser){

		List<SimplePlaylist> playlists =	searchService.searchPlalistOfUser(spotifyUser.getId());

        return "main-app-template-name";
    }

    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

    		PrintWriter out = res.getWriter();
    		res.setContentType("text/plain");

    		Enumeration<String> parameterNames = req.getParameterNames();

    		while (parameterNames.hasMoreElements()) {

    			String paramName = parameterNames.nextElement();
    			out.write(paramName);
    			out.write("n");

    			String[] paramValues = req.getParameterValues(paramName);
    			for (int i = 0; i < paramValues.length; i++) {
    				String paramValue = paramValues[i];
    				out.write("t" + paramValue);
    				out.write("n");
    			}

    		}

    		out.close();

    	}
}
