package be.pcab.wonghetto.wonghettocore;


public class WonghettoContext {

	private static WonghettoContext instance;
	
	private Wonghetto wonghetto;
	
	private WonghettoContext() {
		
	}
	
	public static WonghettoContext getInstance(){
		
		if(instance == null){
			
			instance = new WonghettoContext();
		}
		
		return instance;
	}

	public Wonghetto getWonghetto() {
		return wonghetto;
	}

	public void setWonghetto(Wonghetto wonghetto) {
		this.wonghetto = wonghetto;
	}
	
	
}
