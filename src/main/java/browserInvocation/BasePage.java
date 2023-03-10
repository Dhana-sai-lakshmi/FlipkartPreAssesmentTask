package browserInvocation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import flipkartPageObject.LoginClickCloseButton;

public class BasePage {
	public static WebDriver driver;
	public LoginClickCloseButton login;

	public WebDriver browser() throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\resources.properties");
		pro.load(fis);
		String browserName = pro.getProperty("browser");
		if (browserName.equalsIgnoreCase("chromedriver")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefoxdriver")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edgedriver")) {

			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		driver = browser();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("User.dir") + "\\reportsFlipkartlist" + testCaseName + ".png");
		FileUtils.copyDirectory(source, destination);
		return System.getProperty("User.dir") + "//reports//" + testCaseName + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public LoginClickCloseButton launchingUrl() throws IOException {
		driver = browser();
		login = new LoginClickCloseButton(driver);
		login.goTo();
		return login;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws IOException {
		driver.quit();
	}

}
