package be.pcab.wonghetto.wonghettoserver.models;

import java.util.List;
import java.util.Observable;


public class RequestsContainer extends Observable {
	
	private List<Request> requests;

	public RequestsContainer() {
		
		
	}

	public void addRequest(Request request){
		
		requests.add(request);
		
		notifyObservers(request);
	}
	
	public void removeRequest(Request request){
		
		requests.remove(request);
		
		
	}

}
