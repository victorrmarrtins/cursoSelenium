package org.example;

import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

    private DSL dsl;

    public CampoTreinamentoPage(WebDriver driver){
        dsl  = new DSL(driver);
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
        return dsl.obterTexto("resultado");
    }

    public String obterNomeCadastro(){
        return dsl.obterTexto("descNome");
    }

    public String obterSobrenomeCadastro(){
        return dsl.obterTexto("descSobrenome");
    }

    public String obterSexoCadastro(){
        return dsl.obterTexto("descSexo");
    }

    public String obterComidaCadastro(){
        return dsl.obterTexto("descComida");
    }

    public String obterEscolaridadeCadastro(){
        return dsl.obterTexto("descEscolaridade");
    }

    public String obterEsporteCadastro(){
        return dsl.obterTexto("descEsportes");
    }

}
