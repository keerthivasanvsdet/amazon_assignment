package pages;

import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Common {

	public static WebDriver driver;
	public static JSONObject projectProp;
	public static JSONObject locatorsProp;
	public static Logger LOGGER = LogManager.getLogger(Common.class);

	// Get JSON data
	public static JSONObject getData() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("config.json"));
			projectProp = (JSONObject) obj;

			Object object = parser.parse(new FileReader("locators.json"));
			locatorsProp = (JSONObject) object;
			LOGGER.info("Read all data from config.json & locators.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectProp;
	}

	// Get JSON listdata as a Hash
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap getListData(String listName) {
		JSONParser parser = new JSONParser();		
		HashMap map = new HashMap();
		try {
			Object obj = parser.parse(new FileReader("config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray jsonList = (JSONArray) jsonObject.get(listName);
			Iterator<JSONObject> iterator = jsonList.iterator();
			while (iterator.hasNext()) {
				String data=iterator.next().toString();
				LOGGER.info(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// Connect Chrome Browser
	public static void connect() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		LOGGER.info("Launched Chrome Driver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LOGGER.info("Have set implicit timeout of 10 Seconds");
	}

	// Launch App URL
	public static void launchAppUrl() {
		driver.manage().window().maximize();
		driver.get(projectProp.get("URL").toString());
		LOGGER.info("Loading the Page: "+projectProp.get("URL").toString());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	// closes the App
	public static void tearDown() {		
		driver.quit();
		LOGGER.info("Closed the Chrome Browser");
	}

	// Applies Sleep
	public static void waitSleep(long millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Scroll down based on Pixel
	public static void scrollDown(int start, int end) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+start+","+end+")", "");
		LOGGER.info("Page Scrolled Down By (0,850)");
	}

}
