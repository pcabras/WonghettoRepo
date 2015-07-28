package be.pcab.wonghetto.wonghettocore.cloud;

import org.springframework.stereotype.Component;

@Component
public class AOPService {
	
	private boolean started;
	
	public AOPService() {
		
		started = true;
	}
	
	public boolean isStarted(){
		
		return started;
	}
	
	

}
