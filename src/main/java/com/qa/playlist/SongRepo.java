package com.qa.playlist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
// A respository is an extension of an already existing class.
	//The purpose of a repo is to store and manage data.
	
//	List<Song> findByArtist(String artistName);
//	List<Song> findByAlbum(String albumName);
	
//	List<Song> getAllByArtist(String artistName);
}
