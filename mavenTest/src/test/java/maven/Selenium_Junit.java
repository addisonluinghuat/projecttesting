package maven;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Junit {
	static WebDriver driver;

	@BeforeClass
	public static void BrowserOpen() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//addison.lu//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void Register_User() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://accounts.lambdatest.com/register");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='organization_name']")).sendKeys("LambdaTest");
		System.out.println("organiztion input textbox");
		driver.findElement(By.xpath("//button[text()='Free Signup']")).click();
		// String url = driver.getCurrentUrl();

		// assertEquals("fail- unable to register", url,
		// "https://accounts.lambdatest.com/user/email-verification");
	}

	@AfterClass
	public static void BrowserClose() {
		// driver.quit();
	}
}