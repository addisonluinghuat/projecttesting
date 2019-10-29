package seleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {

	public static void main(String[] args) {

		// Change the path based on your file path
		// System.setProperty("webdriver.gecko.driver","Path of geckodriver.exe")

		System.setProperty("webdriver.chrome.driver",
				"C://Users//addison.lu//Downloads//chromedriver_win32 (1)//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.yahoo.com");

		System.out
				.println("Selenium Webdriver Script in Firefox browser using Gecko Driver | Software Testing Material");

		// driver.close();

	}

}
