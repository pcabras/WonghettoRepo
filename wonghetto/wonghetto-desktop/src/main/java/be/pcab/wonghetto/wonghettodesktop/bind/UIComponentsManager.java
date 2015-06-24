package be.pcab.wonghetto.wonghettodesktop.bind;


import be.pcab.wonghetto.wonghettodesktop.ui.StatusBar;
import javafx.collections.ObservableList;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;


public class UIComponentsManager {
	
	private static UIComponentsManager instance;
	
	private ObservableList<TitledPane> categoryPanes;
	
	private StatusBar statusBar;
	
	private Stage primaryStage;
	
	private Accordion accordion;
	
	private UIComponentsManager() {
		
	}

	public ObservableList<TitledPane> getCategoryPanes() {
		return categoryPanes;
	}

	public void setCategoryPanes(ObservableList<TitledPane> categoryPanes) {
		this.categoryPanes = categoryPanes;
	}
	
	public StatusBar getStatusBar() {
		
		if(statusBar == null){
			
			statusBar = new StatusBar();
		}
		
		return statusBar;
	}

	public void setStatusBar(StatusBar statusBar) {
		this.statusBar = statusBar;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Accordion getAccordion() {
		return accordion;
	}

	public void setAccordion(Accordion accordion) {
		this.accordion = accordion;
	}

	public static UIComponentsManager getInstance(){
		
		if(instance == null){
			
			instance = new UIComponentsManager();
		}
		return instance;
	}

}
