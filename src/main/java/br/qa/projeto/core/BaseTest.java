package br.qa.projeto.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.qa.projeto.core.DriverFactory.getDriver;
import static br.qa.projeto.core.DriverFactory.killDriver;

public class BaseTest {

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("screenchot.jpg"));
        if (Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }
}
