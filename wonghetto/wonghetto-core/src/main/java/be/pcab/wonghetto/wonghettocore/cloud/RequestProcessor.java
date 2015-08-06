package be.pcab.wonghetto.wonghettocore.cloud;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.Processor;
import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.Request;
import be.pcab.wonghetto.wonghettoserver.exchangeprotocol.RequestType;

public class RequestProcessor implements Processor<Request>{

	private static Logger logger = Logger.getLogger(RequestProcessor.class);
	
	public RequestProcessor() {

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Request process(Request request) throws Exception {

		logger.info("processing request...");

		RequestType requestType = (RequestType) request.getContent()
				.get("Type");

		switch (requestType) {

		case INFO:
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Type", requestType);
			jsonObject.put("Content", "Request Processed");
			
			request.setContent(jsonObject);
			break;

		default:
			break;
		}

		request.markAsProcessed();
		
		logger.info("request processed");
		
		return request;
	}
	

}
