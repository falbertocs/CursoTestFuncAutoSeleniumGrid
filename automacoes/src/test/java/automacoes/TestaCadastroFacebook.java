package automacoes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestaCadastroFacebook {
	private static CadastroFacebookPage facebook;
	private static WebDriver driver;
	
	@BeforeClass
	public static void preCondicao (){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
	}
	@Test
	public void preencherNomeESobrenome() {
		facebook.preencherNome("João");
		facebook.preencherSobrenome("Silva");
	}
	@Test
	public void deveLogarComSucesso() {
		facebook.logarComo("jose", "senha");
	}
	@Test
	public void naoDeveLogarSemSenha() {
		facebook.logarComo("Norberto", " ");
	}
	@Test
	public void naoDeveLogarComSenhaErrada() {
		facebook.logarComo("jose", "xfastrw");
	}
	@AfterClass
	public static void encerrrarExecucaoClasse() {
		driver.close();
	}

}
