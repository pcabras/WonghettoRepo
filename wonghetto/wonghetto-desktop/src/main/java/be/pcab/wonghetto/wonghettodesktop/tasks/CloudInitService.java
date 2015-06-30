package be.pcab.wonghetto.wonghettodesktop.tasks;

import be.pcab.wonghetto.wonghettocore.WonghettoContext;
import be.pcab.wonghetto.wonghettocore.cloud.WonghettoCloud;
import be.pcab.wonghetto.wonghettodesktop.bind.UIComponentsManager;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CloudInitService extends Service<Void> {

	private UIComponentsManager componentManager;
	
	public CloudInitService() {
		
		componentManager = UIComponentsManager.getInstance();
	}
	
	@Override
	protected Task<Void> createTask() {
		
		return new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				
				WonghettoCloud cloud = WonghettoContext.getInstance().getCloud();
				cloud.getIn();
				componentManager.getStatusBar().setStatusText("Wonghetto Cloud is now available");
				
				return null;
			}
		};
	}

}
