package be.pcab.wonghetto.wonghettocore;

public abstract class Wonghetto {

	private ApplicationType applicationType;


	public void switchOn() {

		init();
	}

	public void switchOff() {

		releaseResources();
		
		exit();
	}

	public ApplicationType getApplicationType() {
		return applicationType;
	}
	
	protected void setApplicationType(ApplicationType type){
		
		this.applicationType = type;
	}

	protected void init() {
		// TODO Auto-generated method stub
		
	}
	
	protected void exit() {
		// TODO Auto-generated method stub
		
	}

	protected void releaseResources() {
		// TODO Auto-generated method stub
		
	}
}
