package app.service;

import org.springframework.stereotype.Component;

@Component
public class JsonMockService {

	private final String INITIAL_JSON = 
		"["
			+ "{"
				+	"\"id\": \"1\","
				+   "\"name\": \"list1\","
				+    "\"canciones\": ["
				+        "{"
				+			"\"id\": \"1\","
				+            "\"name\": \"song1\","
				+            "\"title\": \"title1\","
				+            "\"artist\": \"artist1\","
				+            "\"album\": \"album1\""
				+        "},"
				+		"{"
				+			 "\"id\": \"2\","
				+            "\"name\": \"song2\","
				+            "\"title\": \"title2\","
				+            "\"artist\": \"artist2\","
				+            "\"album\": \"album2\""
				+        "}"
				+    "]"
			+ "},"
			+ "{"
				+	"\"id\": \"2\","
				+   "\"name\": \"list2\","
				+    "\"canciones\": ["
				+        "{"
				+			 "\"id\": \"3\","
				+            "\"name\": \"song3\","
				+            "\"title\": \"title3\","
				+            "\"artist\": \"artist3\","
				+            "\"album\": \"album3\""
				+        "},"
				+		"{"
				+			 "\"id\": \"4\","
				+            "\"name\": \"song4\","
				+            "\"title\": \"title4\","
				+            "\"artist\": \"artist4\","
				+            "\"album\": \"album4\""
				+        "}"
				+    "]"
			+ "}" + "]"
		;
	
	private String actualJson;
	
	public JsonMockService() {
		this.actualJson = INITIAL_JSON;
	}
	
	public String getActualJson() {
		return actualJson;
	}

	public void setActualJson(String actualJson) {
		this.actualJson = actualJson;
	}
}
