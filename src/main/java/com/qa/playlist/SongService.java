package com.qa.playlist;

import java.util.List;

public interface SongService {
	
	Song createSong(Song song);
	
	Song getSong(Integer id);
	
	List<Song> getAllSongs();
	
	
	void deleteSong(Integer id);
	
	
	Song replaceSong(Integer id, Song newSong);
	
}
