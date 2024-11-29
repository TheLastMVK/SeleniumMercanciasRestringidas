package com.mr.steps;

import com.mr.pages.HomePage;
import com.mr.pages.IpenTupaPage;
import com.mr.pages.LoginPage;
import com.mr.pages.SolicitudPage;
import com.mr.utils.Base;
import com.mr.utils.Hooks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


public class LoginUserStep extends Base{
	
	protected LoginPage loginPage= new LoginPage();
	protected HomePage homePage= new HomePage();
	protected SolicitudPage solicitudPage= new SolicitudPage();
	protected IpenTupaPage ipenTupaPage= new IpenTupaPage();
	protected IpenTupaPage profilePage= new IpenTupaPage();
	protected Hooks hooks;
	
	public LoginUserStep(Hooks hooks) {
		this.hooks = hooks;
	}
	
	/***************ESCENARIO 1****************/	
	@Given("page of login MR2 is all ready")
	public void page_of_login_MR2_is_all_ready() {
		driver.get(MR2_URL);
	}
	
	@When("user enters credentials {string} and {string}")
	public void user_enters_credentials_and(String email, String password) {
		loginPage.fillOutForm(email, password);
		loginPage.clicOnLogin();
	}
	
	@Then("user can see MR2 page")
	public void user_can_see_mr2_page() {
		homePage.waitForElementHomePage();		
	}		

}
