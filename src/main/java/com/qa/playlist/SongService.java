package com.qa.playlist;

import java.util.List;

public interface SongService {
	
	Song createSong(Song song);
	
	Song getSong(Integer id);
	
	List<Song> getAllSongs();
	
	List<Song> getSongByArtist(String artistName);
	
	void deleteSong(Integer id);
	
	
	Song replaceSong(Integer id, Song newSong);
	
}
