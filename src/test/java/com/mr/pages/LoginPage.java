package com.mr.pages;

import org.openqa.selenium.By;

import com.mr.utils.Base;

public class LoginPage extends Base{
	
	/* Web elements locators*/	
    By inputTxtEmail = By.id("user");
    By inputTxtPassword = By.id("password-field");
    By btnSubmitLogin = By.id("btn-login");
    
	/* Metodos*/	    
    public void fillOutForm(String email, String password) {
    	
    	driver.findElement(inputTxtEmail).clear();
    	driver.findElement(inputTxtPassword).clear();
    	
    	driver.findElement(inputTxtEmail).sendKeys(email);
    	driver.findElement(inputTxtPassword).sendKeys(password);   	
    }  
        
    public void clicOnLogin() {
    	driver.findElement(btnSubmitLogin).click();  	    	
    }

}
