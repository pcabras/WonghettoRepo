package be.pcab.wonghetto.wonghettodesktop.ui;

import be.pcab.wonghetto.wonghettocore.model.CategoryModel;
import be.pcab.wonghetto.wonghettodesktop.bind.UIComponentsManager;
import be.pcab.wonghetto.wonghettodesktop.event.EventHolder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI extends Application {

	private BorderPane mainPane;


	private UIComponentsManager componentManager;

	@Override
	public void start(Stage primaryStage) throws Exception {

		componentManager = UIComponentsManager.getInstance();
		componentManager.setPrimaryStage(primaryStage);
		
		mainPane = new BorderPane();
		Scene scene = new Scene(mainPane);

		mainPane.setTop(createTop());
		mainPane.setCenter(createCenter());
		mainPane.setBottom(createBottom());

		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.setTitle("wonghetto");
		primaryStage.show();

	}

	private MenuBar createMenuBar() {

		// MENU FILE

		MenuItem exitItem = new MenuItem("Exit");

		Menu fileMenu = new Menu("File");
		fileMenu.getItems().add(exitItem);

		// MENU SERVER

		MenuItem startItem = new MenuItem("Start Server");

		MenuItem syncItem = new MenuItem("Syncronize");

		MenuItem stopItem = new MenuItem("Stop Server");

		Menu serverMenu = new Menu("Server");
		serverMenu.getItems().add(startItem);
		serverMenu.getItems().add(syncItem);
		serverMenu.getItems().add(stopItem);

		// MENU EDIT

		MenuItem newCategoryItem = new MenuItem("new Category...");
		newCategoryItem.setOnAction(EventHolder.getAddCategoryHandler());
		
		MenuItem newCategoryElementItem = new MenuItem("new Node...");
		newCategoryElementItem.setOnAction(EventHolder.getAddCategoryElementHandler());
		
		MenuItem removeCategoryElementItem = new MenuItem("remove Node");
		removeCategoryElementItem.setOnAction(EventHolder.getRemoveCategoryElement());
		
		Menu editMenu = new Menu("Edit");
		editMenu.getItems().add(newCategoryItem);
		editMenu.getItems().add(newCategoryElementItem);
		editMenu.getItems().add(removeCategoryElementItem);

		// MENU HELP

		MenuItem helpItem = new MenuItem("About");

		Menu helpMenu = new Menu("Help");
		helpMenu.getItems().add(helpItem);

		// MENUBAR

		MenuBar menuBar = new MenuBar();

		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(serverMenu);
		menuBar.getMenus().add(editMenu);
		menuBar.getMenus().add(helpMenu);

		return menuBar;
	}

	private ToolBar createToolBar() {

		ToggleButton newButton = new ToggleButton("new");
		newButton.setOnAction(EventHolder.getAddCategoryHandler());

		ToggleButton startButton = new ToggleButton("start");

		ToggleButton syncButton = new ToggleButton("sync");

		ToggleButton stopButton = new ToggleButton("stop");

		Separator separator = new Separator();

		ToolBar toolBar = new ToolBar();
		toolBar.getItems().add(newButton);
		toolBar.getItems().add(separator);
		toolBar.getItems().add(startButton);
		toolBar.getItems().add(syncButton);
		toolBar.getItems().add(stopButton);

		return toolBar;

	}

	private VBox createTop() {

		VBox box = new VBox();

		box.getChildren().add(createMenuBar());
		box.getChildren().add(createToolBar());

		return box;
	}

	private TabPane createCenter() {

		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setName("Music");

		Accordion accordion = new Accordion();
		componentManager.setAccordion(accordion);
		
		componentManager.setCategoryPanes(accordion.getPanes());

		CategoryPane categoryPane = new CategoryPane(categoryModel);
		accordion.getPanes().add(categoryPane);

		Tab contentsTab = new Tab("Contents");
		contentsTab.setContent(accordion);

		TabPane tabPane = new TabPane();
		tabPane.getTabs().add(contentsTab);

		return tabPane;
	}

	private HBox createBottom() {
		
		return componentManager.getStatusBar();
	}

}
