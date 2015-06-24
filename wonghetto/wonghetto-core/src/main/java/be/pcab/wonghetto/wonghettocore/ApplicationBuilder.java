package be.pcab.wonghetto.wonghettocore;

public class ApplicationBuilder {

	
	private ApplicationType applicationType;
	
	public static ApplicationBuilder builder(){
		
		return new ApplicationBuilder();
	}
	
	public ApplicationBuilder type(ApplicationType applicationType){
		
		this.applicationType = applicationType;
		
		return this;
	}
	
	public Wonghetto build(){
		
		Wonghetto wonghetto = null;
		
		if(applicationType == ApplicationType.DESKTOP){
			
			wonghetto = new WonghettoDesktop();
		}
		else{
			
			wonghetto = new WonghettoApp();
		}
		
		return wonghetto;
		
	}
}
