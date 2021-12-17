package com.qa.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
// A respository is an extension of an already existing class.
	//The purpose of a repo is to store and manage data.
	
	
}
