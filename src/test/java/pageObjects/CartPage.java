package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	public WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}	
	
	By cartPrice = By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");
	By proceedToCheckOut = By.id("hlb-ptc-btn");
	
	public String getCartPrice() {
		return driver.findElement(cartPrice).getText();
	}	
	public void proceedToCheckOut() {
		driver.findElement(proceedToCheckOut).click();;
	}	
}
