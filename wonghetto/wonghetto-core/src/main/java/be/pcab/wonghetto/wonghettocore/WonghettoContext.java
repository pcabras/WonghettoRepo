package be.pcab.wonghetto.wonghettocore;

import be.pcab.wonghetto.wonghettocore.cloud.WonghettoCloud;


public class WonghettoContext {

	private static WonghettoContext instance;
	
	private Wonghetto wonghetto;
	
	private WonghettoCloud cloud;
	
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

	public WonghettoCloud getCloud() {
		return cloud;
	}

	public void setCloud(WonghettoCloud cloud) {
		this.cloud = cloud;
	}
	
	
}
