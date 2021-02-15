package com.qa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShoppingWebsiteTest {
	 private WebDriver driver;

	    @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));

	    }

	    @Test
	    public void test() throws InterruptedException {
	        driver.get("http://automationpractice.com/index.php");
	        WebElement targ = driver.findElement(By.id("search_query_top"));
	        targ.sendKeys("dress\n");
	       assertEquals("\"DRESS\"", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/h1/span[1]")).getText());
	    }

	    @After
	    public void tearDown() {
	        driver.close();
	    }

	    public static ChromeOptions chromeCfg() {
	    	 Map<String, Object> prefs = new HashMap<String, Object>();
	    	 ChromeOptions cOptions = new ChromeOptions();
	    	  
	    	 // Settings
	    	 prefs.put("profile.default_content_setting_values.cookies", 2);
	    	 prefs.put("network.cookie.cookieBehavior", 2);
	    	 prefs.put("profile.block_third_party_cookies", true);

	    	 // Create ChromeOptions to disable Cookies pop-up
	    	 cOptions.setExperimentalOption("prefs", prefs);

	    	 return cOptions;
	    	 }
}

