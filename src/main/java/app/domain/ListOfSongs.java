package app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import lombok.experimental.Accessors;

//@Accessors
public class ListOfSongs {
	
	private Long id;
	private String name;
	private List<Song> songs = new ArrayList<>();
	
	public ListOfSongs(String name, List<Song> songs) {
		super();
		this.name = name;
		this.songs = songs;
	}
	
	public boolean hasSongById(Long id) {
		return this.songs.stream().anyMatch(song -> song.getId() == id);
	}
	
	public boolean hasSongWithValueInName(String value) {
		return this.songs.stream().anyMatch(song -> song.hasValueInName(value));
	}
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public void removeSongById(Long songId) {
		this.songs = this.songs
						.stream()
						.filter(song -> song.getId() != songId)
						.collect(Collectors.toList());
	}
	
	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
