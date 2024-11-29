package com.mr.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mr.utils.Base;

public class HomePage extends Base{
	
	/* Web elements locators*/	
	By btnIniciarSolicitud= By.className("btn-danger");
    
	/* Metodos*/	    
    
    public void clicIniciarSolicitud(){ 
    	driver.findElement(btnIniciarSolicitud).click();    	
    }
    
    public void waitForElementHomePage(){ 
    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT))
    	.until(ExpectedConditions.elementToBeClickable(btnIniciarSolicitud));	 	
    }              

    public void validarTituloHome(){ 
    	String expected_title = "Mercancías Restringidas";		
    	String real_title = driver.getTitle();				
    	Assert.assertEquals(real_title, expected_title, "Comparacion de titulos");	  	
    }

    

}
