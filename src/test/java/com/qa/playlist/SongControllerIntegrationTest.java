package com.qa.playlist;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//Use Random Port to avoid collisions.
@AutoConfigureMockMvc
public class SongControllerIntegrationTest {
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper; //Wiring in the mapper that spring uses to convert to JSON.
	
	@Test
	void testCreate() throws Exception {
		Song testSong = new Song("Le Temps", "Fleur Floride", "Tayc");
		String songToJSON = this.mapper.writeValueAsString(testSong); 
		RequestBuilder req = post("/createSong").contentType(MediaType.APPLICATION_JSON).content(songToJSON);
		
		Song testIsSongCreated = new Song(1, "Le Temps", "Fleur Floride", "Tayc");
		ResultMatcher statusFlag = status().isCreated();
		ResultMatcher bodyCheck = content().json(songToJSON);
		
		this.mvc.perform(req).andExpect(statusFlag).andExpect(bodyCheck);
	}
	
}
