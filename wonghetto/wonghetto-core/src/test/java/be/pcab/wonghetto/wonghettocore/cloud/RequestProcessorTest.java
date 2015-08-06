package be.pcab.wonghetto.wonghettocore.cloud;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.Request;
import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.RequestType;

public class RequestProcessorTest {

	private RequestProcessor processor;

	@Before
	public void setUp() throws Exception {

		processor = new RequestProcessor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProcessInfo() {

		JSONObject incomingJSON = JsonRequestBuilder.builder()
				.type(RequestType.INFO).content("a content").build();
		
		Request incomingRequest = new Request();
		incomingRequest.setJson(incomingJSON);
		
		Request outComingRequest = null;
		
		try {
			outComingRequest = processor.process(incomingRequest);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		assertEquals(RequestType.PROCESSED, outComingRequest.getRequestType());
	}
	
	@Test
	public void testProcessCloudMirror(){
		
		JSONObject incomingJSON = JsonRequestBuilder.builder()
				.type(RequestType.CLOUD_MIRROR).content("a content").build();
		
		Request incomingRequest = new Request();
		incomingRequest.setJson(incomingJSON);
		
		Request outComingRequest = null;
		
		try {
			outComingRequest = processor.process(incomingRequest);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		assertEquals(RequestType.PROCESSED, outComingRequest.getRequestType());
		
		String expected = "Music, Documents, categoryToDelete";
		
		assertEquals(expected, outComingRequest.getJson().get("Content"));
		
		
	}

}
