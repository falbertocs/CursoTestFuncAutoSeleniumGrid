package automacoes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAlert {
	
private WebDriver driver;
private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win32_4\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@Test
	public void deveInteragirComAlertaSimples() {
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);
		dsl.escrever("elementosForm:nome", texto);
	
	/*	
	driver.findElement(By.id("alert")).click();
	Alert alert = driver.switchTo().alert();
	String alertaSimples = alert.getText();
	Assert.assertEquals("Alert Simples", alertaSimples);
	alert.accept();
	driver.findElement(By.id("elementosForm:nome")).sendKeys(alertaSimples);
	driver.quit();
	*/
	}
	
	@Test
	public void deveInteragirComConfirmAceito() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		
		/*
		// Clicar no botão com id="confirm"
		driver.findElement(By.id("confirm")).click();
		
		// Mudar o foco da mensagem  e Pegar o Texto da Mensagem 
		Alert alert = driver.switchTo().alert();
		
		//Confere se o texto está igual ao esperado
		Assert.assertEquals("Confirm Simples", alert.getText());
		
		// Aceitar a Mensagem
		alert.accept();
		
		//Fechar navegador
		driver.quit();
		*/
	}
	
	@Test
	public void deveInteragirComConfirmNegado() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Negado", dsl.alertaObterTextoEAceita());
		
		/*
		//Mudar o foco do campo e pegar o texto
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		
		// Clicar no negar 
		alert.dismiss();
		
		Assert.assertEquals("Negado", alert.getText());
		
		// Clicar no negar ou aceitar a mensagem 
		//alert.dismiss();
		alert.accept();
		
		//Fechar navegador
		//driver.quit();
				*/
	}
	@Test
	public void deveInteragirComPrompt() {
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTextoEAceita());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Era :D", dsl.alertaObterTextoEAceita());
		
		/*
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("2637126837612873");
		alerta.accept();
		Assert.assertEquals("Era 2637126837612873?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
		*/
	}
	@After
	public void finaliza() {
		driver.quit();
	}

}
