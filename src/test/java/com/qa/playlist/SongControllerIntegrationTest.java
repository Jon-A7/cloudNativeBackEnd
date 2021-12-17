package com.qa.playlist;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//Use Random Port to avoid collisions.
@AutoConfigureMockMvc
public class SongControllerIntegrationTest {
	
	private MockMvc mvc;
	
}
