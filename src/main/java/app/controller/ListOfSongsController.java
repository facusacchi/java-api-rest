package app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.ListOfSongs;
import app.domain.Song;
import app.service.ListOfSongsService;

@RestController
@RequestMapping("/api/v1/listOfSongs")
public class ListOfSongsController {
	
	@Autowired
	private ListOfSongsService listOfSongsService;
	
	@GetMapping("/lists")
	public ResponseEntity<List<ListOfSongs>> getListsOfSongs() {
		
		List<ListOfSongs> listOfSongs = listOfSongsService.getLists();
		
		return new ResponseEntity<>(listOfSongs, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createNewList")
	public ResponseEntity<String> addList(@RequestBody ListOfSongs body) {
		
		listOfSongsService.addList(body);
		
		return new ResponseEntity<>("Lista de canciones creada correctamente.", HttpStatus.OK);
	}
}
