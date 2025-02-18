package br.qa.projeto.page;

import br.qa.projeto.core.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

    private DSL dsl;

    public CampoTreinamentoPage(){

        dsl  = new DSL();
    }

    public void setNome(String nome){
        dsl.escrever("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome){
        dsl.escrever("elementosForm:sobrenome", sobrenome);
    }

    public void setSexoMasculino(){
        dsl.clicar("elementosForm:sexo:0");
    }

    public void setSexoFeminino(){
        dsl.clicar("elementosForm:sexo:1");
    }

    public void setComidaCarne(){
        dsl.clicar("elementosForm:comidaFavorita:0");
    }

    public void setComidaFrango(){
        dsl.clicar("elementosForm:comidaFavorita:1");
    }

    public void setComidaPizza(){
        dsl.clicar("elementosForm:comidaFavorita:2");
    }

    public void setComidaVegetariano(){
        dsl.clicar("elementosForm:comidaFavorita:3");
    }

    public void setEscolaridadeSuperior(){
        dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
    }

    public void setEsporteNatacao(){
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
    }

    public void setEsporteCorrida(){
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
    }

    public void setEsporteOqehesporte(){
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
    }

    public void setCadastrar(){
        dsl.clicar("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro(){
        return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
    }

    public String obterNomeCadastro(){
        return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
    }

    public String obterSobrenomeCadastro(){
        return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
    }

    public String obterSexoCadastro(){
        return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
    }

    public String obterComidaCadastro(){
        return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
    }

    public String obterEscolaridadeCadastro(){
        return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
    }

    public String obterEsporteCadastro(){
        return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
    }

}
