package be.pcab.wonghetto.wonghettoserver.models;

import org.json.simple.JSONObject;

public class Request {
	
	private JSONObject content;

	public JSONObject getContent() {
		return content;
	}

	public void setContent(JSONObject content) {
		this.content = content;
	}

}
