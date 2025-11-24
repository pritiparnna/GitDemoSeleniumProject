package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPage {
	
	 private WebDriver driver;

	    // Locators (current FB may change; adjust if needed)
	    private By emailField    = By.xpath("//input[@name='email']");
	    private By passwordField = By.xpath("//input[@name='pass']");
	    private By loginButton   = By.xpath("//span[text()='Log in']");

	    public FacebookLoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void open() {
	        driver.get("https://www.facebook.com/");
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).clear();
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).clear();
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() throws InterruptedException {
	        driver.findElement(loginButton).click();
	        Thread.sleep(5000);
	    }

	    public boolean isLoggedIn() {
	        // Very basic check: URL changed OR some element visible after login
	        String currentUrl = driver.getCurrentUrl();
	        return currentUrl.contains("facebook.com") && !currentUrl.contains("login");
	    }

}
