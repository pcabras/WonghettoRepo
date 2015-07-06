package be.pcab.wonghetto.wonghettocore;

/**
 * A builder for applications.<br>
 * It allows to build the application (either {@link WonghettoDesktop} or {@link WonghettoApp})
 * depending on the {@link ApplicationType}.
 * 
 * @author Paolo Cabras
 *
 */
public class ApplicationBuilder {

	
	private ApplicationType applicationType;
	
	/**
	 * creates and returns an instance of the current object 
	 * 
	 * @return an {@link ApplicationBuilder}
	 */
	public static ApplicationBuilder builder(){
		
		return new ApplicationBuilder();
	}
	
	/**
	 * sets the type of {@link Wonghetto}
	 * 
	 * @param applicationType
	 * @return
	 */
	public ApplicationBuilder type(ApplicationType applicationType){
		
		this.applicationType = applicationType;
		
		return this;
	}
	
	/**
	 * builds a {@link Wonghetto} instance according to the {@link ApplicationType}
	 * 
	 * @return
	 */
	public Wonghetto build(){
		
		Wonghetto wonghetto = null;
		
		if(applicationType == ApplicationType.DESKTOP){
			
			wonghetto = new WonghettoDesktop();
			wonghetto.setApplicationType(applicationType);
			
		}
		else{
			
			wonghetto = new WonghettoApp();
			wonghetto.setApplicationType(applicationType);
		
		}
		
		return wonghetto;
		
	}
}
