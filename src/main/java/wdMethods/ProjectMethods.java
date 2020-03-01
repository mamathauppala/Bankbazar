package wdMethods;

import org.testng.annotations.AfterMethod;

public class ProjectMethods extends SeMethods{

	
	public void Loadpage() {
		startApp("chrome", "https://www.bankbazaar.com/");
		
	}
	
	@AfterMethod(groups="common")
	public void close() {
		closeAllBrowsers();
	}
	
	
	}
	
	
	
	
	
	
	
	
	
