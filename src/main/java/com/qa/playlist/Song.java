package com.qa.playlist;

public class Song {
	private Integer id;
	private String songTitle;
	private String albumName;
	private String artistName;
	
	public Song() {
		super();
		
	}
	
	public Song(String songTitle, String albumName, String artistName) {
		super();
		this.songTitle = songTitle;
		this.albumName = albumName;
		this.artistName = artistName;
	}
	
	public Song(Integer id, String songTitle, String albumName, String artistName) {
		super();
		this.id = id;
		this.songTitle = songTitle;
		this.albumName = albumName;
		this.artistName = artistName;
	}
	
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "Song [songTitle=" + songTitle + ", albumName=" + albumName + ", artistName=" + artistName + "]";
	}
	
	
	
	
}
