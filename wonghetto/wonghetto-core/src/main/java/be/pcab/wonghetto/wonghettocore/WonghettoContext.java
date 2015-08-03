package be.pcab.wonghetto.wonghettocore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.pcab.wonghetto.wonghettocore.cloud.WonghettoCloud;


/**
 * The context of the application.
 * 
 * @author Paolo Cabras
 *
 */

public class WonghettoContext extends AnnotationConfigApplicationContext{

	private static WonghettoContext instance;
	
	private Wonghetto wonghetto;
	
	private WonghettoCloud cloud;
	
	private WonghettoContext() {
		
		this.scan("be.pcab.wonghetto");
		this.refresh();
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
