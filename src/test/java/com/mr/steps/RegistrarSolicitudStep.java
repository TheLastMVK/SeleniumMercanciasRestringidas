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


public class RegistrarSolicitudStep extends Base{
	
	protected LoginPage loginPage= new LoginPage();
	protected HomePage homePage= new HomePage();
	protected SolicitudPage solicitudPage= new SolicitudPage();
	protected IpenTupaPage ipenTupaPage= new IpenTupaPage();
	protected IpenTupaPage profilePage= new IpenTupaPage();
	protected Hooks hooks;
	
	public RegistrarSolicitudStep(Hooks hooks) {
		this.hooks = hooks;
	}
	
	@Given("page of MR2 is all ready")
	public void page_of_mr2_is_all_ready()  {	
		homePage.validarTituloHome();	
	}
	
	@When("user select iniciar solicitud button")
	public void user_select_iniciar_solicitud_button() {
		homePage.clicIniciarSolicitud();
	}
    
	@And("user select ipen entity")
	public void user_select_ipen_entity() {
		solicitudPage.clicIpenSolicitud();
	}
		
	@And("register new solicitud {string} and {string} and {string} and {string} and {string}" )
	public void register_new_solicitud(String representante, String informacionautorizacion, String tipofuente, String usoespecifico, String cantidad) throws InterruptedException  {
		solicitudPage.clicTupa16();
		ipenTupaPage.scrollDown();
		ipenTupaPage.selectRepresenLegal(representante);
		
        ipenTupaPage.clicContinuar();  
        Thread.sleep(2000);
        ipenTupaPage.scrollDown();
        
        Thread.sleep(2000);
        ipenTupaPage.selectAutorizacionServicio(informacionautorizacion);
        
        ipenTupaPage.clicProductos();
        Thread.sleep(3000);
                
        ipenTupaPage.selectTipoFuente(tipofuente);
        ipenTupaPage.selectUsoEspecifico(usoespecifico);        
        ipenTupaPage.ingresoCantidad(cantidad);
                
        ipenTupaPage.guardarInfoProd();
        ipenTupaPage.aceptarTransmision();        
	}
	
	@Then("user can see solicitud transmitida exitosamente message")
	public void user_can_see_solicitud_transmitida_exitosamente_message() {		
		solicitudPage.waitForElementSolicitudPage();
		solicitudPage.validarMensajeConfirmacion();
		}

}
