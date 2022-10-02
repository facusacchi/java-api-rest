package app.domain;

public class Song implements Entity {
	
	private Long id;
	private String name;
	private String title;
	private String artist;
	private String album;
	
	public boolean isValid() {
		return !name.isEmpty()
				&& !title.isEmpty()
				&& !artist.isEmpty()
				&& !album.isEmpty();
	}
	
	public boolean hasValueInName(String value) {
		return name.toLowerCase()
				.contains(value.trim().toLowerCase());
	}
	
	//getters and setters
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void assignId() {
		// TODO Auto-generated method stub
		
	}
}
