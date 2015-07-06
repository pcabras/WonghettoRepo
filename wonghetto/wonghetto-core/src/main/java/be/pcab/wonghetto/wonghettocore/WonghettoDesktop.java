package be.pcab.wonghetto.wonghettocore;

import be.pcab.wonghetto.wonghettocore.cloud.WonghettoCloud;

/**
 * 
 * The desktop application
 * 
 * @author Paolo Cabras
 *
 */
public class WonghettoDesktop extends Wonghetto{

	@Override
	protected void init() {
		
		WonghettoCloud cloud = new WonghettoCloud();
		WonghettoContext context = WonghettoContext.getInstance();
		
		context.setCloud(cloud);
		
		super.init();
	}

	@Override
	protected void exit() {
		// TODO Auto-generated method stub
		super.exit();
	}

	@Override
	protected void releaseResources() {
		// TODO Auto-generated method stub
		super.releaseResources();
	}

	
}
