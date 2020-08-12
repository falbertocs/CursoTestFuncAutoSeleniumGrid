package automacoes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class geradorDeMassasTeste {
	@Test
	public void colheitaDeMassa() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files (x86)\\\\Java\\\\chromedriver_win326\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.4devs.com.br/");
		driver.manage().window().maximize();
		
		driver.findElementByLinkText("Gerador de Pessoas").click();
		//<a href="/gerador_de_pessoas" title="Gerador de documentos de pessoas (Nome, RG, CPF, CEP, Endereço, etc)">Gerador de Pessoas</a>
}
	

}
