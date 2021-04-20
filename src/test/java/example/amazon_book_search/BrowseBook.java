package example.amazon_book_search;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class BrowseBook extends Base {

	String price = null;
	int howManyProducts = 0;
	int count = 0;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	}

	@Test
	public void bookSearch() throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		lp.getSearchBox().sendKeys("qa testing for beginners");
		lp.getSearchButton().click();

		List<WebElement> products = lp.getProducts();
		howManyProducts = 1;
		count = 1;

		for (WebElement product : products) {
			while (count <= howManyProducts) {
				String whole = product.findElement(lp.getWhole()).getText();
				String decimal = product.findElement(lp.getDecimal()).getText();
				price = '$' + whole + '.' + decimal;
				product.click();
				break;
			}
			if (price != null) {
				break;
			}
		}
		Assert.assertEquals(lp.getBuyPrice().getText(), price);

		lp.getAddToCart().click();
		Assert.assertEquals(lp.getSubCart().getText(), price);

		lp.getProceedToCheckOut().click();
		Assert.assertEquals(lp.getCheckOutPrice().getText(), price);
	}

	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}
