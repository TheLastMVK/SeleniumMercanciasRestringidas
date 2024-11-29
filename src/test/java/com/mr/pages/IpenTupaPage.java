package com.mr.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mr.utils.Base;

public class IpenTupaPage extends Base {
    
    By MsgTransmisionExitosa = By.xpath("//*[@id=\"swal2-title\"]");    
    By btnContinuar = By.className("btn");    
    By pestaProducto = By.id("mat-tab-label-0-1");    
    By btnAddProd = By.className("btn-dashed"); 
    By DwnProUso = By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-ui-cortinilla-producto/mat-dialog-content/div/form/div/div[3]/div/div/button");
    By DwnCabResultado = By.xpath("//*[@id=\"myForm\"]/div/div[10]/div[1]/div/select");
    By DwnDetResultado = By.xpath("//*[@id=\"myForm\"]/div/div[10]/div[1]/div/select/option[2]");
    By DwnCabDetalle = By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/app-detalle-tramite/form/div/div[2]/div/div/select");
    By DwnDetDetalle = By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/app-detalle-tramite/form/div/div[2]/div/div/select/option[2]");
    By DwnCabProFuente = By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-ui-cortinilla-producto/mat-dialog-content/div/form/div/div[1]/div/div/button");
    By BtnTransmitir = By.xpath("/html/body/app-root/div/div/div[2]/div/div/app-registrar-solicitud/div/div[5]/div/button[2]");
    By BtnConfirmarSi = By.xpath("/html/body/div[4]/div/div[6]/button[1]");
       
    public static final String TxtCant = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-ui-cortinilla-producto/mat-dialog-content/div/form/div/div[7]/div/input" ;
    public static final String BtnGuardar = "//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-ui-cortinilla-producto/mat-dialog-content/div/form/div/div[9]/div/button"; 
    
    	
    public static void dropDownByValue(String value, List <WebElement> els){
        for(WebElement e :els){ if(e.getText().trim().contentEquals(value)){ e.click(); break;} }
    }
         
    public void scrollDown() throws InterruptedException {
		Thread.sleep(2000);		
        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();    	
    }
    
    public void clicContinuar(){ 
    	driver.findElement(btnContinuar).click();    	
    }  
    
    public void clicProductos(){ 
    	driver.findElement(pestaProducto).click();
    	driver.findElement(btnAddProd).click();
    }    
    
    public void selectRepresenLegal(String representante) throws InterruptedException {
    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable(DwnCabResultado));
    	WebElement DpwRepLeg = driver.findElement(DwnCabResultado);
	    DpwRepLeg.click();
	    
	    new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable(DwnDetResultado));
	    List<WebElement> LisDpwRep = driver.findElements(DwnDetResultado);
	    dropDownByValue(representante, LisDpwRep);
	    DpwRepLeg.click();	    
    }
    
    public void selectAutorizacionServicio(String informacionautorizacion) throws InterruptedException {
    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable(DwnCabDetalle));
        WebElement DpwAutSer = driver.findElement(DwnCabDetalle);
        DpwAutSer.click();
        
        new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable(DwnDetDetalle));
        List<WebElement> LisDpwAut = driver.findElements(DwnDetDetalle);
        dropDownByValue(informacionautorizacion, LisDpwAut);
        DpwAutSer.click();        
    }
    
    public void selectTipoFuente(String tipofuente) throws InterruptedException {
    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable(DwnCabProFuente));
        WebElement DpwProdFuente = driver.findElement(DwnCabProFuente);
        DpwProdFuente.click();
        
        new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@class=\"form-check-label\"][contains(text(),tipofuente)]"))));
        driver.findElement(By.xpath("//*[@class=\"form-check-label\"][contains(text(),tipofuente)]")).click();
        DpwProdFuente.click();
    }  
    
    public void selectUsoEspecifico(String usoespecifico) throws InterruptedException {
    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable(DwnProUso));	
    	driver.findElement(DwnProUso).click();

    	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable((By.id(usoespecifico))));
    	driver.findElement(By.id(usoespecifico)).click();
    	driver.findElement(DwnProUso).click();
    }  

    public void ingresoCantidad(String cantidad) throws InterruptedException {
        driver.findElement(By.xpath(TxtCant)).sendKeys(cantidad);        
    }  
    
    public void guardarInfoProd() throws InterruptedException {
        driver.findElement(By.xpath(BtnGuardar)).click();   
        Thread.sleep(2000);        
    }
    
    public void aceptarTransmision() throws InterruptedException {
      	new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable((BtnTransmitir)));
        driver.findElement(BtnTransmitir).click();
        driver.findElement(BtnConfirmarSi).click();	      
    }
}
