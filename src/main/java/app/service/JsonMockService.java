package app.service;

import org.springframework.stereotype.Component;

@Component
public class JsonMockService {

	private final String INITIAL_JSON = 
		"["
			+ "{"
				+	"\"id\": \"1\","
				+   "\"name\": \"LIST-1\","
				+    "\"songs\": ["
				+        "{"
				+			"\"id\": \"1\","
				+            "\"name\": \"thesong1\","
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
				+   "\"name\": \"LIST-2\","
				+    "\"songs\": ["
				+        "{"
				+			 "\"id\": \"3\","
				+            "\"name\": \"song3\","
				+            "\"title\": \"title3\","
				+            "\"artist\": \"artist3\","
				+            "\"album\": \"album3\""
				+        "},"
				+		"{"
				+			 "\"id\": \"4\","
				+            "\"name\": \"thesong4\","
				+            "\"title\": \"title4\","
				+            "\"artist\": \"artist4\","
				+            "\"album\": \"album4\""
				+        "}"
				+    "]"
				+ "},"
				
				+ "{"
				+	"\"id\": \"3\","
				+   "\"name\": \"LIST-3\","
				+    "\"songs\": ["
				+        "{"
				+			 "\"id\": \"2\","
				+            "\"name\": \"song2\","
				+            "\"title\": \"title2\","
				+            "\"artist\": \"artist2\","
				+            "\"album\": \"album2\""
				+        "},"
				+		"{"
				+			 "\"id\": \"5\","
				+            "\"name\": \"song5\","
				+            "\"title\": \"title5\","
				+            "\"artist\": \"artist5\","
				+            "\"album\": \"album5\""
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
