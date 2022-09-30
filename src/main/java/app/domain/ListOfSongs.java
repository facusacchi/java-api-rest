package app.domain;

import java.util.ArrayList;
import java.util.List;

//import lombok.experimental.Accessors;

//@Accessors
public class ListOfSongs {
	
	private Long id;
	private String name;
	private List<Song> canciones = new ArrayList<>();
	
	public ListOfSongs(String name, List<Song> canciones) {
		super();
		this.name = name;
		this.canciones = canciones;
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
	public List<Song> getCanciones() {
		return canciones;
	}
	public void setCanciones(List<Song> canciones) {
		this.canciones = canciones;
	}
}
