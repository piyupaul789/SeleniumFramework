import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApiTest {

	public static void main(String Args[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.0.105:8000/api/");
		driver.findElement(By.xpath(".//span[text()='http://192.168.0.105:8000/api/employees/']")).click();
		assertEquals(driver.findElement(By.xpath(".//h1[text()='EmployeeApiList']")).getText(), "Employee Api List");

		// assertEquals(driver.findElement(By.xpath(".//span[text()='This site can’t be
		// reached']")).getText(),"This site can’t be reached");

		// driver.findElement(By.id("details-button")).click();

		// driver.findElement(By.xpath(".//button[@id='reload-button']")).click();
		// Thread.sleep(10000);

	}

}
