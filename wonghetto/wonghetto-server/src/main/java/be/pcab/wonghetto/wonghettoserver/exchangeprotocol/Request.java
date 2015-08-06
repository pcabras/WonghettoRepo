package be.pcab.wonghetto.wonghettoserver.exchangeprotocol;


import org.json.simple.JSONObject;


public class Request {
	
	private JSONObject json;
	
	public Request() {
		
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public RequestType getRequestType(){
		
		return (RequestType) json.get("Type");
	}
}
