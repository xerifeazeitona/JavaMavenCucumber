package com.cucumber.javaMavenCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class US06StepDefinitions {
	
	WebDriver driver;
	int loginStatus;

	@Given("^I am in the web app$")
	public void shouldNavigateToSignedOutIndex() throws Throwable {
		driver = new FirefoxDriver();
		driver.navigate().to("file:///E:/Test/sprint2_index_signed_out.html");
	}

	@When("^The sign in option is ([^\"]*)$")
	public void checkLoginStatus(String status) throws Throwable {
		if (status.equals("enabled")) {
			driver.navigate().to("file:///E:/Test/sprint2_index_signed_out.html");
			loginStatus = 1;
        } else if (status.equals("disabled")) {
    		driver.navigate().to("file:///E:/Test/sprint2_index_signed_in.html");
			loginStatus = 0;
        } else {
            System.err.println("The status " + status + " doesn't exist.");
        }

	}	
	
	@Then("^I click on menu ([^\"]*)$")
	public void shouldClickOnMenuLink(String link) throws Throwable {
		driver.findElement(By.id(link.toLowerCase())).click();
	}

	@Then("^I check if I am on that ([^\"]*) page confirming my expectations according to my login status$")
	public void checkCurrentPage(String title) throws Throwable {
		Assert.assertTrue("Not on " + title + " page", driver.getTitle().equals(title));
		if (loginStatus == 1) {
			Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("now"));
		} else if (loginStatus == 0) {
    		Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("username"));
		} else {
            System.err.println("Invalid login status");			
		}
		driver.close();
	}
	
}