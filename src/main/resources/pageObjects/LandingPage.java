package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}	
	By searchBox = By.id("twotabsearchtextbox");
	By searchButton = By.id("nav-search-submit-button");
	By products = By.cssSelector("[class='a-price']");
	By whole = By.cssSelector("[class*='a-price-whole']");
	By decimal = By.cssSelector("[class*='a-price-fraction']");
	By buyPrice = By.id("newBuyBoxPrice");
	By addToCart = By.id("submit.add-to-cart");
	By subCart = By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");
	By proceedToCheckOut = By.id("hlb-ptc-btn");
	By checkOutPrice = By.className("a-color-price");
	
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}	
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}	
	public List<WebElement> getProducts() {
		return driver.findElements(products);
	}
	public By getWhole() {
		return whole;
	}	
	public By getDecimal() {
		return decimal;
	}	
	public WebElement getBuyPrice() {
		return driver.findElement(buyPrice);
	}	
	public WebElement getAddToCart() {
		return driver.findElement(addToCart);
	}	
	public WebElement getSubCart() {
		return driver.findElement(subCart);
	}	
	public WebElement getProceedToCheckOut() {
		return driver.findElement(proceedToCheckOut);
	}	
	public WebElement getCheckOutPrice() {
		return driver.findElement(checkOutPrice);
	}	
}
