package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement texbox_search(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		return element;
	}

	public static WebElement button_search(WebDriver driver) {
		element = driver.findElement(By.xpath("(.//input[@name='btnK'])[2]"));
		return element;
	}

	public static WebElement selectFromSearchDropDown(WebDriver driver, String dropDownVal) {
		elements = driver.findElements(By.xpath(".//div[@role='option']"));
		
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().contains(dropDownVal)) {
				element = elements.get(i);
				break;
			}
		}
		return element;
	}
}
