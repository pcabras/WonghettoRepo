package be.pcab.wonghetto.wonghettodesktop.event;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import be.pcab.wonghetto.wonghettocore.model.CategoryElementModel;
import be.pcab.wonghetto.wonghettocore.model.CategoryModel;
import be.pcab.wonghetto.wonghettodesktop.bind.UIComponentsManager;
import be.pcab.wonghetto.wonghettodesktop.tasks.CloudInitService;
import be.pcab.wonghetto.wonghettodesktop.tasks.CloudReleaseService;
import be.pcab.wonghetto.wonghettodesktop.tasks.CloudSynchronizeService;
import be.pcab.wonghetto.wonghettodesktop.ui.CategoryPane;

public class EventHolder {

	private static UIComponentsManager componentManager = UIComponentsManager
			.getInstance();

	private static EventHandler<ActionEvent> addCategoryHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {

			TextInputDialog inputDialog = new TextInputDialog();
			inputDialog.setHeaderText("Type the Category name");

			inputDialog.showAndWait();

			String categoryName = inputDialog.getResult();

			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setName(categoryName);

			CategoryPane categoryPane = new CategoryPane(categoryModel);

			componentManager.getCategoryPanes().add(categoryPane);

			componentManager.getStatusBar().setStatusText(
					categoryName + " category successfully added!");
		}
	};

	private static EventHandler<ActionEvent> addCategoryElementHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Select Element");
			File selectedFile = fileChooser.showOpenDialog(componentManager
					.getPrimaryStage());

			CategoryElementModel categoryElementModel = new CategoryElementModel();
			categoryElementModel.setName(selectedFile.getName());
			categoryElementModel.setPath(selectedFile.getAbsolutePath());
			categoryElementModel.setSize(selectedFile.length());

			CategoryPane pane = (CategoryPane) componentManager.getAccordion()
					.getExpandedPane();

			pane.getTable().getItems().add(categoryElementModel);

			componentManager.getStatusBar().setStatusText(
					"The file " + selectedFile.getName() + " has been chosen");

		}
	};

	private static EventHandler<ActionEvent> removeCategoryElementHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {

			CategoryPane pane = (CategoryPane) componentManager.getAccordion()
					.getExpandedPane();
			CategoryElementModel elementToRemove = pane.getTable()
					.getSelectionModel().getSelectedItem();

			pane.getTable().getItems().remove(elementToRemove);
		}
	};

	private static EventHandler<ActionEvent> startServerHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
	
			CloudInitService initService = new CloudInitService();
			initService.start();
			
		}
	};

	private static EventHandler<ActionEvent> stopServerHandler = new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			
			CloudReleaseService releaseService = new CloudReleaseService();
			releaseService.start();
		}
	};

	private static EventHandler<ActionEvent> syncronizeServerHandler = new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			
			CloudSynchronizeService synchronizeService = new CloudSynchronizeService(null);
			synchronizeService.start();
		}
	};
	
//	EVENTS GETTERS
	
	public static EventHandler<ActionEvent> getAddCategoryHandler() {

		return addCategoryHandler;
	}

	public static EventHandler<ActionEvent> getAddCategoryElementHandler() {

		return addCategoryElementHandler;
	}

	public static EventHandler<ActionEvent> getRemoveCategoryElementHandler() {

		return removeCategoryElementHandler;
	}

	public static EventHandler<ActionEvent> getStartServerHandler() {

		return startServerHandler;
	}
	
	public static EventHandler<ActionEvent> getStopServerHandler(){
		
		return stopServerHandler;
	}
	
	public static EventHandler<ActionEvent> getSynchronizeServerHandler(){
		
		return syncronizeServerHandler;
	}
}
