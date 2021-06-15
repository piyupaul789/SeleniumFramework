package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import WebPages.GoogleSearchPage;

public class Test2_googleSearchUsingPOM{
	
	private static WebDriver driver =null;

	public static void main(String[] args) {
		
		googlesearch();
		
	}
	
	 public static void googlesearch() {
		
       String projectPath = System.getProperty("user.dir");
    		   
		System.out.println(projectPath);
       
		System.setProperty("webdriver.chrome.driver",  projectPath + "\\Drivers\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		GoogleSearchPage.texbox_search(driver).sendKeys("Automation step by step");

		//GoogleSearchPage.button_search(driver).click();
		
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		driver.close();
		
		System.out.println("Test completed successfully");
		
	}

}
