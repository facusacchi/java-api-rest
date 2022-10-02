package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.ListOfSongs;
import app.domain.Song;
import app.service.ListOfSongsService;

import app.builder.ValidatorBuilder;

@RestController
@RequestMapping("/api/v1/listOfSongs")
public class ListOfSongsController {
	
	private final String CREATE_SUCCESS_MESSAGE = "Lista de canciones creada correctamente.";
	private final String DELETE_SUCCESS_MESSAGE = "Lista de canciones eliminada correctamente.";
	private final String UPDATE_SUCCESS_MESSAGE = "Lista de canciones actualizada correctamente.";
	
	@Autowired
	private ListOfSongsService listOfSongsService;
	
	@GetMapping("/lists")
	public ResponseEntity<List<ListOfSongs>> getListsOfSongs() {
		
		List<ListOfSongs> listOfSongs = listOfSongsService.getLists();
		
		return new ResponseEntity<>(listOfSongs, HttpStatus.OK);
	}
	
	@GetMapping("/lists/song/{id}")
	public ResponseEntity<List<ListOfSongs>> getListsOfSongs(@PathVariable Long id) {
		
		new ValidatorBuilder()
				.withLongPathVariableValidator(id)
				.build()
				.validate();
		
		List<ListOfSongs> listOfSongs = listOfSongsService.getListsBySongId(id);
		
		return new ResponseEntity<>(listOfSongs, HttpStatus.OK);
	}
	
	@GetMapping("/lists/song/name/{value}")
	public ResponseEntity<List<ListOfSongs>> getListsOfSongs(@PathVariable String value) {
		
		new ValidatorBuilder()
				.withStringPathVariableValidator(value)
				.build()
				.validate();
		
		List<ListOfSongs> listOfSongs = listOfSongsService.getListsBySongNameValue(value);
		
		return new ResponseEntity<>(listOfSongs, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/list/{listId}/add/song")
	public ResponseEntity<String> addSong(@PathVariable Long listId, @RequestBody Song body) {
		
		new ValidatorBuilder()
				.withLongPathVariableValidator(listId)
				.withEntityValidator(body)
				.build()
				.validate();
	
		this.listOfSongsService.addSongToList(listId, body);
		
		return new ResponseEntity<>(UPDATE_SUCCESS_MESSAGE, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/list/{listId}/remove/song/{songId}")
	public ResponseEntity<String> removeSong(@PathVariable Long listId, @PathVariable Long songId) {
	
		new ValidatorBuilder()
				.withLongPathVariableValidator(listId)
				.withLongPathVariableValidator(songId)
				.build()
				.validate();
		
		this.listOfSongsService.removeSongOfList(listId, songId);
		
		return new ResponseEntity<>(UPDATE_SUCCESS_MESSAGE, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<String> addList(@RequestBody ListOfSongs body) {
		
		new ValidatorBuilder()
				.withEntityValidator(body)
				.build()
				.validate();
		
		listOfSongsService.addList(body);
		
		return new ResponseEntity<>(CREATE_SUCCESS_MESSAGE, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteList(@PathVariable Long id) {
		
		new ValidatorBuilder()
				.withLongPathVariableValidator(id)
				.build()
				.validate();
		
		listOfSongsService.removeList(id);
		
		return new ResponseEntity<>(DELETE_SUCCESS_MESSAGE, HttpStatus.OK);
	}
}
