package com.qa.DemoWebsite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebsiteLandingPage {
	
	public final static String URL = "http://thedemosite.co.uk/index.php";

    private WebDriver driver;

    public DemoWebsiteLandingPage(WebDriver driver) {
        this.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	// Link to the Add User page
    @FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
    private WebElement toAddUser;

    // Link to Login Page
    @FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
    private WebElement toLogin;
    
    public void goToAddUser() {
    	toAddUser.click();
    }
    
    public void goToLogin() {
    	toLogin.click();
    }
}
