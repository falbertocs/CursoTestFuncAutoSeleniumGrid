package automacoes;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestGoogle {
	
	@Test
	public void teste() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Java\\chromedriver_win326\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		
		Assert.assertEquals("Google", driver.getTitle());
		
		driver.quit();
		
		/*
		posicionamento do Browser
		driver.manage().window().setPosition(new Point(100, 100));
		
		Dimenrsão do Browser
		driver.manage().window().setSize(new Dimension(1200, 100));
		
		Abrir em tela cheia 
		driver.manage().window().maximize();
		*/


	}

}
