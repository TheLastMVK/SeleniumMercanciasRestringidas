package com.mr.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mr.utils.Base;

public class SolicitudPage extends Base{
	
	/* Web elements locators*/	
	
	By optEntityIpen= By.xpath("/html/body/app-root/div/div/div[2]/div/div/app-nueva-solicitud/div/div[6]/div[2]/app-ui-card/div/div[2]/div[2]/p[1]");
	By BtnIpenTupa16 = By.xpath("/html/body/app-root/div/div/div[2]/div/div/app-procedimientos/table/tbody/tr[1]/td[5]/button");
	By LblTitulo = By.xpath("/html/body/app-root/div/div/div[2]/div/div/app-mis-solicitudes/div/div[1]/div/h1");
			
	
	/* Metodos*/	    
            
    public void clicIpenSolicitud(){ 
    	driver.findElement(optEntityIpen).click();    	
    }  

    public void clicTupa16(){ 
    	driver.findElement(BtnIpenTupa16).click();    	
    }  
        
    public void waitForElementSolicitudPage(){ 
    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT))
    	.until(ExpectedConditions.visibilityOfElementLocated(LblTitulo));	 	
    }  
        
    public void validarMensajeConfirmacion(){
    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"swal2-title\"]")));
    	boolean message_transmision = driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).isDisplayed();
    	Assert.assertTrue(message_transmision, "Visualización del mensaje exitoso"); 	
    }      
    
}
