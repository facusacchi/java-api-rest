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
	
//	@Autowired
//	private RepositoryInMemory repositoryInMemory;
	
	private JsonMockServiceAdapter jsonMockServiceAdapter;
	
	@Autowired
	public ListOfSongsService(JsonMockServiceAdapter jsonMockServiceAdapter) {
		this.jsonMockServiceAdapter = jsonMockServiceAdapter; 
	}

	public List<ListOfSongs> getLists() {
		return this.jsonMockServiceAdapter.getLists();
	}
	
	public void addList(ListOfSongs list) {
	}
	
	public void removeList(Long listId) {
	}
}
