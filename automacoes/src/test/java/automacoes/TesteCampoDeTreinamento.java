package automacoes;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class TesteCampoDeTreinamento {
	
private WebDriver driver;
private DSL dsl; // Deixando a DSL global
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win32_4\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
	}
	
	@Test
	public void textFieldTeste() {
		
		dsl.escrever("elementosForm:nome", "Teste de Escrita"); // Passando para a Classe DSL o id que deve ser buscado e o que deve ser escrito;
		Assert.assertEquals("Teste de Escrita", dsl.obterValorCampo("elementosForm:nome"));
		
		/*
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de Escrita");
		Assert.assertEquals("Teste de Escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
		*/
		
	}
	
	@Test
	public void deveInteragirComTextAreaTeste() {
		dsl.escrever("elementosForm:sugestoes", "Teste TextArea\\nBarra N Faz pular linha");
		Assert.assertEquals("Teste TextArea\nBarra N Faz pular linha", dsl.obterValorCampo("elementosForm:sugestoes"));
		/*
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste TextArea\nBarra N Faz pular linha");
		Assert.assertEquals("Teste TextArea\nBarra N Faz pular linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
		*/		
	}
	
	@Test
	public void deveInteragirComRadioButtonTeste() {
		
		dsl.clicaRadio("elementosForm:sexo:0");
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		/*
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		*/
	}
	
	@Test
	public void deveInteragirComCheckBoxTeste() {
		/*
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
		*/
			}
	/*
	Selecionando um item em uma lista (combo)id="elementosForm:escolaridade"
	
	Salva a lista na variavel element
	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
	
	Realiza uma nova seleção no combo
		Select combo = new Select(element);
		
		Seleciona o item que estiver na posição 4
		combo.selectByIndex(4);
	*/
	@Test
	public void deveInteragirComComboTeste() {
		
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("Superior", dsl.obterCombo("elementosForm:escolaridade"));
		/*
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(4);
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		driver.quit();
		
		Outra forma de buscar: por value, informo o nome do value
		combo.selectByValue("superior");
		
	 	Outra forma de buscar: por value, informo o nome do value
	 	combo.selectByVisibleText("Superior");
		*/
		}
	
	// Teste para verificar se todos os itens estão corretos na lista elementosForm:escolaridade 
	@Test
	public void deveVerificarValoresNoComboTeste() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions(); // Salva a Litsa completra do atributo na variavel options
		
		Assert.assertEquals(8, options.size()); // Compara a quantidade de intens dentro da lista
		
		boolean encontrou = false;
		for(WebElement option:options) { // Adiciona uma nova varial a lista
			if (option.getText().equals("Superior")){ // Pega o texto da lista e compara se existe um item chamado superior
				encontrou = true;
				break;
			}
		}
		
		Assert.assertTrue(encontrou);
	}
	
	//Selecionar combomultiplo
	@Test
	public void deveVerificarValoresNoComboMultoploTeste() {
		dsl.selecionarCombo("elementosForm:esportes", "futebol");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		/*
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select comboMultiplo = new Select(element);
		comboMultiplo.selectByIndex(0);
		comboMultiplo.selectByValue("futebol");
		comboMultiplo.selectByVisibleText("Corrida");
		comboMultiplo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = comboMultiplo.getAllSelectedOptions();
		Assert.assertEquals(4, allSelectedOptions.size());
				
		//Retira a seleção realizada
		comboMultiplo.deselectByVisibleText("O que eh esporte?");
		
		allSelectedOptions = comboMultiplo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		driver.quit();
		*/
		}
	
	//Como clicar em um botão 
	@Test
	public void deveInteragirComBotao() {
		dsl.clicarBotao("buttonSimple");
		
		/*
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
		/*
		 * Ou também pode ser utilizado da seguinte forma 
		 * driver.findElement(By.id("buttonSimple")).click();
		 * Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
		 */
		
		driver.quit();
	}
	//Clicando em um link
	@Test
	
	public void deveInteragirComLink(){
		dsl.clicarLink("Voltar");
		
		/*
		driver.findElement(By.linkText("Voltar")).click();
		 * Assert.fail();
		 */
		Assert.assertEquals("Voltou!", dsl.obterTexto2("resultado"));
		
		}
	
	//Para burcar texto em uma página 
		@Test
		public void deveSelecionarTextoNaTela(){
						
			Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
			Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
			
			//Assert.assertTrue("Campo de Treinamento", driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
			}
		
		@After
		public void fecharNavegador() {
			driver.quit();
		}
	

}
