package be.pcab.wonghetto.wonghettodesktop.ui;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * The Statusbar for the wonghetto-desktop application.<br>
 * This bar is meant for notification related to user work flow.
 * 
 * @author Paolo Cabras
 *
 */
public class StatusBar extends HBox {
	
	private TextField textField;
	
	public StatusBar() {
		
		textField = new TextField("wonghetto correctly started!");
		textField.setEditable(false);
		textField.setPrefWidth(500);
		
		this.getChildren().add(textField);
	}
	
	public String getStatusText(){
		
		return textField.getText();
	}
	
	public void setStatusText(String text){
		
		textField.setText(text);
	}
	

}
