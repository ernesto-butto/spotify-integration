package com.catwizard.spotify;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by poolebu on 8/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpotifyIntegrationApplication.class)
@WebAppConfiguration
public class SearchControllerTests {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;


	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	@Ignore
	public void searchAlbumByIdTest() throws Exception {

		this.mockMvc.perform(get("/search/album").param("albumId", "7e0ij2fpWaxOEHv5fUYZjd"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("House of Deer"));


	}

	@Test
	@Ignore
	public void searchTrackByIdTest() throws Exception {

		this.mockMvc.perform(get("/search/track").param("trackId", "1vpwWCCXYYMAaRMTfsnDpk"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("If I Have My Way"));


	}

	@Test
	public void searchUserPlaylist() throws Exception{


		this.mockMvc.perform(get("/search/userPlaylist").
				param("userId","22gpp7ti6ntk63rxegrxfydya")
		.param("playlistId","4iIp1nnBtNDXdGIH2HQiLJ"))
		.andDo(print())
		.andExpect(status().isOk());
	}

	@Test
	@Ignore
	public void searchAudioObjectTest() throws Exception{

		this.mockMvc.perform(get("/search/audio").param("trackId", "1vpwWCCXYYMAaRMTfsnDpk")) ;

	}



}
