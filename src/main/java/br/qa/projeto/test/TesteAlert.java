package br.qa.projeto.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.qa.projeto.core.DriverFactory.getDriver;
import static br.qa.projeto.core.DriverFactory.killDriver;

public class TesteAlert {

    private WebDriver driver;

    @Before
    public void inicializa(){
        getDriver();
        System.setProperty("webdriver.chrome.driver", "/gecko/driver/chromedriver.exe");
        getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void finaliza(){
        killDriver();
    }

    @Test
    public void selectAlertSimples(){
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void selectConfirmAccept() {
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        alert.accept();
    }

    @Test
    public void selectConfirmDismiss() {
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        alert.accept();
    }

    @Test
    public void selectPrompt() {
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alert.getText());
        alert.sendKeys("12");
        alert.accept();
        Assert.assertEquals("Era 12?", alert.getText());
        alert.accept();
        Assert.assertEquals(":D", alert.getText());
        alert.accept();
    }
}