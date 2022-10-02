package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import app.adapter.JsonMockServiceAdapter;
import app.builder.ListOfSongsBuilder;
import app.builder.SongBuilder;
import app.domain.ListOfSongs;
import app.domain.Song;
import app.service.ListOfSongsService;

@SpringBootTest
@DisplayName("Tests ListOfSongsService")
public class ListOfSongsServiceTests {

	private JsonMockServiceAdapter serviceAdapterMock;
	private ListOfSongsService listOfSongsService;
	private List<Song> songsWithAInitialSong;
	private List<Song> songsWithTwoInitialSongs;
	private ListOfSongs listOfSongsWithTwoSongs;
	private ListOfSongs listOfSongsWithASong;
	private List<ListOfSongs> lists;

	@BeforeEach
    public void setUp() throws Exception {
		serviceAdapterMock = mock(JsonMockServiceAdapter.class);
		listOfSongsService = new ListOfSongsService(serviceAdapterMock);
		
		initializeSongs();
		initializeListsOfSongs();
		
		lists = new ArrayList<>(Arrays.asList(listOfSongsWithASong, listOfSongsWithTwoSongs));
		
		doNothing().when(serviceAdapterMock).setLists(any());
		when(serviceAdapterMock.getLists()).thenReturn(lists);
	}
	
	@Test
	@DisplayName("Cuando buscamos listas que contengan una determinada canción por id de canción, se verifica que nos trae las listas que contienen dicha canción")
	public void getListsBySongIdTest() {
		List<ListOfSongs> fetchedLists = listOfSongsService.getListsBySongId(1L);
		
		assertEquals(2, fetchedLists.size());
	}
	
	@Test
	@DisplayName("Cuando buscamos listas que contengan una determinada canción por el valor de búsqueda enviado, se verifica que nos trae las listas que contangan canciones donde coincidan parcialmente el nombre de dicha canción con el valor de búsqueda")
	public void getListsBySongNameValueTest() {
		List<ListOfSongs> fetchedLists = listOfSongsService.getListsBySongNameValue("great");
		
		assertEquals(1, fetchedLists.size());
	}
	
	@Test
	@DisplayName("Cuando agregamos una canción a una lista, se verifica que dicha canción fue agregada correctamente")
	public void addSongToListTest() {
		listOfSongsService.addSongToList(1000L, new Song());
		ListOfSongs modifiedList = listOfSongsService.findListById(1000L);
		
		assertEquals(2, modifiedList.getSongs().size());
	}
	
	@Test
	@DisplayName("Cuando eliminamos una canción de una lista por id de lista y id de canción, se verifica que dicha canción sea quitada correctamente")
	public void removeSongOfListTest() {
		listOfSongsService.removeSongOfList(1000L, 1L);
		ListOfSongs modifiedList = listOfSongsService.findListById(1000L);
		
		assertTrue(modifiedList.getSongs().isEmpty());
	}
	
	// helper methods
	private void initializeSongs() {
		songsWithAInitialSong = new ArrayList<>(Arrays.asList(
										new SongBuilder()
										.withId(1L)
										.withName("A nice song")
										.withTitle("A nice title")
										.withArtist("A nice artist")
										.withAlbum("A nice album")
										.build()
								));
		
		songsWithTwoInitialSongs = new ArrayList<>(Arrays.asList(
										new SongBuilder()
												.withId(1L)
												.withName("A nice song")
												.withTitle("A nice title")
												.withArtist("A nice artist")
												.withAlbum("A nice album")
												.build(),
										new SongBuilder()
												.withId(2L)
												.withName("The great song")
												.withTitle("The great title")
												.withArtist("The great artist")
												.withAlbum("The great album")
												.build()
								));
	}
	
	private void initializeListsOfSongs() {
		listOfSongsWithASong = new ListOfSongsBuilder()
										.withId(1000L)
										.withName("The ultimate list")
										.withSongs(songsWithAInitialSong)
										.build();
		
		listOfSongsWithTwoSongs = new ListOfSongsBuilder()
										.withId(999L)
										.withName("List reloaded")
										.withSongs(songsWithTwoInitialSongs)
										.build();
	}
}