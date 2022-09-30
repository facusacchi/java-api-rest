package app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import app.domain.ListOfSongs;

@Component
public class RepositoryInMemory {
	
	private static Long id = 0L;
	private List<ListOfSongs> lists = new ArrayList<>();
	
	public List<ListOfSongs> getLists() {
		return this.lists;
	}
	
	public void addList(ListOfSongs list) {
		RepositoryInMemory.id++;
		list.setId(RepositoryInMemory.id);
		this.lists.add(list);
	}
	
	public void removeList(Long listId) {
		final List<ListOfSongs> filteredList = lists.stream()
												.filter(list -> list.getId() != listId)
												.collect(Collectors.toList()); 
		this.lists  = new ArrayList<>(filteredList);
	}
}
