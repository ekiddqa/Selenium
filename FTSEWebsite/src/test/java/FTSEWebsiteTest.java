import static org.junit.Assert.assertEquals;

import java.util.HashMap;
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

public class FTSEWebsiteTest {
	 private WebDriver driver;

	    @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));

	    }

		/*
		 * @Test public void test() throws InterruptedException {
		 * driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/");
		 * Thread.sleep(10000); WebElement targ = driver.findElement(By.
		 * cssSelector("#content_div_40583 > ul > li.one-line.current > a"));
		 * assertEquals("\"IAG\"", driver.findElement(By.xpath(
		 * "/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr[1]/td[1]"
		 * )).getText()); }
		 */
	    
	    @Test
	    public void riserTest() throws InterruptedException {
	    	driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers");
	    	Thread.sleep(10000);
	    	WebElement targ = driver.findElement(By.xpath("//*[@id=\"ls-row-WTB-L\"]"));
	    	assertEquals("", driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr[1]/td[5]/span").))
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
