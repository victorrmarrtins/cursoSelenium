package org.example;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class DesafioCadastro {

    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.gecko.driver", "/gecko/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        page = new CampoTreinamentoPage(driver);
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveRealizarCadastro() {
        page.setNome("Victor");
        Assert.assertEquals("Victor", dsl.obterValueElemento("elementosForm:nome"));

        page.setSobrenome("Martins da Silva");
        Assert.assertEquals("Martins da Silva", dsl.obterValueElemento("elementosForm:sobrenome"));

        page.setSexoMasculino();
        Assert.assertTrue(dsl.verificarSeEstaSelecionado("elementosForm:sexo:0"));

        page.setComidaCarne();
        Assert.assertTrue(dsl.verificarSeEstaSelecionado("elementosForm:comidaFavorita:0"));

        page.setEscolaridadeSuperior();
        Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));

        page.setEsporteNatacao();
        page.setEsporteCorrida();
        List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());

        page.setCadastrar();

        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Victor"));
        Assert.assertEquals("Sobrenome: Martins da Silva", page.obterSobrenomeCadastro());
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Carne", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Esportes: Natacao Corrida", page.obterEsporteCadastro());
    }
}

