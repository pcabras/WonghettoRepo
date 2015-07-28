package be.pcab.wonghetto.wonghettocore;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CloudInitializer {

	private AnnotationConfigApplicationContext applicationContext;
	
	public CloudInitializer() {
		
		init();
	}
	
	public  void init() {

		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("be.pcab.wonghetto.wonghettocore.cloud");
		applicationContext.refresh();
				
	}
	
	public Object getBean(Class clazz){
		
		return applicationContext.getBean(clazz);
	}
	
}
