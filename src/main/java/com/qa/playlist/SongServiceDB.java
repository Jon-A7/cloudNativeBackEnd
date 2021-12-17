package com.qa.playlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceDB implements SongService {
	
	private SongRepo repo; //All CRUD functionality here is done directly into a database, not the list.
	
	
@Autowired //Injects SongRepo into SongServiceDB
	public SongServiceDB(SongRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Song createSong(Song song) {
		Song created =this.repo.save(song);
		return created;
	}

	@Override
	public Song getSong(Integer id) {
		// WHERE ID=
		return this.repo.getById(id);
	}

	@Override
	public List<Song> getAllSongs() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public void deleteSong(Integer id) {
		this.repo.deleteById(id); // These functions are taken from the CRUDrepositories within the JPARepository.
		
	}

	@Override
	public Song replaceSong(Integer id, Song newSong) {
		// TODO Auto-generated method stub
		Song currentSong = this.repo.getById(id);
		
		currentSong.setSongTitle(newSong.getSongTitle());
		currentSong.setArtistName(newSong.getArtistName());
		currentSong.setAlbumName(newSong.getAlbumName());
		
		Song updated = this.repo.save(currentSong);
		
		return updated;
	}

}
