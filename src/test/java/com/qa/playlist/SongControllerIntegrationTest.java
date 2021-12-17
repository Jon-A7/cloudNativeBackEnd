package com.qa.playlist;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//Use Random Port to avoid collisions.
@AutoConfigureMockMvc

@Sql(scripts = { "classpath:playlist-schema.sql",
"classpath:playlist.data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

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
	
	@Test
	void testGetById() throws Exception{
		RequestBuilder req = get("/get/1");
		
		Song testGetSong = new Song(1, "Le Temps", "Fleur Floride", "Tayc");
		//String songToJSON = this.mapper.writeValueAsString(testGetSong);
		String songToJSON2 = this.mapper.writeValueAsString(new Song(1, "Le Temps", "Fleur Floride", "Tayc"));
		
		
		ResultMatcher statusFlag = status().isOk();
		ResultMatcher bodyCheck = content().json(songToJSON2);
		
		this.mvc.perform(req).andExpect(statusFlag).andExpect(bodyCheck);
	}
	
	@Test
	void testGetAll() throws Exception{
		RequestBuilder req = get("/getAll");
		
		List<Song> testGetSongs = List.of(new Song(1, "Le Temps", "Fleur Floride", "Tayc"),
				new Song(2, "Set Me Alight", "Sempre Verao", "Nelson Freitas"),
				new Song(3, "Essence", "Made In Lagos", "WizKid"));
		
		String listsToJSON = this.mapper.writeValueAsString(testGetSongs);
		
		ResultMatcher statusFlag = status().isOk();
		ResultMatcher bodyCheck = content().json(listsToJSON);
		
		this.mvc.perform(req).andExpect(statusFlag).andExpect(bodyCheck);
	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/deleteSong/1")).andExpect(status().isNoContent());
	}
	
	@Test
	void testReplace() throws Exception {
		Song testSong = new Song("Le Temps", "Fleur Floride", "Tayc");
		String testSongAsJSON = this.mapper.writeValueAsString(testSong);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testSongAsJSON);

		Song testCSong = new Song(1, "Le Temps", "Fleur Floride", "Tayc");
		String testCSongAsJSON = this.mapper.writeValueAsString(testCSong);
		ResultMatcher statusFlag = status().isAccepted();
		ResultMatcher bodyCheck = content().json(testCSongAsJSON);

		// sends request - checks the status - checks the body
		this.mvc.perform(req).andExpect(statusFlag).andExpect(bodyCheck);
	}
	
	
}
