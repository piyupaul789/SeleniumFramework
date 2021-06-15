package Test;

import java.awt.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationExamples {

	private WebDriver driver;
	private String URL1 = "http://www.yahoo.com";
	private String URL2 = "http://www.amazon.com";

	@BeforeClass
	public void setupTest() {
		/* System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Dimension dim = new Dimension(1366, 256);
		/*driver.manage().window().setSize(dim);*/
	}

	@Test
	public void T01_getURLExample() {
		driver.get(URL1);
		Assert.assertEquals(driver.getTitle(), "Yahoo");
	}

	@Test
	public void T02_getURLExample() {
		driver.navigate().to(URL2);
		Assert.assertEquals(driver.getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}

	@Test
	// Back - Forward - Refresh Example
	public void T03_backForwardRefreshExample() {
		// Go to www.yahoo.com
		driver.navigate().to(URL1);
		// Check title is correct
		Assert.assertEquals(driver.getTitle(), "Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment");

		// Go to www.amazon.com
		driver.navigate().to(URL2);
		// Check title is correct
		Assert.assertEquals(driver.getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

		// ***Navigate Back***
		driver.navigate().back();
		// Check title is correct
		Assert.assertEquals(driver.getTitle(), "Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment");

		// ***Navigate Forward***
		driver.navigate().forward();
		// Check title is correct
		Assert.assertEquals(driver.getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

		// ***Refresh The Page***
		driver.navigate().refresh();
		Assert.assertEquals(driver.getTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}

}
