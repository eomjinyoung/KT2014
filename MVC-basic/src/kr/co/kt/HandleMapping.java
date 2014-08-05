package kr.co.kt;

import java.util.HashMap;
import java.util.Map;

public class HandleMapping {

	Map<String, Controller> mappings = null;

	public HandleMapping() {
		mappings = new HashMap<>();
		
		mappings.put("/list.do", new ListController());
		mappings.put("/writeForm.do", new WriteFormController());
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
}
