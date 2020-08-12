package automacoes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrameEJanelas {
	
private WebDriver driver;
private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@Test
	public void deveInteragirComFrameTeste() {
		dsl.entrarFrame("Frame1");
		dsl.clicaRadio("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		
		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", msg);
	
		/*
		//Mudar o foco para o fram e
		driver.switchTo().frame("frame1");
		
		//Clicar no Frame Button frameButton
		driver.findElement(By.id("frameButton")).click();
		
		//Muda o foco para o alerta 
		Alert alerta = driver.switchTo().alert();
		String mensagem = alerta.getText();
		Assert.assertEquals("Frame OK!", mensagem);
		
		alerta.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagem);
		driver.quit();
		*/
	}
	
	@Test
	public void deveInteragirComJanelas() {
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		driver.close();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "e agora?");
		
		/*
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("12testando");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("12testando");
		driver.quit();
		*/
	}
	@Test
	public void deveInteragirComFrameEscondido() {
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
	
	@Test
	public void deveInteragirComJanelasSemTituloTeste() {
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String)driver.getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"),"e agora?");
		
		/*
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle()); //Pega o número da pagina principal
		System.out.println(driver.getWindowHandles()); // Pega o número da pop-up
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]); // Muda o foco da página principal para a pop-up e adiciona o número dentro da string na posição 2
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?"); // Escreve na textarea da pop-up
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora??");
		*/
		}
	
	@After
	public void fecharJanela() {
		driver.quit();
	}

}
