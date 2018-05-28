package com.tem.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class smokeTest {

	WebDriver driver;	
	
	@Before
	public void beforeTest(){
		System.out.println("Before test run ...");
		//BAJAR DE: https://sites.google.com/a/chromium.org/chromedriver/downloads
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();		
		
	}
	
	@Test
	public void SmokeTest(){
	
		driver.get("http://192.168.72.64:10039/wps/portal/mesaTramitacion/login");
		
		//Login
		WebElement userElement = driver.findElement(By.id("usuario"));
		userElement.sendKeys("arcep1.piu");		
		WebElement passElement = driver.findElement(By.id("ns_Z7_30KEH241J8HQ10A2HRR9EP30G4_contrasena"));
		passElement.sendKeys("indra2017");
		WebElement cmdAceptar = driver.findElement(By.id("ns_Z7_30KEH241J8HQ10A2HRR9EP30G4_botonIniciarSesion"));
		cmdAceptar.click();
		//WebDriverWait wait1 = new WebDriverWait(driver,5);
		
		//Link Mesa Tramitacion		
		WebElement btnElement = driver.findElement(By.linkText("Alta de Solicitud"));
		btnElement.click();
		//WebDriverWait wait2 = new WebDriverWait(driver,5);
		
		//Mesa tramitación - Paso1: Datos Solicitante		
		WebElement selectTipoPersona = driver.findElement(By.name("tipoPersonaIniciaTramiteSeleccionado.codElemento"));
		List<WebElement> optionsTP = selectTipoPersona.findElements(By.tagName("option"));
		for (WebElement option : optionsTP) {
		   if("SOLICITANTE".equals(option.getText()))
		       option.click();   
		}		
		WebElement selectTipoDocumento = driver.findElement(By.name("documentoIdentidadSolicitante.tipoDocumentoIdentidad.codElemento"));
		List<WebElement> optionsTD = selectTipoDocumento.findElements(By.tagName("option"));
		for (WebElement option : optionsTD) {
		   if("DNI".equals(option.getText()))
		       option.click();   
		}
		WebElement eNumDocumento = driver.findElement(By.name("documentoIdentidadSolicitante.numero"));
		eNumDocumento.sendKeys("09189657");
		WebElement eBtnBuscar = driver.findElement(By.id("ns_Z7_30KEH241JGA280AMU9RK7G00H1_btnBuscarSolicitante"));
		eBtnBuscar.click();		
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		WebElement eBtnContinuar = driver.findElement(By.id("ns_Z7_30KEH241JGA280AMU9RK7G00H1_btnValidar"));
		wait3.until(ExpectedConditions.visibilityOf(eBtnContinuar));
		eBtnContinuar.click();		
				
		//Mesa tramitación - Paso2: Datos Solicitud
		WebDriverWait wait4 = new WebDriverWait(driver,30);		
		WebElement eSelectTramite = driver.findElement(By.name("tramiteSeleccionado.codElemento"));
		wait4.until(ExpectedConditions.visibilityOf(eSelectTramite));
		List<WebElement> opTramite = eSelectTramite.findElements(By.tagName("option"));
		for (WebElement option : opTramite) {
		   if("ADMINISTRACIÓN DE APORTES".equals(option.getText()))
		       option.click();   
		}
		WebDriverWait wait5 = new WebDriverWait(driver,30);	
		WebElement eSelectMotivo = driver.findElement(By.name("motivoSeleccionado.codElemento"));
		wait5.until(ExpectedConditions.visibilityOf(eSelectMotivo));
		List<WebElement> opMotivo = eSelectMotivo.findElements(By.tagName("option"));
		for (WebElement option : opMotivo) {
		   if("ACREDITACIÓN ANTICIPADA RÉGIMEN D.L. 19990".equals(option.getText()))
		       option.click();   
		}		
						
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		WebDriverWait wait6 = new WebDriverWait(driver,60);
		WebElement ebotonC = driver.findElement(By.id("ns_Z7_K98A1341J04L10AUOSCVS630D6_radioTipoAportePERI_LABO_FACU"));	
		wait6.until(ExpectedConditions.visibilityOf(ebotonC));	
		((JavascriptExecutor) driver).executeScript("document.getElementById('ns_Z7_K98A1341J04L10AUOSCVS630D6_onpContenidoInt1').style='display: true;';");		
		WebElement eBtnMas= driver.findElement(By.xpath("//div[@class='onpFormBloquesTit']/a"));
		eBtnMas.click();
				
		WebElement eRadioTipoDocEmpl = driver.findElement(By.id("ns_Z7_K98A1341J8UO40A1LQ9LPC10P6_radioRUC"));
		eRadioTipoDocEmpl.click();
		WebElement eSelectTipoDocumentoEmpl = driver.findElement(By.name("empresa.documentoIdentidad.tipoDocumentoIdentidad.codElemento"));
		List<WebElement> optionsTDE = eSelectTipoDocumentoEmpl.findElements(By.tagName("option"));
		for (WebElement option : optionsTDE) {
		   if("REGISTRO ÚNICO DE CONTRIBUYENTES 11 DÍGITOS".equals(option.getText()))
		       option.click();   
		}		
		WebElement eNumDocumentoEmpl = driver.findElement(By.name("empresa.documentoIdentidad.numero"));
		eNumDocumentoEmpl.sendKeys("20374984838");		
		WebElement ebtnBuscar= driver.findElement(By.id("ns_Z7_K98A1341J8UO40A1LQ9LPC10P6_btnBuscar"));
		ebtnBuscar.click();				
		WebDriverWait wait7 = new WebDriverWait(driver,60);
		WebElement eCheckEmpl = driver.findElement(By.id("ns_Z7_K98A1341J8UO40A1LQ9LPC10P6_resultados"));
		wait7.until(ExpectedConditions.visibilityOf(eCheckEmpl));
		eCheckEmpl.click();		
		WebElement eBtnAgregarEmpl = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only botonAgregarEmpleador']"));
		eBtnAgregarEmpl.click();
			
		WebDriverWait wait8 = new WebDriverWait(driver,60);
		WebElement eSelectTipoPlantilla = driver.findElement(By.name("periodoLaboral.tipoPlanilla.codElemento"));
		wait8.until(ExpectedConditions.visibilityOf(eSelectTipoPlantilla));
		List<WebElement> optionsTPL = eSelectTipoPlantilla.findElements(By.tagName("option"));
		for (WebElement option : optionsTPL) {
		   if("MENSUAL".equals(option.getText()))
		       option.click();   
		}
					
		WebElement eSelectCondicion = driver.findElement(By.id("ns_Z7_K98A1341J04L10AUOSCVS630D6_comboCondicionObligatorio"));
		List<WebElement> optionsTCO = eSelectCondicion.findElements(By.tagName("option"));
		for (WebElement option : optionsTCO) {
		   if("EMPLEADO".equals(option.getText()))
		       option.click();   
		}
		WebElement eSelectSectorO = driver.findElement(By.id("ns_Z7_K98A1341J04L10AUOSCVS630D6_comboSectorOcupacionalObligatorio"));
		List<WebElement> optionsSOC = eSelectSectorO.findElements(By.tagName("option"));
		for (WebElement option : optionsSOC) {
		   if("SIN SECTOR OCUPACIONAL DEFINIDO".equals(option.getText()))
		       option.click();   
		}
		
		((JavascriptExecutor) driver).executeScript("document.getElementById('ns_Z7_K98A1341J04L10AUOSCVS630D6_fecIniObligatorio').value='"+"01/01/2012"+"';");
		((JavascriptExecutor) driver).executeScript("document.getElementById('ns_Z7_K98A1341J04L10AUOSCVS630D6_fecFinObligatorio').value='"+"31/03/2012"+"';");	
			
		WebElement eCheckDireccion = driver.findElement(By.name("comboSeleccion1"));
		eCheckDireccion.click();
		
		WebElement eSelectOc = driver.findElement(By.id("ns_Z7_K98A1341J04L10AUOSCVS630D6_comboOcupacionObligatorio"));
		List<WebElement> optionsOCU = eSelectOc.findElements(By.tagName("option"));
		for (WebElement option : optionsOCU) {
		   if("EJECUTIVO".equals(option.getText()))
		       option.click();   
		}	
		
		List<WebElement> eBtnAgregarPL = driver.findElements(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']/span[text()='AGREGAR']"));
		for (WebElement span : eBtnAgregarPL) {
			span.click();   
		}		

		WebElement eBotonFinPaso2 = driver.findElement(By.className("onpBotonPrincipal onpBotonContinuarPaso3"));	
		eBotonFinPaso2.click();
				
		//Mesa tramitación - Paso3: Documentos Requeridos
		
		//Mesa tramitación - Paso4: Generar Cargo
		
		System.out.println(driver.getTitle());
	}
	
	@After
	public void afterTest(){
		System.out.println("After test run ...");
		//driver.quit();
	}
	
}
