package app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapter.JsonMockServiceAdapter;
import app.domain.ListOfSongs;
import app.domain.Song;
import app.exception.NotFoundException;

/*
 * En una aplicación real, la mayoría de la lógica de este servicio estaría delegada en un motor de 
 * base de datos con los scripts correspondientes, dado que no sería performante traer todos los
 * datos en memoria ya que nuestra java virtual machine de nuestro server podría colapsar o por lo 
 * menos hacer muy poco performante nuestro sistema. 
 * Por lo que este servicio, en una aplicación real únicamente encapsularía lógica de negocio 
 */
@Service
public class ListOfSongsService {
	
	/*
	 * Normalmente estos ids son asignados en la capa de persistencia por JPA
	 */
	private final String NOT_FOUND_MESSAGE = "No se encontro recurso con id ";
	private static Long nextListId = 999L;
	private static Long nextSongId = 99L;
	
	private JsonMockServiceAdapter jsonMockServiceAdapter;
	
	@Autowired
	public ListOfSongsService(JsonMockServiceAdapter jsonMockServiceAdapter) {
		this.jsonMockServiceAdapter = jsonMockServiceAdapter; 
	}

	public List<ListOfSongs> getLists() {
		return this.jsonMockServiceAdapter.getLists();
	}
	
	public void addList(ListOfSongs list) {
		list.setId(getNextListId());
		list.assignIdsToSongs();
		List<ListOfSongs> newLists = this.getLists();
		newLists.add(list);
		jsonMockServiceAdapter.setLists(newLists);
	}
	
	private static Long getNextListId() {
		return nextListId++;
	}
	
	public static Long getNextSongId() {
		return nextSongId++;
	}
	
	public void removeList(Long listId) {
		List<ListOfSongs> newLists = this.getLists()
											.stream()
											.filter(list -> list.getId() != listId)
											.collect(Collectors.toList());
		
		jsonMockServiceAdapter.setLists(newLists);
	}

	public List<ListOfSongs> getListsBySongId(Long songId) {
		List<ListOfSongs> lists = this.getLists()
					.stream()
					.filter(list -> list.hasSongById(songId))
					.collect(Collectors.toList());
		
		if(lists.isEmpty()) throw new NotFoundException(NOT_FOUND_MESSAGE + songId);
		
		return lists;
	}

	public List<ListOfSongs> getListsBySongNameValue(String value) {
		return this.getLists()
				.stream()
				.filter(list -> list.hasSongWithValueInName(value))
				.collect(Collectors.toList());
	}

	public void addSongToList(Long listId, Song song) {
		song.setId(getNextSongId());
		ListOfSongs listToModified = findListById(listId);
		
		listToModified.addSong(song);
		this.updateListsOfSongs(listId, listToModified);
	}

	public void removeSongOfList(Long listId, Long songId) {
		ListOfSongs listOfSongs = findListById(listId);
		
		listOfSongs.removeSongById(songId);
		this.updateListsOfSongs(listId, listOfSongs);
	}
	
	public ListOfSongs findListById(Long listId) {
		ListOfSongs listOfSongs = this.getLists()
				.stream()
				.filter(list -> listId.equals(list.getId()))
				.findFirst()
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE + listId));
		
		if(listOfSongs == null) throw new NotFoundException(NOT_FOUND_MESSAGE + listId);
		
		return listOfSongs;
	}
	
	private void updateListsOfSongs(Long listToModifiedId, ListOfSongs newList) {
		this.removeList(listToModifiedId);
		newList.setId(listToModifiedId);
		List<ListOfSongs> lists = this.getLists();
		lists.add(newList);
		jsonMockServiceAdapter.setLists(lists);
	}
	
	
}
