package flipkartPageObject;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClickCloseButton {
	WebDriver driver;

	public LoginClickCloseButton(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement closeIcon;
	@FindBy(xpath = "//div[@class='_1AtVbE col-12-12']/div/div/div/div/a/div/img[2]")
	WebElement banner;
	@FindBy(xpath = "//div[@class='_1AtVbE col-12-12']//img[@class='kJjFO0']")
	WebElement banner1;

	public void clickingCloseButton() {
		try {
			closeIcon.click();
		} catch (Exception e) {
			System.out.println("login pop-up not found");

		}

	}

	public void goTo() {

		driver.navigate().to("https://www.flipkart.com/");

	}

	public MainMenuSubMenu banner() {
		try {
			banner.click();
		} catch (ElementNotInteractableException e) {
			banner1.click();

		}
		MainMenuSubMenu mainsub = new MainMenuSubMenu(driver);
		return mainsub;

	}
}
