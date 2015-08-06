package be.pcab.wonghetto.wonghettocore.cloud;

import org.json.simple.JSONObject;

import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.RequestType;

public class JsonRequestBuilder {

	private RequestType requestType;
	
	private String content;
	
	public JsonRequestBuilder builder(){
		
		return new JsonRequestBuilder();
	}
	
	public  JsonRequestBuilder type(RequestType requestType){
		
		this.requestType = requestType;
		
		return this;
	}
	
	public JsonRequestBuilder content(String content){
		
		this.content = content;
		
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject build(){
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Type", requestType);
		
		switch (requestType) {
		
			case INFO:
			
				jsonObject.put("Content", content);
				
			break;

		default:
			break;
		}
		
		return jsonObject;
	}
}
