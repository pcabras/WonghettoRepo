package be.pcab.wonghetto.wonghettodesktop.event;

import java.util.Observable;

import org.apache.log4j.Logger;

import be.pcab.wonghetto.wonghettocore.cloud.RequestObserver;
import be.pcab.wonghetto.wonghettoserver.models.Request;

public class RequestProcessor implements RequestObserver {

	private static Logger logger = Logger.getLogger(RequestProcessor.class);
	
	
	public RequestProcessor() {

	}
	
	@Override
	public void update(Observable o, Object incomingRequest) {
		
		Request request = (Request)incomingRequest;

		try {
			
			process(request);
		} catch (Exception e) {
			
			logger.error(e);
		}
	}
	
	private void process(Request request)throws Exception{
		
		logger.info("processing request...");
		
		logger.info("request processed");
	}

}
