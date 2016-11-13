package com.catwizard.spotify;

import com.catwizard.spotify.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by poolebu on 8/17/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpotifyIntegrationApplication.class)
@WebAppConfiguration
public class SearchServiceTest {

    @Autowired
    SearchService searchService;



    @Test
    public void firstTest(){

    String result = searchService.authExample();


    }

}
