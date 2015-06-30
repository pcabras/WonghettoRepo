package be.pcab.wonghetto.wonghettodesktop.tasks;

import be.pcab.wonghetto.wonghettocore.WonghettoContext;
import be.pcab.wonghetto.wonghettocore.cloud.WonghettoCloud;
import be.pcab.wonghetto.wonghettocore.model.CategoryModel;
import be.pcab.wonghetto.wonghettodesktop.bind.UIComponentsManager;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CloudSynchronizeService extends Service<Void> {

	private UIComponentsManager componentManager;

	private CategoryModel[] categoryModels;

	public CloudSynchronizeService(CategoryModel[] categoryModels) {

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
