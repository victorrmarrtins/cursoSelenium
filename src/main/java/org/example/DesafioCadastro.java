package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DesafioCadastro {

    @Test
    public void cadastro() {
        System.setProperty("webdriver.gecko.driver", "/gecko/driver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        //Nome
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Victor");
        Assert.assertEquals("Victor", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

        //Sobrenome
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Martins da Silva");
        Assert.assertEquals("Martins da Silva", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));

        //Radio genero
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

        //Check comida
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

        //Escolaridade
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select escolaridade = new Select(element);
        escolaridade.selectByVisibleText("Superior");
        Assert.assertEquals("Superior", escolaridade.getFirstSelectedOption().getText());

        //Esporte
        WebElement esporte = driver.findElement(By.id("elementosForm:esportes"));
        Select comboMult = new Select(esporte);
        comboMult.selectByVisibleText("Natacao");
        comboMult.selectByVisibleText("Corrida");
        List<WebElement> allSelectedOptions = comboMult.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());

        //Cadastrar
        WebElement botaoCadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
        botaoCadastrar.click();

        //Resultados
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Victor"));
        Assert.assertEquals("Sobrenome: Martins da Silva", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Natacao Corrida", driver.findElement(By.id("descEsportes")).getText());
    }
}

