package ui_tests;

import pages.Common;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.TodaysDealsPage;

public class AmazonCheckoutScript extends Common {
	
	public static void main(String[] args) throws InterruptedException {
		getData();
		LOGGER.info("*******************************************");
		LOGGER.info(" ");
		LOGGER.info("Executing Scenario: " + "Amazon Product Checkout");
		LOGGER.info(" ");
		LOGGER.info("*******************************************");
		LOGGER.info("Product: " + projectProp.get("Name"));
		LOGGER.info("Author: " + projectProp.get("Author"));
		connect();
		launchAppUrl();
		HomePage hp = new HomePage();
		hp.clickTodaysDeals();		
		TodaysDealsPage tdp=new TodaysDealsPage();
		tdp.clickWatches();		
		scrollDown(0, 850);
		tdp.clickSortByOption();
		tdp.clickDescendingOption();
		tdp.clickFirstFootwearProduct();
		tdp.clickFirstSubFootwearProduct();
		tdp.getProductDetails();
		tdp.clickAddToCart();
		ShoppingCartPage scp=new ShoppingCartPage();
		scp.clickCartIcon();
		scp.validateProductDetails();
		tearDown();
	}

}
