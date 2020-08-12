package automacoes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConhecendoAnotacoesJUnit {
	
	@BeforeClass
	public static void antesDaClasseTeste() {
		System.out.println("Esse � o BeforClasse");
		
	}
	
	@Before
	public void antesDosMetodosTeste() {
		System.out.println("Esse � o Before");
	}
	
	@Test
	public void meuTeste1() {
		System.out.println("Esse � o meu Teste 1");
	}
	
	@Test
	public void meuTeste2() {
		System.out.println("Esse � o meu segundo teste");
	}
	
	@After
	public void depoisDosMetodosTeste() {
		System.out.println("Esse � o After");
	}
	
	@AfterClass
	public static void depoisDasClasses() {
		System.out.println("Esse � o AfterClass");
	}
	

}
