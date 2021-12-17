package com.qa.playlist;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class SongServiceList implements SongService {
	private List<Song> songs = new ArrayList<>();
	
	
	@Override
	public Song createSong(Song song) {
		this.songs.add(song);
		Song created = this.songs.get(this.songs.size() - 1);
		return created;
	}

	@Override
	public Song getSong(Integer id) {
		// TODO Auto-generated method stub
		return this.songs.get(id);
	}

	@Override
	public List<Song> getAllSongs() {
		// TODO Auto-generated method stub
		return this.songs;
	}

	@Override
	public void deleteSong(Integer id) {
		// TODO Auto-generated method stub
		this.songs.remove(id.intValue());
	}

	@Override
	public Song replaceSong(Integer id, Song newSong) {
		// TODO Auto-generated method stub
		Song found = this.songs.set(id, newSong);
		
		return found;
	}
	

}
