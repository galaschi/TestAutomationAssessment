package teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Driver {

	public static WebDriver driver;

	@BeforeTest
	public static void IniciarDriver() {
		System.setProperty("webdriver.chrome.driver",
				"../TestAutomationAssessment/src/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterTest
	public static void FecharDriver() {
		driver.close();
		driver.quit();
	}

}
