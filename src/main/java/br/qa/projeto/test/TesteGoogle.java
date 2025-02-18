package br.qa.projeto.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.qa.projeto.core.DriverFactory.getDriver;
import static br.qa.projeto.core.DriverFactory.killDriver;

public class TesteGoogle {

    @Test
    public void teste() {
        getDriver();
        System.setProperty("webdriver.chrome.driver", "/gecko/driver/chromedriver.exe");
        getDriver().get("http://www.google.com");
        System.out.println(getDriver().getTitle());
        Assert.assertEquals("Google", getDriver().getTitle());
        killDriver();
    }
}
