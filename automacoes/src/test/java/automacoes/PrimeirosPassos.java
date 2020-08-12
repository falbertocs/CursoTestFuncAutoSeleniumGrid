package automacoes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeirosPassos {
	
	WebDriver driver;
	
	@Before
	public void abrindoNavegadorTeste() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win32_4\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.navigate().to("http://www.google.com");
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void primeiroTeste() {
				
		// driver.getCurrentUrl(); - retorna uma String com a url atual;
		//driver.getPageSource(); - retorna ums String com o código fonte da pagina atual
				
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//name="q"
		WebElement caixaPesquisa = driver.findElement(By.name("q"));
		caixaPesquisa.getTagName(); // retornará a String do Input
		caixaPesquisa.sendKeys("Teste");
		caixaPesquisa.clear();
	}
	
	@After
	public void fecharNavegadorTeste() {
		
		//driver.close();
	}
	

}
