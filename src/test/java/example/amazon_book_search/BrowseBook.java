package example.amazon_book_search;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchResults;

public class BrowseBook extends Base {

	String price = null;
	int howManyProducts = 0;
	int count = 0;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(getURL());
		driver.manage().window().maximize();
	}

	@Test
	public void searchForBook() {
		HomePage hp = new HomePage(driver);
		hp.sendDataSearchBox("qa testing for beginners");
		hp.clickSearchButton();
	}

	@Test
	public void searchResultsProductPrice() {
		SearchResults sr = new SearchResults(driver);
		price = sr.getPriceForFirstProduct();
	}

	@Test
	public void verifyProductPagePrice() {		
		ProductPage pp = new ProductPage(driver);
		Assert.assertEquals(pp.getBuyPrice(), price);
		pp.addToCart();
	}

	@Test(dependsOnMethods= {"verifyProductPagePrice"})
	public void verifyCartPagePrice() {
		CartPage cp = new CartPage(driver);
		Assert.assertEquals(cp.getCartPrice(), price);
		cp.proceedToCheckOut();
	}

	@Test(dependsOnMethods= {"verifyCartPagePrice"})
	public void verifyCheckoutPagePrice() {
		CheckOutPage cop = new CheckOutPage(driver);
		Assert.assertEquals(cop.getCheckOutPrice(), price);
	}

	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}
