package app.builder;

import app.domain.Song;

public class SongBuilder {
	
	private Song song;
	
	public SongBuilder() {
		this.song = new Song();
	}
	
	public SongBuilder withId(Long id) {
		this.song.setId(id);
		return this;
	}
	
	public SongBuilder withName(String name) {
		this.song.setName(name);
		return this;
	}
	
	public SongBuilder withTitle(String title) {
		this.song.setTitle(title);
		return this;
	}
	
	public SongBuilder withArtist(String artist) {
		this.song.setArtist(artist);
		return this;
	}
	
	public SongBuilder withAlbum(String album) {
		this.song.setAlbum(album);
		return this;
	}
	
	public Song build() {
		return this.song;
	}
	
}
