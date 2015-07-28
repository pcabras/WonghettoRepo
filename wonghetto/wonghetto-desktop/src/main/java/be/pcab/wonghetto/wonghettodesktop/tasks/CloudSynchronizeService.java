package be.pcab.wonghetto.wonghettodesktop.tasks;

import be.pcab.wonghetto.wonghettocore.WonghettoContext;
import be.pcab.wonghetto.wonghettocore.cloud.WonghettoCloud;
import be.pcab.wonghetto.wonghettocore.model.CategoryModel;
import be.pcab.wonghetto.wonghettodesktop.ui.UIComponentsManager;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * An appropriate implementation of the {@link Service} interface.<br>
 * It is in charge of synchronizing the cloud with user's view.
 * 
 * @author Paolo Cabras
 *
 */
public class CloudSynchronizeService extends Service<Void> {

	private UIComponentsManager componentManager;

	private ObservableList<CategoryModel> categoryModels;

	public CloudSynchronizeService(ObservableList<CategoryModel> categoryModels) {

		componentManager = UIComponentsManager.getInstance();
		this.categoryModels = categoryModels;
	}

	@Override
	protected Task<Void> createTask() {

		return new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				WonghettoCloud cloud = WonghettoContext.getInstance()
						.getCloud();
				cloud.synchronize(categoryModels);

				componentManager.getStatusBar().setStatusText(
						"Wonghetto Cloud is synchronized with the View");
				return null;
			}
		};
	}

}
