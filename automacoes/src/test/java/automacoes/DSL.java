package automacoes;

import java.util.List;
import java.util.ArrayList;

import javax.swing.ComboBoxEditor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	/*********** TextFiel e TextArea **********/
	public void escrever(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/*********** Radio e Check **********/
	
	public void clicaRadio(By by) {
		driver.findElement(by).click();;
	}
	public void clicaRadio(String id) {
		clicaRadio(By.id(id));
	}
	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	/*********** Combo **********/
	
	public void selecionarCombo(String id, String valor) {
		WebElement elemento = driver.findElement(By.id(id));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}
	public void deselecionarCombo(String id, String valor) {
		WebElement elemento = driver.findElement(By.id(id));
		Select combo = new Select(elemento);
		combo.deselectByVisibleText(valor);
	}
	public String obterCombo(String id) {
		WebElement elemento = driver.findElement(By.id(id));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}
	public List<String> obterValoresCombo(String id){
		WebElement elemento = driver.findElement(By.id("elementosForm:esporte"));
		Select combo = new Select(elemento);
		List<WebElement> allSelectionOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao: allSelectionOptions) {
			valores.add(opcao.getText());
		}
		return valores;
}
	public int obterQuantidadeOpcoesCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao));
			{
			return true;
			}
		}
		return false;
	}
	public void selecionarComboPrime(String radical, String valor) {
		clicaRadio(By.xpath("//*[@id='"+radical+"']/../../span;"));
		clicaRadio(By.xpath("//*[@id='"+radical+"']//li[.='"+valor+"']"));
	}
	/*********** Botao **********/
	
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	public String obterValueElemento(String id) {
		return driver.findElement(By.id(id)).getAttribute("value");
	}
	
	/*********** Link **********/
	
	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	/*********** Texto **********/
	
	public String obterTexto(By by) {
		return driver.findElement(by).getText();		
	}
	public String obterTexto2(String id) {
		return obterTexto(By.id(id));	
	}
	
	/*********** Alerts **********/
	
	public String alertaObterTexto() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
		
	public String alertaObterTextoENega() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}

	public String alertaObterTextoEAceita() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
		}
	/*********** Frames e Janelas **********/
	
	public void entrarFrame(String id) {
		driver.switchTo().frame(id);
	}
	
	public void sairFrame() {
		driver.switchTo().defaultContent();
	}
	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}
	
	/************ JS ***********/
	
		private Object js(String cmd, Object[] param) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js (cmd, param);
	}
	
		/************ Tabela ***********/
		public void clicarBotaoTabela(String coluna, String valor, String colunaBotao, String colunaBusca) {
			//procurar coluna do registro
			WebElement tabela = driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]"));
			int idColuna = obterIndiceColuna(colunaBusca, tabela);
			
			//encontrar linha do registro
			int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
			// procurar coluna do botão
			int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
			
			//clicar no botão da celula encontrada
			WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		}

		private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
			List<WebElement> linhas = (List<WebElement>) tabela.findElement(By.xpath(".//tr/td["+idColuna+"]"));
			int idLinhas = -1;;
			for(int i=0; i<linhas.size(); i++) { // enquando i for menor que o tamanho da coluna incremeta
				if(linhas.get(i).getText().equals(valor)); // Se i = colunaBusca mostra que encontrou a coluna
				idColuna = i + 1;
				break;
			}
			return idLinhas;
		}

		private int obterIndiceColuna(String coluna, WebElement tabela) {
			List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
			int idColuna = -1;;
			for(int i=0; i<colunas.size(); i++) { // enquando i for menor que o tamanho da coluna incremeta
				if(colunas.get(i).getText().equals(coluna)); // Se i = colunaBusca mostra que encontrou a coluna
				idColuna = i + 1;
				break;
			}
			return idColuna;
		}
		


}
