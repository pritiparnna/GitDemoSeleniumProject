package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.FacebookLoginPage;

public class FacebookLoginSteps {
	private FacebookLoginPage facebookLoginPage;

    @Given("I am on the Facebook login page")
    public void i_am_on_the_facebook_login_page() {
        facebookLoginPage = new FacebookLoginPage(Hooks.driver);
        facebookLoginPage.open();
    }

    @When("I enter Facebook username {string}")
    public void i_enter_facebook_username(String email) {
        facebookLoginPage.enterEmail(email);
    }

    @When("I enter Facebook password {string}")
    public void i_enter_facebook_password(String password) {
        facebookLoginPage.enterPassword(password);
    }

    @When("I click on the Facebook Login button")
    public void i_click_on_the_facebook_login_button() throws InterruptedException {
        facebookLoginPage.clickLogin();
        Thread.sleep(3000);
    }

    @Then("I should be logged in to Facebook successfully")
    public void i_should_be_logged_in_to_facebook_successfully() throws InterruptedException {
        // small wait to allow redirect (replace with proper explicit wait in real project)
        Thread.sleep(3000);
        Assert.assertTrue( "Expected user to be logged in, but login seems to have failed.",facebookLoginPage.isLoggedIn());
        
    }

}
