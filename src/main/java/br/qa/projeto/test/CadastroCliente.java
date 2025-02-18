package br.qa.projeto.test;
import br.qa.projeto.page.CadastroClientePage;
import br.qa.projeto.core.DSL;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.qa.projeto.core.DriverFactory.getDriver;

public class CadastroCliente {

    private DSL dsl;
    private CadastroClientePage page;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "/gecko/driver/chromedriver.exe");
        getDriver();
        getDriver().get("http://localhost:4647/sgfpod1/Cad_0002.pod");
        dsl = new DSL();
        page = new CadastroClientePage();
    }

    @After
    public void finaliza(){
       // driver.quit();
    }


}
