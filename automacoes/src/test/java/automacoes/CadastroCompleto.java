package automacoes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroCompleto {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoDeTreinamentoPage page;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoDeTreinamentoPage(driver);
	}
	
	@Test
	public void cadastroCompletoTeste() {
		page.setNome("Fabio");
		page.setSobreNome("Cruz");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Natação");
		page.setCadastrar();
		
		//Assert.assertTrue(page.obterResultado()).startsWith("Cadastrado!");
		Assert.assertEquals("Nome: Fabio", page.obterNomeCadastro());
		Assert.assertEquals("Sobrenome: Cruz", page.obterSobreNomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: superior", page.obterEcolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
		
		/*
		 * Chamando através da DSL
		 
		dsl.escrever("elementosForm:nome", "Fabio");
		dsl.escrever("elementosForm:sobrenome", "Cruz");
		dsl.clicaRadio("elementosForm:sexo:0");
		dsl.clicaRadio("elementosForm:comidaFavorita:2");
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		//Assert.assertTrue(dsl.obterTexto2("resultado")).startsWith("Cadastrado!");
		//Assert.assertTrue(dsl.obterTexto2("descNome")).endsWith("Fabio");
		Assert.assertEquals("Sobrenome: Cruz", dsl.obterTexto2("descSobrenome"));
		Assert.assertEquals("Sexo: Masculino", dsl.obterTexto2("descSexo"));
		Assert.assertEquals("Comida: Pizza", dsl.obterTexto2("descComida"));
		Assert.assertEquals("Escolaridade: superior", dsl.obterTexto2("descEscolaridade"));
		Assert.assertEquals("Esportes: Natacao Futebol", dsl.obterTexto2("descEsportes"));
		
		/*
		//preencher o campo nome elementosForm:nome
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Fabio");
		
		// preencher o campo sobrenome elementosForm:sobrenome
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Cruz");
		
		// selecionar a opção sexo elementosForm:sexo
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		// selecionar a opção comida favorita elementosForm:comidaFavorita:2
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		// selecionar a escolariadade elementosForm:escolaridade
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(elemento);
		combo.selectByVisibleText("Superior");
		
		// selecionar o esporte id="elementosForm:esportes"
		WebElement escolheEsporte = driver.findElement(By.id("elementosForm:esportes"));
		Select multiplaEscolha = new Select(escolheEsporte);
		multiplaEscolha.selectByVisibleText("Natacao");
		multiplaEscolha.selectByVisibleText("Futebol");
		
		// clicar no botão cadastrar elementosForm:cadastrar
		driver.findElement(By.id("elementosForm:cadastrar")).click();
				
		/*
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");
		new Select(driver.findElement(By.id("elementosForm:esportes"))..selectByVisibleText("Natacao");
		
		
		// confirmar se os dados estão preenchidos corretamente
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Fabio"));
		Assert.assertEquals("Sobrenome: Cruz", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());
		*/
			}
	@Test
	public void deveValidarNomeObrigatorioTeste() {
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		/*
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alerta.getText());
		*/
	}
	@Test
	public void deveValidarSobrenomeObrigatorioTeste() {
		page.setNome("Asdrubal");
		page.setCadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		/*
		 * Chamando DSL
		dsl.escrever("elementosForm:nome", "Asdrubal");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		Identificando elemento
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Fábio");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alerta.getText());
		*/
		}
	@Test
	public void deveValidarSexoObrigatorioTeste() {
		page.setNome("Godofredo");
		page.setSobreNome("Bezerra");
		page.setCadastrar();
		Assert.assertEquals("sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		/*
		dsl.escrever("elementosForm:nome", "Godofredo");
		dsl.escrever("elementosForm:sobrenome", "Bezerra");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Fabio");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Cruz");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alerta.getText());
		*/
	}
	@Test
	public void deveValidarComidaTeste() {
		page.setNome("Astrogilda");
		page.setSobreNome("Arruda");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegetariana();
		page.setCadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
		
		/*
		dsl.escrever("elementosForm:nome", "Astrogilda");
		dsl.escrever("elementosForm:sobrenome", "Arruda");
		dsl.clicaRadio("elementosForm:sexo:1");
		dsl.clicaRadio("elementosForm:comidaFavorita:0");
		dsl.clicaRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
		
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Cynthia");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alerta.getText());
		*/
	}
	@Test
	public void deveEsportistaTeste() {
		page.setNome("Astrogilda");
		page.setSobreNome("Arruda");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEsporte("Futebol", " que eh esporte?");
		page.setCadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
		
		/*
		//dsl.escreve("elementosForm:nome", "Astrogilda");
		//dsl.escreve("elementosForm:sobrenome", "Arruda");
		dsl.clicaRadio("elementosForm:sexo:1");
		dsl.clicaRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	
		/*
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ricardo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Filho");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		Select combo = new Select (driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("O que eh esporte?");

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alerta.getText());
		*/
	}
	@After
	public void finaliza() {
		driver.quit();
	}

	
	
}
