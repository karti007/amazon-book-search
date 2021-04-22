package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}	
	
	By checkOutPrice = By.className("a-color-price");
	
	public String getCheckOutPrice() {
		return driver.findElement(checkOutPrice).getText();
	}	
}
