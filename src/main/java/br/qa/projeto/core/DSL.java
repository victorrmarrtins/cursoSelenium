package br.qa.projeto.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static br.qa.projeto.core.DriverFactory.getDriver;

public class DSL {

    public void escrever(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void  escreverEnter(String id, String texto){
        getDriver().findElement(By.id(id)).sendKeys(Keys.ENTER);
    }

    public void tab (String id){
        getDriver().findElement(By.id(id)).sendKeys(Keys.TAB);
    }

    public void clicar(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void clicarPorLink(String texto){
        getDriver().findElement(By.linkText(texto)).click();
    }

    public void clicarPorCssSelector(String texto){
        getDriver().findElement(By.cssSelector(texto)).click();
    }

    public  void clicarX(String id) { getDriver().findElement(By.xpath(id)).click();}

    public String obterValueElemento(String id){
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    public void escrever(String id, String texto) {
        getDriver().findElement(By.id(id)).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public void enter(String id){getDriver().findElement(By.id(id)).sendKeys(Keys.ENTER);}

    /************ Combo *************/

    public void selecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public boolean verificarSeEstaSelecionado(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public List<String> obterValoresCombo(String id){
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<>();
        for (WebElement opcao: allSelectedOptions){
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoesCombo(String id){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    /************ Alertas *************/


    public String alertaObterTexto() {
        Alert alert = getDriver().switchTo().alert();
        return  alert.getText();
    }

    public String alertaObterTextoEAceita(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public String alertaObterTextoENega() {
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;
    }

    public void alertaEscrever(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /************ Frames e Janelas *************/

    public void entrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void sairFrame(){
        getDriver().switchTo().defaultContent();
    }

    public void trocarJanela(String id){
        getDriver().switchTo().window(id);
    }
}