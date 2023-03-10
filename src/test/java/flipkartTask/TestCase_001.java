package flipkartTask;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browserInvocation.BasePage;
import flipkartPageObject.MainMenuSubMenu;
import flipkartPageObject.SubmenuList;

public class TestCase_001 extends BasePage {
	
	 WebDriver driver;
	 @Test()
	 public void menuAndSubmenuPriniting()
	 {
		 login.clickingCloseButton();
		 MainMenuSubMenu mainsub=login.banner();
		 mainsub.mainmenuSubmenuHeaders();
		 SubmenuList sub=mainsub.mainmenuex();
		 sub.subMenuList();	 		
		
	 }
}
