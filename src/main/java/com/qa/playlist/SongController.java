package com.qa.playlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
	private SongService service;
	
	@Autowired
	public SongController(SongService service) {
		super();
		this.service = service;
	}

		@PostMapping("/createSong")
		public ResponseEntity<Song> createSong(@RequestBody Song song) {
			Song created = this.service.createSong(song);
			ResponseEntity<Song> response = new ResponseEntity<Song>(created,HttpStatus.CREATED);
			return response;
		}
		
		@GetMapping("/get/{id}")
		public Song getSong(@PathVariable Integer id) {
			
			return this.service.getSong(id);
		}
		
		@GetMapping("/getAll")
		public ResponseEntity<List<Song>> getAllSongs(){
			return ResponseEntity.ok(this.service.getAllSongs());
			
		}
		
		@GetMapping("/getByArtist/{artistName}")
		public ResponseEntity<List<Song>> getSongByType(@PathVariable String artistName){
			List<Song> foundSong = this.service.getSongByArtist(artistName);
			return ResponseEntity.ok(foundSong);
		}
		
		@DeleteMapping("/deleteSong/{id}")
		public ResponseEntity<?> deleteSong(@PathVariable Integer id) {
			this.service.deleteSong(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
		@PutMapping("/replace/{id}")
		public ResponseEntity<Song> replaceSong(@PathVariable Integer id, @RequestBody Song newSong) {
			Song main = this.service.replaceSong(id, newSong);
			ResponseEntity<Song> response = new ResponseEntity<Song>(main, HttpStatus.ACCEPTED);
			
			return response;
		}
}
