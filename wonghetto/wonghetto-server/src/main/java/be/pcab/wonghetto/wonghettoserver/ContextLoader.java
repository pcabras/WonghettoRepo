package be.pcab.wonghetto.wonghettoserver;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoader {

	private ClassPathXmlApplicationContext applicationContext;
	
	public ContextLoader() {
		
		load();
	}
	
	private void load() {

		applicationContext = new ClassPathXmlApplicationContext(
				"**/application-context.xml");

		applicationContext.refresh();
	}
	
	
	protected Object getBean(Class clazz){
		
		return applicationContext.getBean(clazz);
	}

}
