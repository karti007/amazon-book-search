package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults {
	public WebDriver driver;

	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}	
	
	By products = By.cssSelector("[class='a-price']");
	By wholeNumber = By.cssSelector("[class*='a-price-whole']");
	By decimalNumber = By.cssSelector("[class*='a-price-fraction']");
	
	public List<WebElement> getProducts() {
		return driver.findElements(products);
	}
	public By getWholeNumber() {
		return wholeNumber;
	}	
	public By getDecimalNumber() {
		return decimalNumber;
	}
	public String getPriceForFirstProduct() {
		List<WebElement> products = getProducts();
		int howManyProducts = 1;
		int count = 1;
		String price = null;

		for (WebElement product : products) {
			while (count <= howManyProducts) {
				String whole = product.findElement(getWholeNumber()).getText();
				String decimal = product.findElement(getDecimalNumber()).getText();
				price = '$' + whole + '.' + decimal;
				product.click();
				break;
			}
			if (price != null) {
				break;
			}
		}
		return price;
	}	
}
