package automacoes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

// "http://www.facebook.com/"); 
public class AutomacaoFacebook {
	private WebDriver driver;
	
	@Before
	public void inicalizaCadastroFacebookTeste() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
	}
	@Test
	public void confereObrigatoriedadeNomeTeste() {
		driver.findElement(By.name("firstname")).sendKeys("Asdrubal");
		driver.findElement(By.name("lastname")).sendKeys("Menezes");
		driver.findElement(By.name("reg_email__")).sendKeys("119876353873");
		driver.findElement(By.name("reg_passwd__")).sendKeys("12op##12");
		
		WebElement elemento = driver.findElement(By.name("birthday_day"));
		Select comboDia = new Select (elemento);
		comboDia.selectByVisibleText("4");
		
		WebElement elemento2 = driver.findElement(By.name("birthday_month"));
		Select comboMes = new Select (elemento2);
		comboMes.selectByValue("7");
		
		WebElement elemento3 = driver.findElement(By.name("birthday_year"));
		Select comboAno = new Select (elemento3);
		comboAno.selectByValue("1997");
		
		driver.findElement(By.id("u_0_7")).click();
		
		Assert.assertEquals("Asdrubal", driver.findElement(By.name("firstname")).getAttribute("value"));
	}
	
	@After
	public void fecharNavegadorTeste() {
		driver.quit();
	}

}
