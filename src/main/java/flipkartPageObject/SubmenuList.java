package flipkartPageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmenuList {
	WebDriver driver;
	WebElement mainMenu;

	public SubmenuList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='_1kidPb']/span")
	List<WebElement> mainmenus;

	@FindBy(xpath = "//div[@class='_1QrT3s']//a | //div[@class='_1QrT3s']//span")
	List<WebElement> subMenuLists;

	@FindBy(xpath = "//div[@class='_1QrT3s']//a[@class='_3QN6WI _1MMnri _32YDvl'] | //div[@class='_1QrT3s']//span")
	List<WebElement> subMenuHeaders;

	public void subMenuList() {
		int count = 0;
		for (WebElement mainmenu : mainmenus) {
			System.out.println("Main Menu Text" + " " + mainmenu.getText());
			Actions act = new Actions(driver);
			act.moveToElement(mainmenu).perform();

			for (int i = 0; i < subMenuLists.size(); i++) {
				WebElement list1 = subMenuLists.get(i);
				if (subMenuHeaders.contains(list1)) {
					System.out.println(list1.getText());
					count = 0;
				} else if (!subMenuHeaders.contains(list1)) {
					count++;
					System.out.println(count + ". " + list1.getText());
				}
			}

		}
	}
}
