import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		// driver.findElement(By.id("searchInput")).sendKeys("India");
		
		WebElement textbox = driver.findElement(By.id("searchInput"));
		
		//List<WebElements> listOfInputElemetns = driver.findElements(By.xpath("//input"));
		//int count = listOfInputElemetns.size();
		//System.out.println("count of input elements :" +count);
		
		textbox.sendKeys("India");
		
		Thread.sleep(3000);	
		driver.close();
	}
}
