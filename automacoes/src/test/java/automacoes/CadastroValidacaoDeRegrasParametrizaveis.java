package automacoes;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)

public class CadastroValidacaoDeRegrasParametrizaveis {
	private WebDriver driver;
	private DSL dsl;
	private CampoDeTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value = 1)
	public String sobrenome;
	@Parameter (value = 2)
	public String sexo;
	@Parameter (value = 3)
	public List<String> comidas;
	@Parameter (value = 4)
	public String[] esportes;
	@Parameter (value = 5)
	public String msg;
	
		
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoDeTreinamentoPage(driver);
	}
	@Parameters
	public static Collection<Object[]> getCollections(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
			{"Asdrubal", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
			{"Asdrubal", "Oliveira", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
			{"Asdrubal", "Oliveira", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?"},
			{"Asdrubal", "Oliveira", "Masculino", Arrays.asList("Carne"), new String[] {"Karate", "O que eh esporte"}, "Voce faz esporte ou nao?"},
			
		});
	}
	@Test
	public void deveValidarRegras() {
		page.setNome(nome);
		page.setSobreNome(sobrenome);
		
		if(sexo.equals("Masculino")) {
			page.setSexoMasculino();	
		}
		if(sexo.equals("Femino")) {
			page.setSexoFemino();
		}
		
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Pizza")) page.setComidaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariana();
		
		
		page.setEsporte(esportes);
		page.setCadastrar();
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
}
