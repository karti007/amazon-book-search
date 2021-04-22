package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	public WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}	
	
	By buyPrice = By.id("newBuyBoxPrice");
	By addToCart = By.id("submit.add-to-cart");
	
	public String getBuyPrice() {
		return driver.findElement(buyPrice).getText();
	}	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
