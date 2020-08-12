package automacoes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroFacebookPage {
	
	WebDriver driver;
	
	public CadastroFacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	public CadastroFacebookPage preencherNome(String nome) {
		driver.findElement(By.name("firstname")).sendKeys(nome);
		return this;
	}
	public CadastroFacebookPage preencherSobrenome(String sobrenome) {
		driver.findElement(By.name("lastname")).sendKeys(sobrenome);
		return this;
	}
	public CadastroFacebookPage preencherUsuario(String usuario) {
		driver.findElement(By.name("reg_email__")).sendKeys(usuario);
		return this;
	}
	public CadastroFacebookPage preencherSenha(String senha) {
		driver.findElement(By.name("reg_passwd__")).sendKeys(senha);
		return this;
	}
	public CadastroFacebookPage clicaNoBotaoEntrar() {
		driver.findElement(By.id("u_0_7")).click();
		return this;
	}
	public void logarComo (String user, String pass) {
		preencherUsuario(user).preencherSenha(pass).clicaNoBotaoEntrar();
	}

}
