package be.pcab.wonghetto.wonghettoserver.testpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotatedTestBean {

	@Autowired
	private NotAnnotatedTestBean notAnnotatedTestBean;
	
	public String getMessage(){
		
		return notAnnotatedTestBean.getMessage();
	}
}
