package pages;

import org.openqa.selenium.By;

public class HomePage {
	
	public HomePage() {
		
		if(Common.driver.findElement(By.xpath(Common.locatorsProp.get("HomePageCarousel").toString())).isDisplayed()) {
			Common.LOGGER.info("Home Page is Displayed");
		}else {
			Common.LOGGER.info("Home Page isn't Displayed");
		}
	}
	
	public void clickTodaysDeals() {
		Common.driver.findElement(By.xpath(Common.locatorsProp.get("TodaysDealsMenu").toString())).click();
		Common.LOGGER.info("Clicked Today's Deals in Menu");
	}

}
