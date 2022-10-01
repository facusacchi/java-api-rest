package app;

import org.springframework.boot.test.context.SpringBootTest;

import app.domain.ListOfSongs;
import app.service.JsonMockServiceAdapter;
import app.service.ListOfSongsService;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class ListOfSongsServiceTests {

	private JsonMockServiceAdapter serviceAdapterMock;
	
	private ListOfSongsService listOfSongsService;

	@BeforeEach
    public void setUp() throws Exception {
		serviceAdapterMock = mock(JsonMockServiceAdapter.class);
		listOfSongsService = new ListOfSongsService(serviceAdapterMock);
	}
	
//	@Test
//	@DisplayName("")
//	public void test() {
//		Song song = new Song();
//		ListOfSongs listOfSongs = new ListOfSongs();
//		
//		doNothing().when(serviceAdapterMock).setLists(any());
//		
//		listOfSongsService.addList();
//	}
}

//		when(serviceAdapterMock.).thenReturn();