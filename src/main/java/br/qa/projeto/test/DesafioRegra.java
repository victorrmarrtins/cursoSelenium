package br.qa.projeto.test;

import br.qa.projeto.core.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.qa.projeto.core.DriverFactory.getDriver;
import static br.qa.projeto.core.DriverFactory.killDriver;

public class DesafioRegra {
    //Voltar a esse desafio quando chegar no sincronismo, problema com o firefox se perdendo na hora de achar a chamada do alert

    private DSL dsl;

    @Before
    public void inicializa(){
        getDriver();
        System.setProperty("webdriver.chrome.driver", "/gecko/driver/chromedriver.exe");
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @After
    public void finaliza(){
        killDriver();
    }

    @Test
    public void rnNomeObrigatorio() {
        dsl.clicar("elementosForm:cadastrar");
        Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void rnSobrenomeObrigatorio() {
        dsl.escrever("elementosForm:nome", "Teste");
        dsl.clicar("elementosForm:cadastrar");
        Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void rnSexoObrigatorio() {
        dsl.escrever("elementosForm:nome", "Teste");
        dsl.escrever("elementosForm:sobrenome", "Teste");
        dsl.clicar("elementosForm:cadastrar");
        Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void rnMaisDeUmaOpComida() {
        dsl.escrever("elementosForm:nome", "Teste");
        dsl.escrever("elementosForm:sobrenome", "Teste");
        dsl.clicar("elementosForm:sexo:0");
        dsl.clicar("elementosForm:comidaFavorita:0");
        dsl.clicar("elementosForm:comidaFavorita:3");
        dsl.clicar("elementosForm:cadastrar");
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
    }

    @Test
    public void deveValidarEsporte() {
        dsl.escrever("elementosForm:nome", "Teste");
        dsl.escrever("elementosForm:sobrenome", "Teste");
        dsl.clicar("elementosForm:sexo:0");
        dsl.clicar("elementosForm:comidaFavorita:0");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        dsl.clicar("elementosForm:cadastrar");
        Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
    }
}
