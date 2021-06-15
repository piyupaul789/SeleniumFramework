package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsExample {

	private String URL1 = "https://www.wikipedia.org/";
	private String URL2 = "https://www.wiktionary.org/";
	WebDriver driver;

	@BeforeClass
	void setupFindElements() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	void T01() {
		driver.get(URL1);
		WebElement TextBox = driver.findElement(By.id("searchInput"));
		TextBox.sendKeys("india");
		TextBox.click();
		assertEquals("Software Test Academy", driver.getTitle(), "Title check failed!");
	}

	@Test
	public void T01_getTitle() {
		assertTrue(driver.getTitle().equals("https://www.wikipedia.org/"));
	}

	@Test
	void T02() {
		driver.navigate().to(URL2);
	}

	@Test
	public void selectFromDropdown() {
		Select drpdwn = new Select(driver.findElement(By.xpath(".//select[@name='birthday_day']")));
		drpdwn.selectByValue("3");
	}

	@AfterClass
	void quitDriver() {
		driver.close();
	}

}
