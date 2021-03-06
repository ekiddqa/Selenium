package com.qa.DemoWebsite;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.DemoWebsite.pages.DemoWebsiteAddUserPage;
import com.qa.DemoWebsite.pages.DemoWebsiteLandingPage;
import com.qa.DemoWebsite.pages.DemoWebsiteLoginPage;

public class DemoWebsite {
	 private WebDriver driver;

	    @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));

	    }

	    @Test
	    public void testGoToAddUser() throws InterruptedException {
	        driver.get(DemoWebsiteLandingPage.URL);
	        DemoWebsiteLandingPage landingPage = new DemoWebsiteLandingPage(driver);
	        landingPage.goToAddUser();
	        assertEquals("http://thedemosite.co.uk/addauser.php", driver.getCurrentUrl());
	        //WebElement addUser = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
	        //addUser.click();
	    }
	        
	     @Test
	     public void testAddUser() throws InterruptedException {
	        driver.get(DemoWebsiteAddUserPage.URL);
		    DemoWebsiteAddUserPage addUserPage = new DemoWebsiteAddUserPage(driver);
		    addUserPage.login("guest", "guest");
		    assertEquals("The username: guest\nThe password: guest",driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")).getText());
	        //WebElement createTestUN = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
	        //createTestUN.sendKeys("guest\n");
	       // WebElement createTestPW = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
	        //createTestPW.sendKeys("guest\n");
	       // WebElement saveCredits = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
	       // saveCredits.click();
	     }
		  @Test
		  public void testGoToLoginFromLanding() throws InterruptedException {
			  driver.get(DemoWebsiteLandingPage.URL);
			  DemoWebsiteLandingPage landingPage = new DemoWebsiteLandingPage(driver);
			  landingPage.goToLogin();
			  assertEquals("http://thedemosite.co.uk/login.php", driver.getCurrentUrl());
		  }
		  
		  @Test
		  public void testLogin() throws InterruptedException {
			  driver.get(DemoWebsiteLoginPage.URL);
			  DemoWebsiteAddUserPage loginPage = new DemoWebsiteAddUserPage(driver);
			  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			  loginPage.login("guest", "guest");
			  assertEquals("**Successful Login**", driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
		  }
		  
	        //WebElement login = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
	        //login.click();
	        //WebElement loginUN = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
	        //loginUN.sendKeys("guest\n");
	        //WebElement loginPW = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
	        //loginPW.sendKeys("guest\n");
	        //WebElement loginBtn = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
	        //loginBtn.click();

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
