package flipkartPageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenuSubMenu {
	WebDriver driver;
	WebElement mainMenu;

	public MainMenuSubMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='_1kidPb']/span")
	List<WebElement> mainMenuItems;

	@FindBy(xpath = "//a[@class='_2I9KP_']")
	List<WebElement> mainMenuItemsexs;

	@FindBy(xpath = "//div[@class='_1fwVde']//a[@class='_3QN6WI _1MMnri _32YDvl']")
	List<WebElement> subMenuHeaders;

	public void mainmenuSubmenuHeaders() {
		for (WebElement mainMenu : mainMenuItems) {
			System.out.println();
			System.out.println("Main Menu Text" + " " + "is" + "\t " + mainMenu.getText());
			System.out.println();
			Actions act = new Actions(driver);
			act.moveToElement(mainMenu).perform();
			for (WebElement subMenuHeader : subMenuHeaders) {
			System.out.println("SubMenuHeader Text is" + "  " + subMenuHeader.getText());
			}

		}

	}

	public SubmenuList mainmenuex() {
		for (WebElement mainMenuItemsex : mainMenuItemsexs) {
			System.out.println("Main Menu Text" + " " + "is" + "\t " + mainMenuItemsex.getText());
		}
		SubmenuList sub = new SubmenuList(driver);
		return sub;
	}
}