package be.pcab.wonghetto.wonghettoserver.exchangeprotocol;

import java.util.concurrent.CountDownLatch;

import org.json.simple.JSONObject;

public class Request {
	
	private JSONObject content;
	
	private CountDownLatch latch;
	
	public Request() {
		
		latch = new CountDownLatch(1);
	}

	public JSONObject getContent() {
		return content;
	}

	public void setContent(JSONObject content) {
		this.content = content;
	}
	
	public CountDownLatch getLatch(){
		
		return latch;
	}

	public void markAsProcessed(){
		
		latch.countDown();
	}
}
