
import java.io.PrintStream;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstWebpage {
	
	static PrintStream printer, errorPrinter;
	
	static {
		printer = System.out;
		errorPrinter = System.err;
	}

	public static void main(String[] args) throws InterruptedException {

		// contains(@attribute, "String")
		// contains(method(), "String")

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("http://192.168.0.103:5500/");
		driver.navigate().to("http://192.168.0.103:5500/");

		// Dimension d = new Dimension(300, 1080);
		// driver.manage().window().setSize(d);
		// Thread.sleep(10000);
		//
		// driver.manage().window().maximize();
		//
		// Point p = new Point(0, 3000);
		// driver.manage().window().setPosition(p);
		// Thread.sleep(10000);

		driver.manage().window().maximize();

		Assert.assertEquals(driver.findElement(By.xpath(".//h1")).getText(), "First webpage");

		// reading title name of First webpage
		String a = driver.getWindowHandle();
		// verifying header
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//header[contains(text(), 'This is header. Header contains navigational links.')]"))
				.getText().contains("This is header. Header contains navigational links"));
		printer.println("message verified");
		// clicked on link
		driver.findElement(By.xpath(".//a[@href='https://www.w3schools.com/html/']")).click();
		// window handles command

		Set<String> handle = driver.getWindowHandles();
		for (String x : handle) {
			driver.switchTo().window(x);
		}
		printer.println(driver.getTitle());

		driver.switchTo().window(a);
		printer.println(driver.getTitle());

		Assert.assertEquals(driver.findElement(By.xpath(".//main[contains (text(), 'This is main')]")).getText()
				.contains("This is main"), true);

		Assert.assertEquals(driver.findElement(By.xpath(".//article[contains (text(), 'This is article')]")).getText()
				.contains("This is article"), true);

		printer
				.println(driver.findElement(By.xpath(".//header[contains(text(), 'This section header')]")).getText());

		Assert.assertTrue(driver.findElement(By.xpath(".//header[contains(text(), 'This section header')]")).getText()
				.contains("This section header"));

		Assert.assertEquals(driver.findElement(By.xpath(
				".//aside[contains(text(), 'This is aside tag which is not a core content of the website. Example is any ads.')]"))
				.getText(), "This is aside tag which is not a core content of the website. Example is any ads.");

		Assert.assertEquals(driver.findElement(By.xpath(".//footer")).getText(), "This is footer");

		printer.println("first half verified successfully");

		Assert.assertEquals(driver.findElement(By.xpath(".//h2")).getText(), "HTML coding is best");

		Assert.assertTrue(driver.findElement(By.xpath(".//p[contains(text(), 'This is the ')][1]")).getText()
				.contains("This is the "));

		Assert.assertTrue(driver.findElement(By.xpath(".//p[contains(text(), 'This is the ')][2]")).getText()
				.contains("This is the "));

		Assert.assertTrue(driver.findElement(By.xpath(".//p[contains(text(), 'Chemical formula of water is H')]"))
				.getText().contains("Chemical formula of water is H"));

		Assert.assertTrue(driver.findElement(By.xpath(".//p[contains(text(), 'What is the formula for (a + b )')]"))
				.getText().contains("What is the formula for (a + b )"));

		Assert.assertTrue(driver.findElement(By.xpath(".//p[contains(text(), 'This is blue CSS')]")).getText()
				.contains("This is blue CSS"));

		Assert.assertTrue(driver.findElement(By.xpath(".//p[contains(text(), 'This is red CSS')]")).getText()
				.contains("This is red CSS"));

		Assert.assertTrue(driver.findElement(By.xpath(".//i[contains(text(), 'Links')]")).getText().contains("Links"));

		driver.findElement(By.xpath(".//a[@href=\"https://www.google.com/\"]")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String y : handles) {
			driver.switchTo().window(y);
		}
		printer.println(driver.getTitle());

		driver.switchTo().window(a);
		printer.println(driver.getTitle());

		driver.findElement(By.xpath(".//a[@href='Login.html']")).click();
		Assert.assertEquals(driver.findElement(By.xpath(".//h1")).getText(), "Login webpage");
		driver.findElement(By.name("name")).sendKeys("Piyu");
		driver.findElement(By.xpath(".//input[@placeholder='Enter username']")).sendKeys("Piyu123");
		driver.findElement(By.xpath(".//input[@type='password']")).sendKeys("Piyu123");
		driver.findElement(By.xpath(".//textarea[@type='text']")).sendKeys("Piyu123");

		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath(
				".//a[(@class='ui-state-default' or @class='ui-state-default ui-state-highlight') and text()='30']"))
				.click();

		driver.findElement(By.xpath(".//input[@type='email']")).sendKeys("Piyu123@gmail.com");

		WebElement rangeElem = driver.findElement(By.xpath(".//input[@type='range']"));

		rangeElem.click();

		Actions builder = new Actions(driver);
		builder.dragAndDropBy(rangeElem, 0, 100);

		driver.findElement(By.xpath(".//input[@name='chekbx'][1]")).click();
		driver.findElement(By.xpath(".//input[@name='rdiobtn'][2]")).click();
		// Assert.assertEquals(driver.findElement(By.xpath(".//input[@type=\"file\"]")).getText(),
		// "file");

//		printer.println(driver.findElement(By.id("iframe_1")).getAttribute("src"));
//		WebDriver newDriver = driver.switchTo().frame("iframe_1");
//		printer.println(newDriver.getTitle());
//
//		driver.navigate().back();
//		printer.println(driver.getTitle());
		
		driver.switchTo().frame("iframeid");
		printer.println("we are switch to the iframe");
		driver.findElement(By.xpath(".//span[@style=\"font-size: 28px; margin-left: 10px;\"]")).click();
		printer.println("We are done");

		driver.findElement(By.xpath(".//span[@class=\"card-title center\"]")).click();
		printer.println("Video's That Won't Put You To Sleep - displayed");
		
		driver.findElement(By.xpath(".//img[@class=\"card-image\"]")).click();
		printer.println("Video's That Won't Put You To Sleep - displayed");
		
		driver.findElement(By.xpath(".//span[contains(text(), 'Learn For Free - With High Quality Content')]")).click();
		printer.println("Learn For Free - With High Quality Content - displayed");
	}
}