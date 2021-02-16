package com.qa.DemoWebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebsiteAddUserPage {
	
	   public final static String URL = "http://thedemosite.co.uk/addauser.php";

	    private WebDriver driver;

	    WebDriver getDriver() {
			return driver;
		}


		void setDriver(WebDriver driver) {
			this.driver = driver;
		}


		public DemoWebsiteAddUserPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
		
     // UserName to add
	    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	    private WebElement addUsernameInput;

	 // Password to add
	    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	    private WebElement addPasswordInput;
	    
	 // The save login button
	    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	    private WebElement saveLogin;


	   //Add user
	    public void login(String username, String password) {
	        addUsernameInput.sendKeys(username);
	        addPasswordInput.sendKeys(password);
	        saveLogin.click();
	    }



}
