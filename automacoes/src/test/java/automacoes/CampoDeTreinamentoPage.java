package automacoes;

import org.openqa.selenium.WebDriver;

public class CampoDeTreinamentoPage {
	private DSL dsl;
		
	public CampoDeTreinamentoPage(WebDriver driver) {
		dsl = new DSL (driver);
		}
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);	
	}
	public void setSobreNome(String sobreNome) {
	dsl.escrever("elementosForm:sobrenome", sobreNome);
	}
	public void setSexoMasculino() {
		dsl.clicaRadio("elementosForm:sexo:0");
	}
	public void setComidaPizza() {
		dsl.clicaRadio("elementosForm:comidaFavorita:2");
	}
	public void setComidaCarne() {
		dsl.clicaRadio("elementosForm:comidaFavorita:0");
	}
	public void setComidaVegetariana() {
		dsl.clicaRadio("elementosForm:comidaFavorita:3");
	}
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	public void setEsporte(String... valores) {
		for (String valor: valores)
		dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	public void setCadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	public String obterResultado() {
		return dsl.obterTexto2("resultado");
	}
	public String obterNomeCadastro() {
		return dsl.obterTexto2("descNome");
	}
	public String obterSobreNomeCadastro() {
		return dsl.obterTexto2("descSobrenome");
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto2("descSexo");
	}
	public String obterComidaCadastro() {
		return dsl.obterTexto2("descComida");
	}
	public String obterEcolaridadeCadastro() {
		return dsl.obterTexto2("descEscolaridade");
	}
	public String obterEsporteCadastro() {
		return dsl.obterTexto2("descEsportes");
	}
	public void setSexoFemino() {
		dsl.clicaRadio("elementosForm:sexo:1");
		
	}
	public void deveClicarBotaoTabela() {
		dsl.clicarBotaoTabela("Nome", "Maria", "Botao", "elementosForm:tableUsuarios");
	}
	
}