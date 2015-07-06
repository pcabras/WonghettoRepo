package be.pcab.wonghetto.wonghettocore;


/**
 * 
 * Abstract class representing a {@link Wonghetto} application.<br>
 * Basically, it can be one of the two:<br>
 * {@link WonghettoDesktop} (the desktop application) or {@link WonghettoApp} (the mobile application).
 * 
 * @author Paolo Cabras
 *
 */
public abstract class Wonghetto {

	private ApplicationType applicationType;

	/**
	 * Switches the application on.
	 * 
	 */
	public void switchOn() {

		init();
	}

	/**
	 * 
	 * Switches the application off
	 */
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

	/**
	 * 
	 * Initializes the application.
	 */
	protected void init() {
		
		// to be implemented		
	}
	
	/**
	 * 
	 * Closes the application. 
	 */
	protected void exit() {
		
		// to be implemented
	}

	/**
	 * 
	 * Releases all resources.
	 */
	protected void releaseResources() {
		
		// to be implemented
	}
}
