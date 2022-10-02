package app.builder;

import java.util.List;

import app.domain.ListOfSongs;
import app.domain.Song;

public class ListOfSongsBuilder {

	private ListOfSongs listOfSongs;
	
	public ListOfSongsBuilder() {
		this.listOfSongs = new ListOfSongs();
	}
	
	public ListOfSongsBuilder withId(Long id) {
		this.listOfSongs.setId(id);
		return this;
	}
	
	public ListOfSongsBuilder withName(String name) {
		this.listOfSongs.setName(name);
		return this;
	}
	
	public ListOfSongsBuilder withSongs(List<Song> songs) {
		this.listOfSongs.setSongs(songs);
		return this;
	}
	
	public ListOfSongs build() {
		return this.listOfSongs;
	}
}
