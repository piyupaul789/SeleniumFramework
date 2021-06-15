package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WebPages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {

	public static WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	// import org.junit.jupiter.api.Test;
	// DO NOT USE junit-jupiter-api DEPENDENCY IN MAVEN
	/* Above jupiter jUnit import causes below error */
	/*
	 * java.lang.NoSuchMethodError:
	 * org.testng.remote.AbstractRemoteTestNG.addListener(Lorg/testng/ISuiteListener
	 * ;)V
	 */
	@Test
	public static void googlesearch() {
		driver.get("http://google.com/");
		GoogleSearchPage.texbox_search(driver).sendKeys("Automation step by step");
		// GoogleSearchPage.button_search(driver).click();
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		GoogleSearchPage.selectFromSearchDropDown(driver, " - raghav pal").click();

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}

}
