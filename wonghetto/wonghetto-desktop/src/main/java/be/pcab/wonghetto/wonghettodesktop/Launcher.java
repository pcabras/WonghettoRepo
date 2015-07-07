package be.pcab.wonghetto.wonghettodesktop;

import be.pcab.wonghetto.wonghettocore.ApplicationBuilder;
import be.pcab.wonghetto.wonghettocore.ApplicationType;
import be.pcab.wonghetto.wonghettocore.Wonghetto;
import be.pcab.wonghetto.wonghettocore.WonghettoContext;
import be.pcab.wonghetto.wonghettodesktop.ui.MainUI;
import javafx.application.Application;

/**
 * The launcher of the desktop application
 * 
 * @author Paolo Cabras
 *
 */
public class Launcher {



	public static void main(String[] args) {

		WonghettoContext context = WonghettoContext.getInstance();

		Wonghetto wonghetto = ApplicationBuilder.builder()
				.type(ApplicationType.DESKTOP).build();
		
		wonghetto.switchOn();
		
		context.setWonghetto(wonghetto);
		
		Application.launch(MainUI.class, args);
	}

}
