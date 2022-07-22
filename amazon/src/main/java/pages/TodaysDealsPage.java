package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

public class TodaysDealsPage {
	
	static HashMap<String, String> tdpMap=new HashMap<String, String>();
	
	public TodaysDealsPage() {
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("TodaysDealCarousel").toString())).isDisplayed()) {
			Common.LOGGER.info("Today's Deals Page is Displayed");
		}else {
			Common.LOGGER.info("Today's Deals Page isn't Displayed");
		}
	}
	
	public void clickWatches() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("WatchesOption").toString())).click();
		Common.LOGGER.info("Clicked Watches Option in Today's Deals Page");
	}
	
	public void clickSortByOption() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("SortByOption").toString())).click();
		Common.LOGGER.info("Clicked SortBy Option in Today's Deals Page");
	}
	
	public void clickDescendingOption() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("DescendingOption").toString())).click();
		Common.LOGGER.info("Clicked Descending Option in Today's Deals Page");
	}
		
	public void clickFirstFootwearProduct() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("FirstFootwearProduct").toString())).click();
		Common.LOGGER.info("Clicked FirstFootwearProduct in Today's Deals Page");
	}

	public void clickFirstSubFootwearProduct() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("FirstSubFootwearProduct").toString())).click();
		Common.LOGGER.info("Clicked FirstSubFootwearProduct in Today's Deals Page");
	}
	
	public void getProductDetails() throws InterruptedException {
		String productName=Common.driver.findElement(By.xpath(Common.locatorsProp.get("PdPageProductName").toString())).getText();
		Common.LOGGER.info("Product Name: "+productName);
		String star=Common.driver.findElement(By.xpath(Common.locatorsProp.get("PdPageStarRating").toString())).getAttribute("title");
		Common.LOGGER.info("Star Rating: "+star);
		if(productName.contains("Shoes")){
			Common.driver.findElement(By.xpath(Common.locatorsProp.get("PdPageSelectSizeDropDown").toString())).click();
			Common.driver.findElement(By.xpath(Common.locatorsProp.get("PdPageSizeDropDown").toString())).click();
			Thread.sleep(5000L);
		}
		String productPrice=Common.driver.findElement(By.xpath(Common.locatorsProp.get("PdPageProductPrice").toString())).getText();
		String formattedPrice=productPrice.replace(",", "").replace("?", "").replace(".00", "").substring(1);
		Common.LOGGER.info("Product Price: "+formattedPrice);
		String productAbout=Common.driver.findElement(By.xpath(Common.locatorsProp.get("PdPageProductAbout").toString())).getText();
		Common.LOGGER.info("Product About: "+productAbout);
		String productQty=Common.driver.findElement(By.xpath(Common.locatorsProp.get("PdPageQuantity").toString())).getText();
		Common.LOGGER.info("Product Quantity: "+productQty);		
		tdpMap.put("Name", productName);
		tdpMap.put("Price", formattedPrice);
		tdpMap.put("Quantity", productQty);
		Common.LOGGER.info("Product Details in Product Detail Page: "+tdpMap);
	}
	
	public void clickAddToCart() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("AddToCart").toString())).click();
		Common.LOGGER.info("Clicked AddToCart Button in Today's Deals Page");
	}
}
