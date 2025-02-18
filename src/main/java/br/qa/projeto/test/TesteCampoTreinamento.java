package br.qa.projeto.test;

import br.qa.projeto.core.DSL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TesteCampoTreinamento {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.gecko.driver", "/gecko/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void finaliza(){
        driver.quit();
    }

    @Test
    public void deveInteragirComTextField(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste do text field");
        Assert.assertEquals("Teste do text field", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }

    @Test
    public void deveInteragirComTextArea(){
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste do text area");
        Assert.assertEquals("Teste do text area", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }

    @Test
    public void selecRadioButtonMasculino(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    @Test
    public void selecRadioButtonFeminino(){
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
    }

    @Test
    public void selectCheckboxVegetariano(){
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
    }

    @Test
    public void selectCombo(){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("1o grau incompleto");
        Assert.assertEquals("1o grau incompleto", combo.getFirstSelectedOption().getText());
    }

    @Test
    public  void selectComboMultiplo(){
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

        List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());

        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
        opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());
        opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?"));
    }

   /* @Test
    public void selectComboMultiplo() {
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("Corrida");
        List<WebElement> allSelectecOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectecOptions.size());
    }
*/
    @Test
    public void interagirComBotao() {
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    @Ignore
    public void interagirComLink() {
    }

    @Test
    public void deveInteragirComEsperaFixa() throws InterruptedException{
        dsl.clicar("buttonDelay");
        Thread.sleep(5000);
        dsl.escrever("novoCampo", "Deu certo?");
    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException{
        dsl.clicar("buttonDelay");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.escrever("novoCampo", "Deu certo?");
    }

    @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException{
        dsl.clicar("buttonDelay");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escrever("novoCampo", "Deu certo?");
    }


}
