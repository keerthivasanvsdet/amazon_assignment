package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

public class ShoppingCartPage {
	
	HashMap<String,String> scpMap=new HashMap<String,String>();
	
	public ShoppingCartPage() {
		
		int count1=Common.driver.findElements(By.xpath(Common.locatorsProp.get("AddedToCartText1").toString())).size();
		int count2=Common.driver.findElements(By.xpath(Common.locatorsProp.get("AddedToCartText2").toString())).size();
		if(count1 == 1 || count2 == 1) {
			Common.LOGGER.info("Shopping Cart Page is Displayed");
		}else {
			Common.LOGGER.info("Shopping Cart Page isn't Displayed");
		}
	}
	
	public void clickCartIcon() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("GoToCartOption").toString())).click();
		Common.LOGGER.info("Clicked Shopping Cart Icon in Cart Page");
	}

	public void validateProductDetails() {
		String productName=Common.driver.findElement(By.xpath(Common.locatorsProp.get("ChkPageProductName").toString())).getText();
		Common.LOGGER.info("Product Name: "+productName);		
		String productPrice=Common.driver.findElement(By.xpath(Common.locatorsProp.get("ChkPageProductPrice").toString())).getText();
		String formattedPrice=productPrice.replace("?", "").replace(",", "").replace(".00", "").trim();
		Common.LOGGER.info("Product Price: "+formattedPrice);
		String productQty=Common.driver.findElement(By.xpath(Common.locatorsProp.get("ChkPageQuantity").toString())).getText();
		Common.LOGGER.info("Product Quantity: "+productQty);
		scpMap.put("Name", productName);
		scpMap.put("Price", formattedPrice);
		scpMap.put("Quantity", productQty);
		Common.LOGGER.info("Product Details in Cart Page: "+scpMap);
		
		// Comparing Both Hashmaps for validation
		Common.LOGGER.info("Does Product Details Match from ProductDetail Page against ShoppingCart Page:" +TodaysDealsPage.tdpMap.equals(scpMap));
	}
}
