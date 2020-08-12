package automacoes;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteSincronismo {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializaSincronismoTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@Teste
	public void threadSleep() throws InterruptedException {
		//deve utlizar espera fixa
	dsl.clicarBotao("buttonDelay");
	Thread.sleep(30000);
	dsl.escrever("novoCampo", "Deu Certo?");
	}
	
	@After
	public void fecharNavegador() {
		driver.quit();
	}
	
}
