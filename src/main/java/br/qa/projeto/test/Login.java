package br.qa.projeto.test;
import  static br.qa.projeto.core.DriverFactory.getDriver;

import br.qa.projeto.core.BaseTest;
import br.qa.projeto.page.CadastroClientePage;
import br.qa.projeto.page.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Login extends BaseTest {
        private LoginPage page;
        private CadastroClientePage clientePage;
        private Map<String, Object> vars;
        JavascriptExecutor js;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver", "/gecko/driver/chromedriver.exe");
        getDriver();
        getDriver().get("http://localhost:4647/sgfpod1/Login.pod");
        page = new LoginPage();
        js = (JavascriptExecutor) getDriver();
        vars = new HashMap<String, Object>();
        clientePage = new CadastroClientePage();
    }

    @Test
    public void deveRealizarLogin(){
        page.setUsuario();
        page.setSenha();
        page.setClicarLogin();
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        getDriver().findElement(By.linkText("Cadastros")).click();
        getDriver().findElement(By.cssSelector("#ul1 > li:nth-child(2) > a > span")).click();
        getDriver().findElement(By.cssSelector("#ul110 > .tng-nav-menu-item:nth-child(1) span")).click();
        clientePage.setNome();
        clientePage.setCPFouCNPJ();
        clientePage.setTipoDeContribuinteContribuinte();
        clientePage.setTipoDeContribuinteNaoContribuinte();
        clientePage.setIdentidadeIE();
        clientePage.setUfEmissora();
        clientePage.setTelefone();
        clientePage.setCEP();
        clientePage.setNumeroEndereco();
        clientePage.setTabResponLegal();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clientePage.setGrupo();
        clientePage.setClicarEmpresa();
        clientePage.setEmpresa();
        getDriver().findElement(By.linkText("Inf. Vendas")).click();
        clientePage.setSalvar();
    }


}
