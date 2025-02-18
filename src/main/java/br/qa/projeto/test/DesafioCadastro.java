package br.qa.projeto.test;
import br.qa.projeto.page.CampoTreinamentoPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static br.qa.projeto.core.DriverFactory.getDriver;
import static br.qa.projeto.core.DriverFactory.killDriver;


public class DesafioCadastro {

    private WebDriver driver;
    private CampoTreinamentoPage page;

    @Before
    public void inicializa() {
        //System.setProperty("webdriver.gecko.driver", "/gecko/driver/geckodriver.exe");
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "/gecko/driver/chromedriver.exe");
        getDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        page = new CampoTreinamentoPage();
    }

    @After
    public void finaliza() {

        killDriver();
    }

    @Test
    public void deveRealizarCadastro() {
        page.setNome("Victor");
        page.setSobrenome("Martins da Silva");
        page.setSexoMasculino();
        page.setComidaCarne();
        page.setEscolaridadeSuperior();
        page.setEsporteNatacao();
        page.setEsporteCorrida();
        page.setCadastrar();

        Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
        Assert.assertEquals("Victor", page.obterNomeCadastro());
        Assert.assertEquals("Martins da Silva", page.obterSobrenomeCadastro());
        Assert.assertEquals("Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Carne", page.obterComidaCadastro());
        Assert.assertEquals("superior", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Natacao Corrida", page.obterEsporteCadastro());
    }
}

