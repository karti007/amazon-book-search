package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}	
	
	By searchBox = By.id("twotabsearchtextbox");
	By searchButton = By.id("nav-search-submit-button");
	
	public void sendDataSearchBox(String searchMessage) {
		driver.findElement(searchBox).sendKeys(searchMessage);
	}	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}	
}
