package app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.ListOfSongs;
import app.domain.Song;
import app.repository.RepositoryInMemory;

@Service
public class ListOfSongsService {
	
	@Autowired
	private RepositoryInMemory repositoryInMemory;

	public List<ListOfSongs> getLists() {
		return this.repositoryInMemory.getLists();
		
//		Song song1 = new Song("song1", "title1", "artist1", "album1");
//		Song song2 = new Song("song2", "title2", "artist2", "album2");
//		Song song3 = new Song("song3", "title3", "artist3", "album3");
//		Song song4 = new Song("song4", "title4", "artist4", "album4");
//		Song song5 = new Song("song5", "title5", "artist5", "album5");
//		
//		return new ListOfSongs("list1", Arrays.asList(song1, song2, song3, song4, song5));
	}
	
	public void addList(ListOfSongs list) {
		this.repositoryInMemory.addList(list);
	}
	
	public void removeList(Long listId) {
		this.repositoryInMemory.removeList(listId);
	}
}
