package automacoes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestPrime {
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	@After
	public void finaliza() {
		driver.quit();
	}/*
	@Test
	public void deveInteragirComRadioPrime(){
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicaRadio(By.xpath("//label[.='Xbox One']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt726:console:0"));
	}
	@Test
	public void deveInteragirComComboPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt726:console", "PS4");
		Assert.assertEquals("PS4", dsl.obterTexto2("j_idt726:console_label"));
	}
	*/

}
