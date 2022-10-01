package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import app.domain.ListOfSongs;

@Component
public class JsonMockServiceAdapter {
	
	private JsonMockService jsonMockService;
	private Gson gson;
	
	@Autowired
	public JsonMockServiceAdapter(JsonMockService jsonMockService, Gson gson) {
		this.jsonMockService = jsonMockService;
		this.gson = gson;
	}
	
	public List<ListOfSongs> getLists() {
		return gson.fromJson(jsonMockService.getActualJson(), new TypeToken<List<ListOfSongs>>(){}.getType());
	}
	
	public void setLists() {
		
	}
}
